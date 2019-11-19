/*
 *  scala-exercises - exercises-shapeless
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package shapeless

import org.scalacheck.ScalacheckShapeless._
import org.scalaexercises.Test
import org.scalatest.refspec.RefSpec
import org.scalatestplus.scalacheck.Checkers
import shapelessex._

class HMapExercisesSpec extends RefSpec with Checkers {
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
