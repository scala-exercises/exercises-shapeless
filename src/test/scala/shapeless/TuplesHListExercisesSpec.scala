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
import shapeless.syntax.std.tuple._
import shapelessex._

class TuplesHListExercisesSpec extends RefSpec with Checkers {

  def `head op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.head _,
        23 :: HNil
      )
    )
  }

  def `tail op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.tail _,
        ("foo", true) :: HNil
      )
    )
  }

  def `drop op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.drop _,
        Tuple1(true) :: HNil
      )
    )
  }

  def `take op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.take _,
        (23, "foo") :: HNil
      )
    )
  }

  def `split op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.split _,
        (23, "foo", true).split(1) :: HNil
      )
    )
  }

  def `prepend op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.prepend _,
        (23, "foo", true) :: HNil
      )
    )
  }

  def `append op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.append _,
        (23, "foo", true) :: HNil
      )
    )
  }

  def `concatenate op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.concatenate _,
        (23, "foo", true, 2.0) :: HNil
      )
    )
  }

  def `map op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.map _,
        (Option(23), Option("foo"), Option(true)) :: HNil
      )
    )
  }

  def `flatMap op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.flatMap _,
        (23, "foo", true, 2.0) :: HNil
      )
    )
  }

  def `fold op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.fold _,
        11 :: HNil
      )
    )
  }

  def `toHList op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.toHList _,
        { 23 :: "foo" :: true :: HNil } :: HNil
      )
    )
  }

}
