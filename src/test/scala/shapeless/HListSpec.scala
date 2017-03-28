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

class HListSpec extends Spec with Checkers {
  def `map op` = {
    check(
      Test.testSuccess(
        HListExercises.exerciseMap _,
        Option(1) :: Option("foo") :: HNil
      )
    )
  }

  def `flatMap op` = {
    check(
      Test.testSuccess(
        HListExercises.exerciseFlatMap _,
        23 :: "foo" :: true :: HNil
      )
    )
  }

  def `fold op` = {
    check(
      Test.testSuccess(
        HListExercises.exerciseFold _,
        11 :: HNil
      )
    )
  }

  def `zipper op` = {
    check(
      Test.testSuccess(
        HListExercises.exerciseZipper _,
        1 :: ("wibble", 45) :: 3.0 :: 1 :: 3.0 :: HNil
      )
    )
  }

  def `covariant op` = {
    check(
      Test.testSuccess(
        HListExercises.exerciseCovariant _,
        true :: HNil
      )
    )
  }

  def `unify op` = {
    check(
      Test.testSuccess(
        HListExercises.exerciseUnify _,
        true :: true :: HNil
      )
    )
  }

}
