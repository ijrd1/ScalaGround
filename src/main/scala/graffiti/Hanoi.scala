package graffiti

/** H(n) = H(n-1) + H(1) + H(n-1) */
object Hanoi {
  /** A `move`
    *
    * @param n disk. 1 is the smallest, n is the biggest
    * @param x peg move from. init is left
    * @param y peg to go. init is middle
    * @param z peg via. init is right
    */
  def move(n: Int, x: String, y: String, z: String): Unit = {
    if (n > 0) {
      move(n - 1, x, z, y)
      println(s"$n, $x -> $y")
      move(n - 1, z, y, x)
    }
  }

  def move_(n: Int, from: String, to: String, via: String): Unit = {
    if (n < 1) return

    if (n == 1) {
      println(s"$from -> $to")
    } else {
      move_(n - 1, from, via, to)
      move_(1, from, to, via)
      move_(n - 1, via, to, from)
    }
  }

  def move___(pos: Pos, rest: List[Pos]): Unit = {
    val Pos(n, from, to, via) = pos
    if (n < 1) return

    if (n == 1) {
      println(s"$from -> $to")
      if (rest.nonEmpty) move___(rest.head, rest.tail)
    } else {
      val pos1 = Pos(n - 1, from, via, to)
      val pos2 = Pos(1, from, to, via)
      val pos3 = Pos(n - 1, via, to, from)
      move___(pos1, pos2 :: pos3 :: rest)
    }
  }

  def hanoi(n: Int): Array[String] = {
    val buff = scala.collection.mutable.ArrayBuffer.empty[String]

    def _move(n: Int, from: String, to: String, via: String) {
      if (n > 0) {
        _move(n - 1, from, via, to)
        buff.append(s"$from -> $to")
        _move(n - 1, via, to, from)
      }
    }

    _move(n, "left", "middle", "right")
    buff.toArray
  }

  def main(args: Array[String]): Unit = {
    move(3, "left", "middle", "right")
    println()
    move___(Pos(3, "left", "middle", "right"), Nil)
    println()
    move_(3, "left", "middle", "right")
  }

}

case class Pos(n: Int, from: String, to: String, via: String)
