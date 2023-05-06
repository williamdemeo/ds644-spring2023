package recursion
import common._

object Main {

  /**
   * Exercise 1
   */
  def balance(chars: String): Boolean = {
    
    def balanceAux(cs: List[Char], acc: Int): Boolean =
      if (acc < 0)
        false
      else
        cs match {
          case Nil => if (acc == 0) true else false
          case c :: cs => 
            if (c == '(') 
              balanceAux(cs, acc + 1)
            else if (c == ')')
              balanceAux(cs, acc - 1)
            else
              balanceAux(cs, acc)
        }

    balanceAux(chars.toList, 0)
  }

  /**
   * Exercise 2
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def countChangeAux(moneyLeft: Int, coinsLeft: List[Int]): Int =  {
      if (moneyLeft < 0 || (moneyLeft > 0 && coinsLeft == Nil))
        0                       // can't make change with this combination
      else if (moneyLeft == 0)
        1                       // found a combination!
      else {
        val countWithHead = countChangeAux(moneyLeft - coinsLeft.head, coinsLeft)
        val countWithoutHead = countChangeAux(moneyLeft, coinsLeft.tail)
        countWithHead + countWithoutHead
      }
    }

    countChangeAux(money, coins)
  }
}
