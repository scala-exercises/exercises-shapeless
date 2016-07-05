package shapelessex

import org.scalatest._
import shapeless._

import scala.util.Try

/** == Testing for non-compilation ==
  *
  * Libraries like shapeless which make extensive use of type-level computation and implicit resolution often need to
  * provide guarantees that certain expressions *don't* typecheck. Testing these guarantees is supported in shapeless via
  * the `illTyped` macro,
  * {{{
  * import shapeless.test.illTyped
  *
  * scala> illTyped { """1+1 : Boolean""" }
  *
  * scala> illTyped { """1+1 : Int""" }
  * <console>:19: error: Type-checking succeeded unexpectedly.
  * Expected some error.
  * illTyped { """1+1 : Int""" }
  * }}}
  *
  * @param name type_checking
  */
object TypeCheckingExercises extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** The testing library ScalaTest also has a way of checking that a snippet of code
    * does not compile: pass it in to `assertTypeError`. What will happen if we combine
    * `illTyped` and `assertTypeError`? (Hint: it's like applying a double negative.)
    */
  def typeCheckingTest(res0: Boolean, res1: Boolean) = {

    import shapeless.test.illTyped

    val matchedTypes = Try { assertTypeError("illTyped { \"val a: Int = 1\" }") }.isSuccess
    matchedTypes should be(res0)

    val mismatchedTypes = Try { assertTypeError("illTyped { \"val a: String = 1\" }") }.isSuccess
    mismatchedTypes should be(res1)
  }
}
