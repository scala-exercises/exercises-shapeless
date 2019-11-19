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

class AritySpec extends RefSpec with Checkers {
  def `abstracting over arity` = {
    check(
      Test.testSuccess(
        ArityExercises.arityTest _,
        3 :: 6 :: HNil
      )
    )
  }
}
