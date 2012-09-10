package sorm

import core._
import jdbc._
import persisted.Persisted
import reflection.Reflection
import samples._
import sext.Sext._

object Sandbox extends App {

  import reflect.runtime.universe._
  import sorm.reflection.ScalaApi._

  object ResponseType extends Enumeration {
    val Listing, Album = Value
  }

  Reflection[ResponseType.Value].<:<(Reflection[Enumeration#Value])
    .treeString.trace()
}
