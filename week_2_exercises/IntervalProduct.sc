object IntervalProduct {
  def intervalProduct(f: Int => Int)(a: Int, b: Int) = {
    def product(a: Int, acc: Int): Int = {
      if (a > b) {
        acc
      } else {
        product(a + 1, acc * f(a))
      }
    }

    if (a > b) {
      0

    } else {
      product(a, 1)
    }
  }                                               //> intervalProduct: (f: Int => Int)(a: Int, b: Int)Int

  intervalProduct(x => x)(1, 5)                   //> res0: Int = 120
  intervalProduct(x => x)(3, 1)                   //> res1: Int = 0
  intervalProduct(x => x)(2, 2)                   //> res2: Int = 2
  intervalProduct(x => x)(30, 50)                 //> res3: Int = -146800640
  
  def factorial(n: Int): Int = {
    intervalProduct(x => x)(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(0)                                    //> res4: Int = 0
  factorial(1)                                    //> res5: Int = 1
  factorial(2)                                    //> res6: Int = 2
  factorial(5)                                    //> res7: Int = 120
  factorial(6)                                    //> res8: Int = 720
}