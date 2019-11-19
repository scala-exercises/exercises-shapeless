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

class LensesExercisesSpec extends RefSpec with Checkers {

  def `get a field` = {
    check(
      Test.testSuccess(
        LensesExercises.get _,
        37 :: HNil
      )
    )
  }

  def `set a field` = {
    check(
      Test.testSuccess(
        LensesExercises.set _,
        38 :: HNil
      )
    )
  }

  def `modify a field` = {
    check(
      Test.testSuccess(
        LensesExercises.modify _,
        38 :: HNil
      )
    )
  }

  def `read a nested field` = {
    check(
      Test.testSuccess(
        LensesExercises.readNested _,
        "Southover Street" :: HNil
      )
    )
  }

  def `update a nested field` = {
    check(
      Test.testSuccess(
        LensesExercises.updateNested _,
        "Montpelier Road" :: HNil
      )
    )
  }

}
