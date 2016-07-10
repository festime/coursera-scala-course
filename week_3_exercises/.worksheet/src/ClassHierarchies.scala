object ClassHierarchies {
  abstract class TopLevel {   // abstract class
    def method1(x: Int): Int  // abstract method
    
    // concrete method?
    def method2(x: Int): Int = x * 11
  }
  
  class Level1 extends TopLevel {
    def method1(x: Int): Int = x * 11

    // TopLevel's method2 needs to be explicitly overriden
    override def method2(x: Int): Int = { x % 11 }
  }
  
  // defines a singleton object. No other instance can be created
  object MyObject extends TopLevel {
    def heroService = { "Hero is comming!" }

    // method1 in TopLevel is abstract
    // need to be implemented
    def method1(x: Int): Int =
      x +
      x +
      x
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(693); 
  
  val foo = new Level1;System.out.println("""foo  : ClassHierarchies.Level1 = """ + $show(foo ));$skip(18); val res$0 = 
  foo.method2(10);System.out.println("""res0: Int = """ + $show(res$0));$skip(26); val res$1 = 
  
  MyObject.heroService;System.out.println("""res1: String = """ + $show(res$1));$skip(22); val res$2 = 
  MyObject.method1(3);System.out.println("""res2: Int = """ + $show(res$2))}
}
