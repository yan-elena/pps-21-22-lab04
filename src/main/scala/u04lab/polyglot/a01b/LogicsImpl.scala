package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    OptionConverters.toJava(None) // Option => Optional converter

  def won: Boolean = false
