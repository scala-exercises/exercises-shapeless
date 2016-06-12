package test.scala.exercises.shapeless

import exercises.Test
import shapelessex.TypeCheckingExercises

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
