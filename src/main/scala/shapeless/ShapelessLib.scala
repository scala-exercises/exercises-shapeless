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

/**
 * Shapeless is a type class and dependent type based generic programming library for Scala.
 *
 * @param name
 *   shapeless
 */
object ShapelessLib extends org.scalaexercises.definitions.Library {
  override def owner      = "scala-exercises"
  override def repository = "exercises-shapeless"

  override def color = Some("#F83A4D")

  override def sections =
    List(
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
