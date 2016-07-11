package shapeless

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapelessex._

class AritySpec extends Spec with Checkers {
  def `abstracting over arity` = {
    check(
      Test.testSuccess(
        ArityExercises.arityTest _,
        3 :: 6 :: HNil
      )
    )
  }
}
