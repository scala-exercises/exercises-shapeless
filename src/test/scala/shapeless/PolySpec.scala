/*
 * scala-exercises - exercises-shapeless
 * Copyright (C) 2015-2016 47 Degrees, LLC. <http://www.47deg.com>
 */

package shapeless

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapelessex._

class PolySpec extends Spec with Checkers {
  def `poly choose` = {
    check(
      Test.testSuccess(
        PolyExercises.exerciseChoose _,
        Option(1) :: Option('a') :: HNil
      )
    )
  }

  def `pair apply` = {
    check(
      Test.testSuccess(
        PolyExercises.exercisePairApply _,
        Option(1) :: Option('a') :: HNil
      )
    )
  }

  def `mono choose` = {
    check(
      Test.testSuccess(
        PolyExercises.exerciseMonomorphicChoose _,
        Option(1) :: Option(2) :: HNil
      )
    )
  }

  def `ex size` = {
    check(
      Test.testSuccess(
        PolyExercises.exerciseSize _,
        1 :: 3 :: 4 :: 5 :: HNil
      )
    )
  }

}
