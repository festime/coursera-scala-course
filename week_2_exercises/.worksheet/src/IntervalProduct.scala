object IntervalProduct {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(289); 
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
  };System.out.println("""intervalProduct: (f: Int => Int)(a: Int, b: Int)Int""");$skip(33); val res$0 = 

  intervalProduct(x => x)(1, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(32); val res$1 = 
  intervalProduct(x => x)(3, 1);System.out.println("""res1: Int = """ + $show(res$1));$skip(32); val res$2 = 
  intervalProduct(x => x)(2, 2);System.out.println("""res2: Int = """ + $show(res$2));$skip(34); val res$3 = 
  intervalProduct(x => x)(30, 50);System.out.println("""res3: Int = """ + $show(res$3));$skip(74); 
  
  def factorial(n: Int): Int = {
    intervalProduct(x => x)(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$4 = 
  
  factorial(0);System.out.println("""res4: Int = """ + $show(res$4));$skip(15); val res$5 = 
  factorial(1);System.out.println("""res5: Int = """ + $show(res$5));$skip(15); val res$6 = 
  factorial(2);System.out.println("""res6: Int = """ + $show(res$6));$skip(15); val res$7 = 
  factorial(5);System.out.println("""res7: Int = """ + $show(res$7));$skip(15); val res$8 = 
  factorial(6);System.out.println("""res8: Int = """ + $show(res$8))}
}
