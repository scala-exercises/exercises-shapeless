/*
 * Copyright 2016-2020 47 Degrees Open Source <https://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
