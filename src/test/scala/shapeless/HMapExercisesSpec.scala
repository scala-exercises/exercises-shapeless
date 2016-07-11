package shapeless

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapelessex._

class HMapExercisesSpec extends Spec with Checkers {
  def `k/v enforcement` = {
    check(
      Test.testSuccess(
        HMapExercises.kvEnforcement _,
        Option("foo") :: Option(13) :: HNil
      )
    )
  }

  def `map as poly function value` = {
    check(
      Test.testSuccess(
        HMapExercises.mapAsPolyFValue _,
        { "foo" :: 13 :: HNil } :: HNil
      )
    )
  }

}
