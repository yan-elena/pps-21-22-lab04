package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters

/** solution at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(size: Int, mines: Int) extends Logics:
  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    OptionConverters.toJava(None) // Option => Optional converter

  def won: Boolean = false
