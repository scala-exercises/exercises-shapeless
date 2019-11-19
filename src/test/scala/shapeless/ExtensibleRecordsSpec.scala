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

class ExtensibleRecordsSpec extends RefSpec with Checkers {
  def `result types` = {
    check(
      Test.testSuccess(
        ExtensibleRecordsExercises.resultTypes _,
        "Benjamin Pierce" :: "Types and Programming Languages" :: 262162091 :: 44.11 :: HNil
      )
    )
  }

  def `record values` = {
    check(
      Test.testSuccess(
        ExtensibleRecordsExercises.values _,
        ("Benjamin Pierce" :: "Types and Programming Languages" :: 262162091 :: 44.11 :: HNil) :: HNil
      )
    )
  }

  def `record update` = {
    check(
      Test.testSuccess(
        ExtensibleRecordsExercises.updated _,
        46.11 :: true :: {
          "Benjamin Pierce" :: "Types and Programming Languages" :: 46.11 :: true :: HNil
        } :: HNil
      )
    )
  }

}
