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

class PolySpec extends RefSpec with Checkers {
  def `poly choose` = {
    check(
      Test.testSuccess(
        PolyExercises.exerciseChoose _,
        Option(1) :: Option('a') :: HNil
      )
    )
  }

  def `pair apply` = {
    check(
      Test.testSuccess(
        PolyExercises.exercisePairApply _,
        Option(1) :: Option('a') :: HNil
      )
    )
  }

  def `mono choose` = {
    check(
      Test.testSuccess(
        PolyExercises.exerciseMonomorphicChoose _,
        Option(1) :: Option(2) :: HNil
      )
    )
  }

  def `ex size` = {
    check(
      Test.testSuccess(
        PolyExercises.exerciseSize _,
        1 :: 3 :: 4 :: 5 :: HNil
      )
    )
  }

}
