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
 * ==Boilerplate-free lenses for arbitrary case classes==
 *
 * A combination of `LabelledGeneric` and singleton-typed `Symbol` literals supports
 * boilerplate-free lens creation for arbitrary case classes
 *
 * {{{
 * // A pair of ordinary case classes ...
 * case class Address(street : String, city : String, postcode : String)
 * case class Person(name : String, age : Int, address : Address)
 *
 * // Some lenses over Person/Address ...
 * val nameLens     = lens[Person] >> Symbol("name")
 * val ageLens      = lens[Person] >> Symbol("age")
 * val addressLens  = lens[Person] >> Symbol("address")
 * val streetLens   = lens[Person] >> Symbol("address") >> Symbol("street")
 * val cityLens     = lens[Person] >> Symbol("address") >> Symbol("city")
 * val postcodeLens = lens[Person] >> Symbol("address") >> Symbol("postcode")
 *
 * val person = Person("Joe Grey", 37, Address("Southover Street", "Brighton", "BN2 9UA"))
 * }}}
 *
 * @param name
 *   lenses
 */
object LensesExercises
    extends AnyFlatSpec
    with Matchers
    with org.scalaexercises.definitions.Section {

  object Helper {
    // A pair of ordinary case classes ...
    case class Address(street: String, city: String, postcode: String)
    case class Person(name: String, age: Int, address: Address)

    // Some lenses over Person/Address ...
    val nameLens     = lens[Person] >> Symbol("name")
    val ageLens      = lens[Person] >> Symbol("age")
    val addressLens  = lens[Person] >> Symbol("address")
    val streetLens   = lens[Person] >> Symbol("address") >> Symbol("street")
    val cityLens     = lens[Person] >> Symbol("address") >> Symbol("city")
    val postcodeLens = lens[Person] >> Symbol("address") >> Symbol("postcode")

    val person = Person("Joe Grey", 37, Address("Southover Street", "Brighton", "BN2 9UA"))
  }

  import Helper._

  /**
   * Read a field
   */
  def get(res0: Int) =
    ageLens.get(person) should be(res0)

  /**
   * Update a field
   */
  def set(res0: Int) = {
    val updatedPerson = ageLens.set(person)(38)
    updatedPerson.age should be(res0)
  }

  /**
   * Transform a field
   */
  def modify(res0: Int) = {
    val updatedPerson = ageLens.modify(person)(_ + 1)
    updatedPerson.age should be(res0)
  }

  /**
   * Read a nested field
   */
  def readNested(res0: String) =
    streetLens.get(person) should be(res0)

  /**
   * Update a nested field
   */
  def updateNested(res0: String) = {
    val updatedPerson = streetLens.set(person)("Montpelier Road")
    updatedPerson.address.street should be(res0)
  }

}
