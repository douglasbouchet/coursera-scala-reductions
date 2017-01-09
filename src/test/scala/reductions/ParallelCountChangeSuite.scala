package reductions

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import reductions.ParallelCountChange._

@RunWith(classOf[JUnitRunner])
class ParallelCountChangeSuite extends FunSuite {

  test("countChange should return 0 for money < 0") {
    def check(money: Int, coins: List[Int]) = 
      assert(countChange(money, coins) == 0,
        s"countChang($money, _) should be 0")

    check(-1, List())
    check(-1, List(1, 2, 3))
    check(-Int.MinValue, List())
    check(-Int.MinValue, List(1, 2, 3))
  }

  test("countChange should return 1 when money == 0") {
    def check(coins: List[Int]) = 
      assert(countChange(0, coins) == 1,
        s"countChang(0, _) should be 1")

    check(List())
    check(List(1, 2, 3))
    check(List.range(1, 100))
  }

  test("countChange should return 0 for money > 0 and coins = List()") {
    def check(money: Int) = 
      assert(countChange(money, List()) == 0,
        s"countChang($money, List()) should be 0")

    check(1)
    check(Int.MaxValue)
  }

  test("countChange should work when there is only one coin") {
    def check(money: Int, coins: List[Int], expected: Int) =
      assert(countChange(money, coins) == expected,
        s"countChange($money, $coins) should be $expected")

    check(1, List(1), 1)
    check(2, List(1), 1)
    check(1, List(2), 0)
    check(Int.MaxValue, List(Int.MaxValue), 1)
    check(Int.MaxValue - 1, List(Int.MaxValue), 0)
  }

  test("countChange should work for multi-coins") {
    def check(money: Int, coins: List[Int], expected: Int) =
      assert(countChange(money, coins) == expected,
        s"countChange($money, $coins) should be $expected")

    check(50, List(1, 2, 5, 10), 341)
    check(250, List(1, 2, 5, 10, 20, 50), 177863)
  }

  test("parCountChange with moneyThreshold should produce correct result when there is only one coin and the amount is equal to the value of the coin ::1") {
    val result = parCountChange(1, List(1), moneyThreshold(1))
    assert(1 == result, s"Result was $result" )
  }

//
//  test("upsweep should correctly compute the tree on the indices 1 until 5 of a 5 element array for threshold 1") {
//    val result = upsweep(Array(1,2,3,4,5), 1, 5, 1)
//    val expected = Node(Node(Leaf(1,2,0), Leaf(2,3,0)), Node(Leaf(3,4,0), Leaf(4,5,0)))
//
//    assert(result == expected, s"Not same $result and $expected")
//  }

  test("parCountChange with totalCoinsThreshold should produce correct result when there is only one coin and the amount is equal to the value of the coin") {
    val result = parCountChange(2, List(2), totalCoinsThreshold(1))
    assert(1 == result, s"Result was $result")
  }

  test("parCountChange with totalCoinsThreshold should produce correct output when there are six coins and the amount is 250") {

  }

  test("parCountChange with totalCoinsThreshold should produce correct output when there are four coins and the amount is 50") {

  }

  test("parCountChange with totalCoinsThreshold should produce correct output when there are two coins and the amount is 1") {
    val result = parCountChange(1, List(1, 2), totalCoinsThreshold(2))
    assert(1 == result, s"Result was $result")
  }
}
