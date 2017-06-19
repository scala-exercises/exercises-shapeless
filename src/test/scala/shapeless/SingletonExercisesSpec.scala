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

class SingletonExercisesSpec extends Spec with Checkers {

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
