package funsets

object Main extends App {
  import FunSets._
  println("The statement \"{1} contains 1\" is " + contains(x => x==1, 1) + ".")
}
