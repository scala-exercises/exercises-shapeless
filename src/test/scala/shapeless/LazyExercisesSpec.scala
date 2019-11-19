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

class LazyExercisesSpec extends RefSpec with Checkers {

  def `lazy helps avoiding divergence` = {
    check(
      Test.testSuccess(
        LazyExercises.lazyExercise _,
        "Cons(1, Cons(2, Cons(3, Nil)))" :: HNil
      )
    )
  }

}
