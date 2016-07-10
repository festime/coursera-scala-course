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
  }
  
  val foo = new Level1                            //> foo  : ClassHierarchies.Level1 = ClassHierarchies$Level1@51521cc1
  foo.method2(10)                                 //> res0: Int = 10
  
  MyObject.heroService                            //> res1: String = Hero is comming!
  MyObject.method1(3)                             //> res2: Int = 9
}