package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  // test("adding ints") {
  //   assert(1 + 2 === 3)
  // }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "s1 union s2 should contain elements in s1")
      assert(contains(s, 2), "s1 union s2 should contain elements in s2")
      assert(!contains(s, 3), "s1 union s2 should not contain elements not in s1 or s2")
    }
  }

  test("intersect contains elements which are in both sets") {
    new TestSets {
      val s = intersect(s1, s2)

      assert(!contains(s, 1), "elements in s1 but not in s2 should not be present")
      assert(!contains(s, 2), "elements in s2 but not in s1 should not be present")
    }
  }

  test("diff contains only elements which are in s1 but not in s2") {
    new TestSets {
      val s = diff(s1, s2)

      assert(contains(s, 1), "diff(s1, s2) should contain elements in s1")
      assert(!contains(s, 2), "diff(s1, s2) should not contain elements in s2")
    }
  }

  test("filter contains only a set's elements which are accepted by a given predicate") {
    new TestSets {
      val s = filter((x: Int) => List(1, 2, 3).contains(x), (n: Int) => n < 3)
      val t = filter((x: Int) => x <= 1000, (x: Int) => x % 2 == 0)

      assert(contains(s, 1))
      assert(contains(s, 2))
      assert(!contains(s, 3))
      assert(!contains(t, 1))
    }
  }

  test("forall returns true only when all elements in s satisfies p") {
    new TestSets {
      val s = (x: Int) => List(1, 3, 5, 7, 9).contains(x)
      val t = (x: Int) => x % 2 == 0

      assert(forall(s, (x: Int) => x % 2 == 1))
      assert(!forall(s, (x: Int) => x < 9))
      assert(forall(t, (x: Int) => x % 2 == 0))
    }
  }

  test("exists returns true only when there exists one element in s satisfies p") {
    new TestSets {
      val s = (x: Int) => List(1, 2, 3, 4).contains(x)
      val t = (x: Int) => List(1, 3, 4, 5, 7, 1000).contains(x)

      assert(exists(s, (x: Int) => x == 2))
      assert(!exists(t, (x: Int) => x == 2))
    }
  }

  test("map transforms a given set into another one") {
    new TestSets {
      val s = (x: Int) => List(1, 3, 4, 5, 7, 1000).contains(x)
      val minusOne = (x: Int) => x - 1

      assert(contains(map(s, minusOne), 999))
    }
  }
}
