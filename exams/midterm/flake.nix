{
  description = "DS 644 Midterm Exam";
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
            scheme-medium
            latex-bin
            latexmk
            exam
            geometry
            amsmath
            amstex
            amscls
            mathtools
            comment
            mathalpha
            bbold
            newunicodechar
            background
            everypage;
      };
    in rec {
      packages = {
        document = pkgs.stdenvNoCC.mkDerivation rec {
          name = "ds644-midterm-exam";
          src = self;
          buildInputs = [ pkgs.coreutils tex ];
          phases = ["unpackPhase" "buildPhase" "installPhase"];
          buildPhase = ''
            export PATH="${pkgs.lib.makeBinPath buildInputs}";
            mkdir -p .cache/texmf-var
            env TEXMFHOME=.cache TEXMFVAR=.cache/texmf-var \
              latexmk -interaction=nonstopmode -pdf -lualatex -f \
              ./exams/midterm/midterm.tex
            env TEXMFHOME=.cache TEXMFVAR=.cache/texmf-var \
              latexmk -interaction=nonstopmode -pdf -lualatex -f \
              ./exams/midterm/midterm-SOLUTIONS.tex
          '';
          installPhase = ''
            mkdir -p $out
            cp ./exams/midterm/midterm.pdf ./exams/midterm/midterm-SOLUTIONS.pdf $out/
          '';
        };
      };
      defaultPackage = packages.document;
    });
}
