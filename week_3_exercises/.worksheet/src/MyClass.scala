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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(358); 
  
  val mc = new MyClass(1, 2);System.out.println("""mc  : MyClass.MyClass = """ + $show(mc ));$skip(28); 
  val mcc = new MyClass(13);System.out.println("""mcc  : MyClass.MyClass = """ + $show(mcc ));$skip(19); 

  println(mc.nb1);$skip(18); 
  println(mc.nb2);$skip(18); 
  println(mc.nb3);$skip(14); 
  println(mc);$skip(19); 
  println(mcc.nb1);$skip(19); 
  println(mcc.nb2);$skip(19); 
  println(mcc.nb3);$skip(15); 
  println(mcc);$skip(20); val res$0 = 
  
  mcc plusOne 10;System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
  mcc.plusOne(10);System.out.println("""res1: Int = """ + $show(res$1))}
}
