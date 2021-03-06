package leetcode.p1078

import leetcode.p1078.Solution._
import org.scalatest.{FunSpec, Matchers}

class SolutionSpec extends FunSpec with Matchers {

  describe("findOcurrences") {

    it("case of plain text") {
      val text = "alice is a good girl she is a good student"
      val first = "a"
      val second = "good"
      val expected = Array("girl", "student")

      assert(expected === findOcurrences(text, first, second))
      assert(expected === findOcurrences_(text, first, second))
      assert(expected === findOcurrences__(text, first, second))
    }

    it("case of repeat words") {
      val text = "we will we will we will"
      val first = "we"
      val second = "will"
      val expected = Array("we", "we")

      assert(expected === findOcurrences(text, first, second))
      assert(expected === findOcurrences_(text, first, second))
      assert(expected === findOcurrences__(text, first, second))
    }

  }

}
