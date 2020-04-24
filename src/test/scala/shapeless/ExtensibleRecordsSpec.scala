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

class ExtensibleRecordsSpec extends RefSpec with Checkers {
  def `result types` = {
    check(
      Test.testSuccess(
        ExtensibleRecordsExercises.resultTypes _,
        "Benjamin Pierce" :: "Types and Programming Languages" :: 262162091 :: 44.11 :: HNil
      )
    )
  }

  def `record values` = {
    check(
      Test.testSuccess(
        ExtensibleRecordsExercises.values _,
        ("Benjamin Pierce" :: "Types and Programming Languages" :: 262162091 :: 44.11 :: HNil) :: HNil
      )
    )
  }

  def `record update` = {
    check(
      Test.testSuccess(
        ExtensibleRecordsExercises.updated _,
        46.11 :: true :: {
          "Benjamin Pierce" :: "Types and Programming Languages" :: 46.11 :: true :: HNil
        } :: HNil
      )
    )
  }

}
