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
import shapeless.syntax.std.tuple._
import shapelessex._

class TuplesHListExercisesSpec extends RefSpec with Checkers {

  def `head op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.head _,
        23 :: HNil
      )
    )
  }

  def `tail op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.tail _,
        ("foo", true) :: HNil
      )
    )
  }

  def `drop op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.drop _,
        Tuple1(true) :: HNil
      )
    )
  }

  def `take op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.take _,
        (23, "foo") :: HNil
      )
    )
  }

  def `split op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.split _,
        (23, "foo", true).split(1) :: HNil
      )
    )
  }

  def `prepend op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.prepend _,
        (23, "foo", true) :: HNil
      )
    )
  }

  def `append op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.append _,
        (23, "foo", true) :: HNil
      )
    )
  }

  def `concatenate op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.concatenate _,
        (23, "foo", true, 2.0) :: HNil
      )
    )
  }

  def `map op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.map _,
        (Option(23), Option("foo"), Option(true)) :: HNil
      )
    )
  }

  def `flatMap op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.flatMap _,
        (23, "foo", true, 2.0) :: HNil
      )
    )
  }

  def `fold op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.fold _,
        11 :: HNil
      )
    )
  }

  def `toHList op` = {
    check(
      Test.testSuccess(
        TuplesHListExercises.toHList _,
        { 23 :: "foo" :: true :: HNil } :: HNil
      )
    )
  }

}
