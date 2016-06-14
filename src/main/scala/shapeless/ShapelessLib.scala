package shapelessex

/** Shapeless is a type class and dependent type based generic programming library for Scala.
  *
  * @param name shapeless
  */
object ShapelessLib extends exercise.Library {
  override def owner = "scala-exercises"
  override def repository = "exercises-shapeless"

  override def color = Some("#F83A4D")

  override def sections = List(
    PolyExercises,
    HListExercises,
    TuplesExercises,
    ArityExercises,
    HMapExercises,
    SingletonExercises,
    ExtensibleRecordsExercises,
    CoproductExercises,
    GenericExercises,
    LensesExercises,
    AutoTypeClassExercises,
    LazyExercises,
//  SizedExercises,
    TypeSafeCastExercises,
    TypeCheckingExercises
  )
}
