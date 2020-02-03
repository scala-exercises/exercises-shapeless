/*
 *  scala-exercises - exercises-shapeless
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
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

/** == Facilities for abstracting over arity ==
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

  /** Abstracting over arity
   */
  def arityTest(res0: Int, res1: Int) = {
    applyProduct((1, 2))((_: Int) + (_: Int)) should be(res0)
    applyProduct((1, 2, 3))((_: Int) * (_: Int) * (_: Int)) should be(res1)
  }

}
