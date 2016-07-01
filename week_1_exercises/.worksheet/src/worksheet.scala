object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  def abs(x:Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(130); 

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x);System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(86); 

  def isGoodEnough(guess: Double, x: Double) = {
    abs((guess - x) / x) < 0.01
  };System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(67); 

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2;System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(42); 

  def sqrt(x: Double) = sqrtIter(1.0, x);System.out.println("""sqrt: (x: Double)Double""");$skip(16); val res$0 = 
  
  sqrt(1e-6);System.out.println("""res0: Double = """ + $show(res$0))}
}
