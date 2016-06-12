package exercises

import shapelessex._
import shapeless.HNil

import org.scalatest.Spec
import org.scalatest.prop.Checkers

import org.scalacheck.Shapeless._

class TypeCheckingExercisesSpec extends Spec with Checkers {
  def `testing for non-compilation` = {
    check(
      Test.testSuccess(
        TypeCheckingExercises.typeCheckingTest _,
        true :: false :: HNil
      )
    )
  }
}
