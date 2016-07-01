object TailRecursiveFactorial {
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int
    
  def tailRecursiveFactorial(n: Int): Int = {
    def loop(n: Int, acc: Int): Int =
      if (n == 0) acc else loop(n - 1, acc * n)
    
    loop(n, 1)
  }                                               //> tailRecursiveFactorial: (n: Int)Int
    
  
  factorial(5)                                    //> res0: Int = 120
  factorial(0)                                    //> res1: Int = 1
  factorial(1)                                    //> res2: Int = 1
  factorial(10)                                   //> res3: Int = 3628800
  
  tailRecursiveFactorial(0)                       //> res4: Int = 1
  tailRecursiveFactorial(1)                       //> res5: Int = 1
  tailRecursiveFactorial(5)                       //> res6: Int = 120
  tailRecursiveFactorial(10)                      //> res7: Int = 3628800
}