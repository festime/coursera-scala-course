package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }


  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("times returns a list of (Char, Int) about char frequency") {
    assert(times(List('a', 'a')) === List(('a', 2)))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("combine of leaf list") {
    val leaflist = List(Leaf('e', 2), Leaf('t', 3), Leaf('x', 4))
    assert(combine(leaflist) === List(Leaf('x',4), Fork(Leaf('e',2),Leaf('t',3),List('e', 't'),5)))
  }

  test("combine of leaf list whose length is less than 2") {
    val leaflist = List(Fork(Leaf('e',2),Leaf('t',3),List('e', 't'),5))
    assert(combine(leaflist) === List(Fork(Leaf('e',2),Leaf('t',3),List('e', 't'),5)))
  }


  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }


  test("convert the code tree of string `hello`") {
    assert(
      convert(createCodeTree("hello".toList)) ===
      List(('l',List(0)), ('o',List(1, 0)), ('e',List(1, 1, 0)), ('h',List(1, 1, 1)))
    )
  }


  test("quickEncode of string `hello`") {
    assert(
      quickEncode(createCodeTree("hello".toList))("hello".toList) ===
      List(1, 1, 1, 1, 1, 0, 0, 0, 1, 0)
    )
  }
}
