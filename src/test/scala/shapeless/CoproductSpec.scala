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

class CoproductSpec extends Spec with Checkers {
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
