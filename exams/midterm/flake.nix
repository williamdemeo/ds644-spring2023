{
  description = "Build LaTeX document with minted";

#  inputs.flake-utils.url = "github:numtide/flake-utils";
  inputs = {
    nixpkgs.url = github:NixOS/nixpkgs/nixos-21.05;
    flake-utils.url = github:numtide/flake-utils;
  };

  outputs = { self, nixpkgs, flake-utils }:
    with flake-utils.lib; eachSystem allSystems (system:
    let
      pkgs = nixpkgs.legacyPackages.${system};
      tex = pkgs.texlive.combine {
          inherit (pkgs.texlive)
            #scheme-minimal
            scheme-medium
            latex-bin
            latexmk
            exam
            framed
            titlesec
            cleveref
            multirow
            wrapfig
            tabu
            threeparttable
            threeparttablex
            makecell
            environ
              # biblatex
              # biber
            fvextra
            upquote
            catchfile
            xstring
            csquotes
            minted
            dejavu
            comment
            footmisc
            xltabular
            ltablex
            background
            everypage
            pygmentex
            ;
      };
    in rec {
      packages = {
        document = pkgs.stdenvNoCC.mkDerivation rec {
          name = "latex-demo-document";
          src = self;
          buildInputs = [ pkgs.coreutils tex ];
          phases = ["unpackPhase" "buildPhase" "installPhase"];
          buildPhase = ''
            export PATH="${pkgs.lib.makeBinPath buildInputs}";
            mkdir -p .cache/texmf-var
            env TEXMFHOME=.cache TEXMFVAR=.cache/texmf-var \
              latexmk -interaction=nonstopmode -pdf -lualatex \
              exams/midterm/000-main.tex
          '';
          installPhase = ''
            mkdir -p $out
            cp document.pdf $out/
          '';
        };
      };
      defaultPackage = packages.document;
    });
}


#     {
#       templates.document = {
#         path = ./.;
#         description = "LaTeX document with minted support";
#       };

#       lib.latexmk = import ./build-document.nix;

#       defaultTemplate = self.templates.document;
#     } // flake-utils.lib.eachDefaultSystem (system:
#       let
#         pkgs = import nixpkgs { inherit system; };

#         latex-packages = with pkgs; [
#           (texlive.combine {
#             inherit (texlive)
#               scheme-medium
#               exam
#               framed
#               titlesec
#               cleveref
#               multirow
#               wrapfig
#               tabu
#               threeparttable
#               threeparttablex
#               makecell
#               environ
#               # biblatex
#               # biber
#               fvextra
#               upquote
#               catchfile
#               xstring
#               csquotes
#               minted
#               dejavu
#               comment
#               footmisc
#               xltabular
#               ltablex
#               background
#               everypage
#               ;
#           })
#           which
#           python39Packages.pygments
#         ];

#         dev-packages = with pkgs; [
#           texlab
#           zathura
#           wmctrl
#         ];
#       in
#       rec {
#         devShell = pkgs.mkShell {
#           buildInputs = [ latex-packages dev-packages ];
#         };

#         packages = flake-utils.lib.flattenTree {
#           document = import ./build-document.nix {
#             inherit pkgs;
#             texlive = latex-packages;
#             shellEscape = true;
#             minted = true;
#             SOURCE_DATE_EPOCH = toString self.lastModified;
#           };
#         };

#         defaultPackage = packages.document;
#       }
#     );
# }
