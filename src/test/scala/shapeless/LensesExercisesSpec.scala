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

class LensesExercisesSpec extends RefSpec with Checkers {

  def `get a field` = {
    check(
      Test.testSuccess(
        LensesExercises.get _,
        37 :: HNil
      )
    )
  }

  def `set a field` = {
    check(
      Test.testSuccess(
        LensesExercises.set _,
        38 :: HNil
      )
    )
  }

  def `modify a field` = {
    check(
      Test.testSuccess(
        LensesExercises.modify _,
        38 :: HNil
      )
    )
  }

  def `read a nested field` = {
    check(
      Test.testSuccess(
        LensesExercises.readNested _,
        "Southover Street" :: HNil
      )
    )
  }

  def `update a nested field` = {
    check(
      Test.testSuccess(
        LensesExercises.updateNested _,
        "Montpelier Road" :: HNil
      )
    )
  }

}
