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
 * ==Coproducts and discriminated unions==
 *
 * shapeless has a Coproduct type, a generalization of Scala's `Either` to an arbitrary number of
 * choices. Currently it exists primarily to support `Generic` (see the next section), but will be
 * expanded analogously to `HList` in later releases. Currently `Coproduct` supports mapping,
 * selection and unification
 *
 * @param name
 *   coproducts
 */
object CoproductExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  object Helper {
    type ISB = Int :+: String :+: Boolean :+: CNil

    object sizeM extends Poly1 {
      implicit def caseInt     = at[Int](i => (i, i))
      implicit def caseString  = at[String](s => (s, s.length))
      implicit def caseBoolean = at[Boolean](b => (b, 1))
    }

    val isb = Coproduct[ISB]("foo")
  }

  import Helper._

  /**
   * {{{
   * type ISB = Int :+: String :+: Boolean :+: CNil
   *
   * val isb = Coproduct[ISB]("foo")
   * }}}
   */
  def selection(res0: Option[Int], res1: Option[String]) = {
    isb.select[Int] should be(res0)

    isb.select[String] should be(res1)
  }

  /**
   * Coproduct also supports mapping given a polymorphic function such as
   * {{{
   * object sizeM extends Poly1 {
   * implicit def caseInt = at[Int](i => (i, i))
   * implicit def caseString = at[String](s => (s, s.length))
   * implicit def caseBoolean = at[Boolean](b => (b, 1))
   * }
   * }}}
   */
  def mapping(res0: Option[(String, Int)]) = {
    val m = isb map sizeM

    m.select[(String, Int)] should be(res0)
  }

  /**
   * In the same way that adding labels To the elements of an HList gives us a record, adding labels
   * to the elements of a Coproduct gives us a discriminated union.
   */
  def unionE(res0: Option[Int], res1: Option[String], res2: Option[Boolean]) = {
    import union._, syntax.singleton._

    type U = Union.`'i -> Int, 's -> String, 'b -> Boolean`.T

    val u = Coproduct[U](Symbol("s") ->> "foo") // Inject a String into the union at label 's

    u.get(Symbol("i")) should be(res0)
    u.get(Symbol("s")) should be(res1)
    u.get(Symbol("b")) should be(res2)
  }

}
