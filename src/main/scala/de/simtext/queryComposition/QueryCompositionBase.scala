package de.simtext.queryComposition


trait QueryCompositionBase {
  protected val typeComposition = "origin"
  def composeBase(query:Vector[List[String]]): Vector[(List[String], String)] = query.map((_, typeComposition))
  def composeQuery(query:Vector[(List[String], String)]): Vector[(List[String], String)]
}
