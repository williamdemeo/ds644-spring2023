package funsets

import common._

/**
 * Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type IntSet = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: IntSet, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): IntSet = x => (x == elem)

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: IntSet, t: IntSet): IntSet = x => s(x) || t(x)

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: IntSet, t: IntSet): IntSet = x => s(x) && t(x)

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: IntSet, t: IntSet): IntSet = x => s(x) && !t(x)

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: IntSet, p: Int => Boolean): IntSet = x => s(x) && p(x)

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: IntSet, p: Int => Boolean): Boolean = {
    
    def forall_aux(a: Int): Boolean = {
      if (a == bound + 1) true
      else if (!s(a) || p(a)) forall_aux(a+1)
      else false
    }
    
    forall_aux(-bound)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: IntSet, p: Int => Boolean): Boolean = {
    def exists_aux(a: Int): Boolean = {
      if (a == bound + 1) false
      else if (s(a) && p(a)) true
      else exists_aux(a+1)
    }
    exists_aux(-bound)
  }

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: IntSet, f: Int => Int): IntSet = x => exists(s, y => s(y) && (f(y) == x))

  /**
   * Displays the contents of a set
   */
  def toString(s: IntSet): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: IntSet) = {
    println(toString(s))
  }
}
