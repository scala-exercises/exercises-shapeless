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

class SizedExercisesSpec extends Spec with Checkers {
  def `Sized usage` = {
    check(
      Test.testSuccess(
        SizedExercises.sizedEx _,
        1 :: HNil
      )
    )
  }
}
