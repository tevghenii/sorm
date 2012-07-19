package vorm.structure.mapping

import vorm._
import structure._
import reflection._

class TupleItem
  ( val settings : Map[Reflection, EntitySettings],
    val reflection : Reflection,
    val parent : Mapping )
  extends Mapping
  with HasParent
  with HasChildren
  with HasReflection
  {
    lazy val children
      = Mapping( settings, reflection, this ) ::
        Nil
  }
