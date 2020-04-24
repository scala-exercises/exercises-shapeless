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

package shapelessex

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import shapeless._

object SizedHelper {
  def row(cols: Seq[String]) =
    cols.mkString("\"", "\", \"", "\"")

  def csv[N <: Nat](hdrs: Sized[Seq[String], N], rows: List[Sized[Seq[String], N]]) =
    row(hdrs) :: rows.map(row(_))

  val hdrs = Sized("Title", "Author")

  val rows = List(
    Sized("Types and Programming Languages", "Benjamin Pierce"),
    Sized("The Implementation of Functional Programming Languages", "Simon Peyton-Jones")
  )
}

/** == Collections with statically known sizes ==
 *
 * shapeless provides collection types with statically known sizes. These can prevent runtime errors such as those that
 * would result from attempting to take the head of an empty list, and can also verify more complex relationships.
 *
 * {{{
 * def row(cols : Seq[String]) =
 * cols.mkString("\\"", "\\", \\"", "\\"")
 *
 * def csv[N <: Nat]
 * (hdrs : Sized[Seq[String], N],
 * rows : List[Sized[Seq[String], N]]) = row(hdrs) :: rows.map(row(_))
 *
 * val hdrs = Sized("Title", "Author")
 *
 * val rows = List(
 * Sized("Types and Programming Languages", "Benjamin Pierce"),
 * Sized("The Implementation of Functional Programming Languages", "Simon Peyton-Jones")
 * )
 * }}}
 *
 * @param name sized
 */
object SizedExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {
  import SizedHelper._

  /** In the example below we define a method `csv` whose signature guarantees at compile time that there are exactly as many
   * column headers provided as colums
   * TODO : what would be a good exercise for stuff that can only be proven at compile time???
   */
  def sizedEx(res0: Int) = {

    // hdrs and rows statically known to have the same number of columns
    val formatted = csv(hdrs, rows) // Compiles

    // extendedHdrs has the wrong number of columns for rows
    val extendedHdrs = Sized("Title", "Author", "ISBN")
    //val badFormatted = csv(extendedHdrs, rows)             // Does not compile
    res0 should be(1)
  }

}
