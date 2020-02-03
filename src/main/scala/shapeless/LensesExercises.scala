/*
 *  scala-exercises - exercises-shapeless
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package shapelessex

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import shapeless._

/** == Boilerplate-free lenses for arbitrary case classes ==
 *
 * A combination of `LabelledGeneric` and singleton-typed `Symbol` literals supports boilerplate-free lens creation for
 * arbitrary case classes
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
 * @param name lenses
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

  /** Read a field
   */
  def get(res0: Int) =
    ageLens.get(person) should be(res0)

  /** Update a field
   */
  def set(res0: Int) = {
    val updatedPerson = ageLens.set(person)(38)
    updatedPerson.age should be(res0)
  }

  /** Transform a field
   */
  def modify(res0: Int) = {
    val updatedPerson = ageLens.modify(person)(_ + 1)
    updatedPerson.age should be(res0)
  }

  /** Read a nested field
   */
  def readNested(res0: String) =
    streetLens.get(person) should be(res0)

  /** Update a nested field
   */
  def updateNested(res0: String) = {
    val updatedPerson = streetLens.set(person)("Montpelier Road")
    updatedPerson.address.street should be(res0)
  }

}
