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

class AutoTypeClassSpec extends RefSpec with Checkers {
  def `monoid derivation` = {
    check(
      Test.testSuccess(
        AutoTypeClassExercises.monoidDerivation _,
        36 :: "foobar" :: true :: "foobar" :: 4.0 :: HNil
      )
    )
  }
}
