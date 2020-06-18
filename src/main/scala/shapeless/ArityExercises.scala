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
import ops.function._
import syntax.std.function._

object Helper {
  def applyProduct[P <: Product, F, L <: HList, R](
      p: P
  )(f: F)(implicit gen: Generic.Aux[P, L], fp: FnToProduct.Aux[F, L => R]) =
    f.toProduct(gen.to(p))
}

/**
 * == Facilities for abstracting over arity ==
 *
 * Conversions between tuples and `HList`'s, and between ordinary Scala functions of arbitrary arity and functions which
 * take a single corresponding `HList` argument allow higher order functions to abstract over the arity of the functions
 * and values they are passed
 * {{{
 * import syntax.std.function._
 * import ops.function._
 *
 * def applyProduct[P <: Product, F, L <: HList, R](p: P)(f: F)
 * (implicit gen: Generic.Aux[P, L], fp: FnToProduct.Aux[F, L => R]) =
 * f.toProduct(gen.to(p))
 * }}}
 *
 * @param name arity
 */
object ArityExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {
  import Helper._

  /**
   * Abstracting over arity
   */
  def arityTest(res0: Int, res1: Int) = {
    applyProduct((1, 2))((_: Int) + (_: Int)) should be(res0)
    applyProduct((1, 2, 3))((_: Int) * (_: Int) * (_: Int)) should be(res1)
  }

}
