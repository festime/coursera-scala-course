object TailRecursiveFactorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(106); 
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(161); 
    
  def tailRecursiveFactorial(n: Int): Int = {
    def loop(n: Int, acc: Int): Int =
      if (n == 0) acc else loop(n - 1, acc * n)
    
    loop(n, 1)
  };System.out.println("""tailRecursiveFactorial: (n: Int)Int""");$skip(23); val res$0 = 
    
  
  factorial(5);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  factorial(0);System.out.println("""res1: Int = """ + $show(res$1));$skip(15); val res$2 = 
  factorial(1);System.out.println("""res2: Int = """ + $show(res$2));$skip(16); val res$3 = 
  factorial(10);System.out.println("""res3: Int = """ + $show(res$3));$skip(31); val res$4 = 
  
  tailRecursiveFactorial(0);System.out.println("""res4: Int = """ + $show(res$4));$skip(28); val res$5 = 
  tailRecursiveFactorial(1);System.out.println("""res5: Int = """ + $show(res$5));$skip(28); val res$6 = 
  tailRecursiveFactorial(5);System.out.println("""res6: Int = """ + $show(res$6));$skip(29); val res$7 = 
  tailRecursiveFactorial(10);System.out.println("""res7: Int = """ + $show(res$7))}
}
