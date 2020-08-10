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

class GenericExercisesSpec extends RefSpec with Checkers {
  def `Generic from to` = {
    check(
      Test.testSuccess(
        GenericExercises.genericE _,
        { 23 :: "foo" :: true :: HNil } :: 13 :: HNil
      )
    )
  }

  def `structural recursive transformation` = {
    check(
      Test.testSuccess(
        GenericExercises.structural _,
        2 :: 3 :: 4 :: HNil
      )
    )
  }

  def `labelled generics` = {
    check(
      Test.testSuccess(
        GenericExercises.labelled _,
        44.11 :: 46.11 :: true :: HNil
      )
    )
  }
}
