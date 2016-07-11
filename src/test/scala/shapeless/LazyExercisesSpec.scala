package shapeless

import org.scalacheck.Shapeless._
import org.scalaexercises.Test
import org.scalatest.Spec
import org.scalatest.prop.Checkers
import shapelessex._

class LazyExercisesSpec extends Spec with Checkers {

  def `lazy helps avoiding divergence` = {
    check(
      Test.testSuccess(
        LazyExercises.lazyExercise _,
        "Cons(1, Cons(2, Cons(3, Nil)))" :: HNil
      )
    )
  }

}
