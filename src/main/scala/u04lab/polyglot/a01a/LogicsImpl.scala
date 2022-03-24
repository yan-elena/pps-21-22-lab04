package u04lab.polyglot.a01a
import Logics.*
import u04lab.code.List
import u04lab.code.List.*

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  private val FAILURES = 5
  private val random = Random()
  private val boatRow = random.nextInt(size)
  private val boatCol = random.nextInt(size - boat + 1)
  private var hitList: List[(Integer, Integer)] = Nil()
  private var failures = 0

  println(s"row: $boatRow col: $boatCol")

  override def hit(row: Int, col: Int) =
    if row == boatRow && col >= boatCol && col < boatCol + boat then
      hitList = append(hitList, Cons((row, col), Nil()))
      if length(hitList) == boat then Result.WON else Result.HIT
    else
      failures = failures + 1
      if failures == FAILURES then Result.LOST else Result.MISS