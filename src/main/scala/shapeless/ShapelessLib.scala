/*
 *  scala-exercises - exercises-shapeless
 *  Copyright (C) 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
 *
 */

package shapelessex

/** Shapeless is a type class and dependent type based generic programming library for Scala.
 *
 * @param name shapeless
 */
object ShapelessLib extends org.scalaexercises.definitions.Library {
  override def owner      = "scala-exercises"
  override def repository = "exercises-shapeless"

  override def color = Some("#F83A4D")

  override def sections = List(
    PolyExercises,
    HListExercises,
    TuplesHListExercises,
    ArityExercises,
    HMapExercises,
    SingletonExercises,
//  ExtensibleRecordsExercises,
    CoproductExercises,
    GenericExercises,
    LensesExercises,
    AutoTypeClassExercises,
    LazyExercises,
//  SizedExercises,
    TypeSafeCastExercises,
    TypeCheckingExercises
  )

  override def logoPath = "shapeless"
}
