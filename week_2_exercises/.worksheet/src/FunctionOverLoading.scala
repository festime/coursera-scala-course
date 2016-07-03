object FunctionOverLoading {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(110); 
  //def sum(a: Int, b: Int) = a + b
  def sum(a: Int, b: Int, c: Int) = a + b + c;System.out.println("""sum: (a: Int, b: Int, c: Int)Int""");$skip(32); val res$0 = 
  
  //sum(1, 2)
  sum(1, 2, 3);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  sum(4, 5, 6);System.out.println("""res1: Int = """ + $show(res$1))}
}
