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

class CoproductSpec extends RefSpec with Checkers {
  def `selection op` = {
    check(
      Test.testSuccess(
        CoproductExercises.selection _,
        { None: Option[Int] } :: Option("foo") :: HNil
      )
    )
  }

  def `mapping op` = {
    check(
      Test.testSuccess(
        CoproductExercises.mapping _,
        Option(("foo", 3)) :: HNil
      )
    )
  }

  def `union op` = {
    check(
      Test.testSuccess(
        CoproductExercises.unionE _,
        { None: Option[Int] } :: Option("foo") :: { None: Option[Boolean] } :: HNil
      )
    )
  }

}
