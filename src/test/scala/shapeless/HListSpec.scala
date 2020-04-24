/*
 * Copyright 2016-2020 47 Degrees <https://47deg.com>
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

class HListSpec extends RefSpec with Checkers {
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
