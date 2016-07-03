object TailRecursiveSum {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(309); 
  // a higher order function is a function which
  // accepts some function as parameter or
  // returns some function
	def sum(f: Int => Int, a: Int, b: Int): Int = {
	  def loop(a: Int, acc: Int): Int = {
	    if (a > b) acc
	    else loop(a + 1, acc + f(a))
	  }

	  loop(a, 0)
	};System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(96); val res$0 = 

  // first argument is an anonymous function
  // pass an Int x, returns x
	sum(x => x, 1, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(102); val res$1 = 
  // first arguemnt is an anonymous function
  // pass an Int x, returns x * x
	sum(x => x * x, 1, 4);System.out.println("""res1: Int = """ + $show(res$1))}
}
