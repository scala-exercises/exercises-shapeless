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
 * ==Singleton-typed literals==
 *
 * Although Scala's typechecker has always represented singleton types for literal values
 * internally, there has not previously been syntax available to express them, other than by
 * [modifying the compiler][literaltype]. shapeless adds support for singleton-typed literals via
 * implicit macros.
 *
 * @param name
 *   singletons_literals
 */
object SingletonExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   * Singleton types bridge the gap between the value level and the type level and hence allow the
   * exploration in Scala of techniques which would typically only be available in languages with
   * support for full-spectrum dependent types. The latest iteration of shapeless records makes a
   * start on that. Another simpler application is the use of Int literals to index into HLists and
   * tuples,
   */
  def indexHListAndTuples(res0: String, res1: String) = {
    import syntax.std.tuple._

    val hlist = 23 :: "foo" :: true :: HNil
    hlist(1) should be(res0)

    val tuple = (23, "foo", true)
    tuple(1) should be(res1)
  }

  import shapeless._

  /**
   * The examples in the shapeless tests and the following illustrate other possibilities,
   * {{{
   * import shapeless._, syntax.singleton._
   * }}}
   */
  def narrow1(res0: Witness) =
    res0.value == 23 should be(true)

  /**
   */
  def narrow2(res0: Witness) =
    res0.value == "foo" should be(true)

  /**
   */
  def select(res0: Int, res1: String) = {
    val (wTrue, wFalse) = (Witness(true), Witness(false))

    type True  = wTrue.T
    type False = wFalse.T

    trait Select[B] { type Out }

    implicit val selInt    = new Select[True] { type Out = Int }
    implicit val selString = new Select[False] { type Out = String }

    def select(b: WitnessWith[Select])(t: b.instance.Out) = t

    select(true)(23) should be(res0)

    // select(true)("foo")
    // error: type mismatch;
    // found   : String("foo")
    // required: Int
    //              select(true)("foo")
    //                           ^

    // select(false)(23)
    // error: type mismatch;
    // found   : Int(23)
    // required: String

    select(false)("foo") should be(res1)
  }

}
