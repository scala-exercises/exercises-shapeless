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

class TypeCheckingExercisesSpec extends RefSpec with Checkers {
  def `testing for non-compilation` = {
    check(
      Test.testSuccess(
        TypeCheckingExercises.typeCheckingTest _,
        true :: false :: HNil
      )
    )
  }
}
