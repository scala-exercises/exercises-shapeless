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

class SingletonExercisesSpec extends RefSpec with Checkers {

  def `index into HList and Tuples` = {
    check(
      Test.testSuccess(
        SingletonExercises.indexHListAndTuples _,
        "foo" :: "foo" :: HNil
      )
    )
  }

  def `witness select` = {
    check(
      Test.testSuccess(
        SingletonExercises.select _,
        23 :: "foo" :: HNil
      )
    )
  }

  // TODO disabled until divergent implicit expansion is fixed for singleton types on scalacheck-shapeless int lib
  //   https://gitter.im/milessabin/shapeless?at=56fcf50fbbffcc665faad6e5
  /*  def `narrow 1` = {
    check(
      Test.testSuccess(
        SingletonExercises.narrow1 _,
        23.narrow :: HNil
      )
    )
  }*/

}
