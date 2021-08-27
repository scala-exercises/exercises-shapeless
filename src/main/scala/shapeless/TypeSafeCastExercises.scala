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
 * ==Type safe cast==
 *
 * shapeless provides a `Typeable` type class which provides a type safe cast operation. `cast`
 * returns an `Option` of the target type rather than throwing an exception if the value is of the
 * incorrect type, as can happen with separate `isInstanceOf` and `asInstanceOf` operations.
 * `Typeable` handles primitive values correctly and will recover erased types in many circumstances
 *
 * @param name
 *   type_safe_cast
 */
object TypeSafeCastExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  /**
   */
  def typesafeCast(
      res0: Option[List[Vector[String]]],
      res1: Option[List[Vector[Int]]],
      res2: Option[List[List[String]]]
  ) = {
    import syntax.typeable._

    val l: Any = List(Vector("foo", "bar", "baz"), Vector("wibble"))
    l.cast[List[Vector[String]]] should be(res0)
    l.cast[List[Vector[Int]]] should be(res1)
    l.cast[List[List[String]]] should be(res2)
  }

  /**
   * An extractor based on `Typeable` is also available, allowing more precision in pattern matches,
   */
  def extractor(res0: Int) = {

    val `List[String]` = TypeCase[List[String]]
    val `List[Int]`    = TypeCase[List[Int]]
    val l              = List(1, 2, 3)

    val result = (l: Any) match {
      case `List[String]`(List(s, _*)) => s.length
      case `List[Int]`(List(i, _*))    => i + 1
    }

    result should be(res0)

    /**
     * The equivalent pattern match without `Typeable`/`TypeCase` would result in a compile-time
     * warning about the erasure of the list's type parameter, then at runtime spuriously match the
     * `List[String]` case and fail with a `ClassCastException` while attempting to evaluate its
     * right hand side.
     *
     * Be aware that the increased precision and safety provided by `Typeable`/`TypeCase` don't
     * alter the fact that type caseing should be avoided in general other than at boundaries with
     * external components which are intrinsically untyped (eg. serialization points) or which
     * otherwise have poor type discipline.
     */
  }

}
