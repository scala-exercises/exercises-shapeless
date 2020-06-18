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

object GenericHelper {
  case class Foo(i: Int, s: String, b: Boolean)

  val fooGen = Generic[Foo]

  val foo = Foo(23, "foo", true)

  import poly._

  // Simple recursive case class family
  sealed trait Tree[T]
  case class Leaf[T](t: T)                          extends Tree[T]
  case class Node[T](left: Tree[T], right: Tree[T]) extends Tree[T]

  // Polymorphic function which adds 1 to any Int and is the identity
  // on all other values
  // format: OFF
  object inc extends -> ((i: Int) => i + 1)
  // format: ON
  case class Book(author: String, title: String, id: Int, price: Double)
  case class ExtendedBook(author: String, title: String, id: Int, price: Double, inPrint: Boolean)
}

/**
 * == Generic representation of (sealed families of) case classes ==
 *
 * The `Iso`s of earlier shapeless releases have been completely reworked as the new `Generic` type, which closely
 * resembles the [[https://wiki.haskell.org/GHC.Generics generic programming capabilities introduced to GHC 7.2]].
 *
 * `Generic[T]`, where `T` is a case class or an abstract type at the root of a case class hierarchy, maps between values
 * of `T` and a generic sum of products representation (`HList`s and `Coproduct`s),
 *
 * @param name generic
 */
object GenericExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {
  import GenericHelper._

  /**
   * {{{
   * case class Foo(i: Int, s: String, b: Boolean)
   *
   * val fooGen = Generic[Foo]
   *
   * val foo = Foo(23, "foo", true)
   * }}}
   *
   * We can convert back and forth case class to their HList Generic representation
   */
  def genericE(res0: fooGen.Repr, res1: Int) = {
    val l = fooGen.to(foo)
    l should be(res0)
    val r      = 13 :: l.tail
    val newFoo = fooGen.from(r)
    newFoo.i should be(res1)
  }

  /**
   * Typically values of Generic for a given case class are materialized using an implicit macro,
   * allowing a wide variety of structural programming problems to be solved with no or minimal boilerplate.
   * In particular the existing lens, Scrap Your Boilerplate and generic zipper implementations are now available
   * for any case class family (recursive families included, as illustrated below) without any additional boilerplate being required
   * {{{
   * import poly._
   *
   * // Simple recursive case class family
   * sealed trait Tree[T]
   * case class Leaf[T](t: T) extends Tree[T]
   * case class Node[T](left: Tree[T], right: Tree[T]) extends Tree[T]
   *
   * // Polymorphic function which adds 1 to any Int and is the identity
   * // on all other values
   * object inc extends ->((i: Int) => i+1)
   * }}}
   */
  def structural(res0: Int, res1: Int, res2: Int) = {

    val tree: Tree[Int] =
      Node(
        Leaf(1),
        Node(
          Leaf(2),
          Leaf(3)
        )
      )

    // Transform tree by applying inc everywhere
    everywhere(inc)(tree) should be(
      Node(
        Leaf(res0),
        Node(
          Leaf(res1),
          Leaf(res2)
        )
      )
    )
  }

  /**
   * A natural extension of Generic's mapping of the content of data types onto a sum of products representation
   * is to a mapping of the data type including its constructor and field names onto a labelled sum of products representation,
   * ie. a representation in terms of the discriminated unions and records that we saw above.
   * This is provided by LabelledGeneric. Currently it provides the underpinnings for the use of shapeless lenses with
   * symbolic path selectors (see next section) and it is expected that it will support many scenarios which would otherwise
   * require the support of hard to maintain special case macros.
   * {{{
   * case class Book(author: String, title: String, id: Int, price: Double)
   * }}}
   */
  def labelled(res0: Double, res1: Double, res2: Boolean) = {
    import record._

    val bookGen = LabelledGeneric[Book]
    val tapl    = Book("Benjamin Pierce", "Types and Programming Languages", 262162091, 44.11)
    val rec     = bookGen.to(tapl)

    rec(Symbol("price")) should be(res0)

    val updatedBook = bookGen.from(rec.updateWith(Symbol("price"))(_ + 2.0))

    updatedBook.price should be(res1)

    // case class ExtendedBook(author: String, title: String, id: Int, price: Double, inPrint: Boolean)

    import syntax.singleton._

    val bookExtGen = LabelledGeneric[ExtendedBook]

    val extendedBook = bookExtGen.from(rec + (Symbol("inPrint") ->> true))

    extendedBook.inPrint should be(res2)
  }

}
