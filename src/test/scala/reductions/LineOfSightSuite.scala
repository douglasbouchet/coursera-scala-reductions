package reductions

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner]) 
class LineOfSightSuite extends FunSuite {
  import LineOfSight._
  test("lineOfSight should correctly handle an array of size 4") {
    val output = new Array[Float](4)
    lineOfSight(Array[Float](0f, 1f, 8f, 9f), output)
    assert(output.toList == List(0f, 1f, 4f, 4f))
  }


  test("upsweepSequential should correctly handle the chunk 1 until 4 of an array of 4 elements") {
    val res = upsweepSequential(Array[Float](0f, 1f, 8f, 9f), 1, 4)
    assert(res == 4f)
  }

  test("upsweep should correctly handle the chunk 1 until 4 of an array of 4 elements") {
    val res = upsweep(Array[Float](0f, 1f, 8f, 9f), 1, 4, 1)
    val expected = Node(Leaf(1,2,1), Node(Leaf(2,3,4), Leaf(3,4,3)))
    assert(res == expected)
  }


  test("downsweepSequential should correctly handle a 4 element array when the starting angle is zero") {
    val output = new Array[Float](4)
    downsweepSequential(Array[Float](0f, 1f, 8f, 9f), output, 0f, 1, 4)
    assert(output.toList == List(0f, 1f, 4f, 4f))
  }

  test("downsweep should correctly handle a 4 element array when the starting angle is zero") {
    val output = new Array[Float](4)
    val t = Node(Leaf(1,2,1), Node(Leaf(2,3,4), Leaf(3,4,3)))
    downsweep(Array[Float](0f, 1f, 8f, 9f), output, 0f, t)
    assert(output.toList == List(0f, 1f, 4f, 4f))
  }


  test("downsweep should correctly handle trees with a single leaf") {
//List(0.0, 12.0, 12.0, 12.0, 12.0) did not equal List(0.0, 7.0, 7.0, 11.0, 12.0)
  }

  test("parLineOfSight should invoke the parallel construct 30 times (15 times during upsweep and 15 times during downsweep) for an array of size 17, with threshold 1") {

  }

  test("downsweep should correctly compute the output for a tree with 4 leaves when the starting angle is zero") {

  }

  test("downsweep should correctly compute the output for a non-zero starting angle") {

  }

  test("parLineOfSight should correctly compute the output for threshold 3") {
    //[Observed Error] List(NaN, 9.0, 9.0, 9.0, 9.0, 9.0) did not equal List(0.0, 9.0, 9.0, 9.0, 9.0, 9.0)
  }

  test("parLineOfSight should call parallel constuct 6 times, where the last two parallel constructs should update the 4 sections of the array (1 until 5), (5 until 9), (9 until 13), (13 until 17), respectively") {

  }

  test("parLineOfSight should correctly compute the output for threshold 2") {

  }
}

