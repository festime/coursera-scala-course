object MyClass {
  class MyClass(x: Int, y: Int) {
    require(y > 0, "y must be positive")
    
    def this(x: Int) {
      this(x, x * 10)
    }

    def nb1 = x
    def nb2 = y
    def plusOne(n: Int) = n + 1

    private def test(a: Int): Int = { a % 10 }

    val nb3 = x + y
    override def toString = "Hello " + x
  }
  
  val mc = new MyClass(1, 2)                      //> mc  : MyClass.MyClass = Hello 1
  val mcc = new MyClass(13)                       //> mcc  : MyClass.MyClass = Hello 13

  println(mc.nb1)                                 //> 1
  println(mc.nb2)                                 //> 2
  println(mc.nb3)                                 //> 3
  println(mc)                                     //> Hello 1
  println(mcc.nb1)                                //> 13
  println(mcc.nb2)                                //> 130
  println(mcc.nb3)                                //> 143
  println(mcc)                                    //> Hello 13
  
  mcc plusOne 10                                  //> res0: Int = 11
  mcc.plusOne(10)                                 //> res1: Int = 11
}