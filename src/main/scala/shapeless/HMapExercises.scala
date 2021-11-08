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

package shapelessex

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import shapeless._

/**
 * ==Heterogenous maps==
 *
 * Shapeless provides a heterogenous map which supports an arbitrary relation between the key type
 * and the corresponding value type,
 * {{{
 * class BiMapIS[K, V]
 * implicit val intToString = new BiMapIS[Int, String]
 * implicit val stringToInt = new BiMapIS[String, Int]
 *
 * val hm = HMap[BiMapIS](23 -> "foo", "bar" -> 13)
 * //val hm2 = HMap[BiMapIS](23 -> "foo", 23 -> 13)   // Does not compile
 * }}}
 *
 * @param name
 *   HMap
 */
object HMapExercises extends AnyFlatSpec with Matchers with org.scalaexercises.definitions.Section {

  object Helper {
    class BiMapIS[K, V]
    implicit val intToString = new BiMapIS[Int, String]
    implicit val stringToInt = new BiMapIS[String, Int]

    val hm = HMap[BiMapIS](23 -> "foo", "bar" -> 13)
    // val hm2 = HMap[BiMapIS](23 -> "foo", 23 -> 13)   // Does not compile
  }

  import Helper._

  /**
   * Key/value relation to be enforced: Strings map to Ints and vice versa
   */
  def kvEnforcement(res0: Option[String], res1: Option[Int]) = {
    hm.get(23) should be(res0)
    hm.get("bar") should be(res1)
  }

  /**
   * And in much the same way that an ordinary monomorphic Scala map can be viewed as a monomorphic
   * function value, so too can a heterogenous shapeless map be viewed as a polymorphic function
   * value,
   */
  def mapAsPolyFValue(res0: String :: Int :: HNil) = {
    import hm._
    val l = 23 :: "bar" :: HNil
    val m = l map hm
    m should be(res0)
  }

}
