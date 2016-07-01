package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) {
        1
      } else {
        pascal(c - 1, r - 1) + pascal(c, r - 1)
      }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      val charsLength = chars.length

      def findLeft(index: Int): Int = {
        if (index >= charsLength) {
          index

        } else if (chars(index) == ')') {
          -1

        } else if (chars(index) == '(') {
          val continuedIndex = findRight(index + 1)

          findLeft(continuedIndex)

        } else {
          findLeft(index + 1)
        }
      }

      def findRight(index: Int): Int = {
        if (index >= charsLength) {
          -1

        } else if (chars(index) == ')') {
          index + 1

        } else if (chars(index) == '(') {
          val continuedIndex = findRight(index + 1)
          
          findRight(continuedIndex)

        } else {
          findRight(index + 1)
        }
      }

      findLeft(0) != -1
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      
      def countHelper(targetMoney: Int, coinsKindNumber: Int): Int = {
        if (targetMoney == 0) {
          1

        } else if (targetMoney < 0 || coinsKindNumber < 0) {
          0

        } else if(coinsKindNumber < coins.length && coinsKindNumber >= 0 && targetMoney > 0 && targetMoney <= money) {
          countHelper(targetMoney, coinsKindNumber - 1) +
          countHelper(targetMoney - coins(coinsKindNumber), coinsKindNumber)

        } else {
          0
        }
      }

      countHelper(money, coins.length - 1)
    }
  }
