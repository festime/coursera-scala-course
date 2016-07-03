object TailRecursiveSum {
  // a higher order function is a function which
  // accepts some function as parameter or
  // returns some function
	def sum(f: Int => Int, a: Int, b: Int): Int = {
	  def loop(a: Int, acc: Int): Int = {
	    if (a > b) acc
	    else loop(a + 1, acc + f(a))
	  }

	  loop(a, 0)
	}                                         //> sum: (f: Int => Int, a: Int, b: Int)Int

  // first argument is an anonymous function
  // pass an Int x, returns x
	sum(x => x, 1, 10)                        //> res0: Int = 55
  // first arguemnt is an anonymous function
  // pass an Int x, returns x * x
	sum(x => x * x, 1, 4)                     //> res1: Int = 30
}