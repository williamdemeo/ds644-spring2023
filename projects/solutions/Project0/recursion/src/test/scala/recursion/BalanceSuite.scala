package recursion

import org.scalatest.funsuite.AnyFunSuite

class BalanceSuite extends AnyFunSuite {
  
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))"))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)"))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)"))
  }

  test("balance: counting is not enough") {
    assert(!balance("())("))
  }
}
