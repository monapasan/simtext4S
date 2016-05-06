package de.simtext.similarityCheck

import scala.collection.SortedMap

trait SimilarityCheckBase {
  def compare(queryA: List[String], queryB: List[String]): Float
  def compareAndSaveIndex(queryA: List[String], queryB: List[String]): (SortedMap[Int,Int],Float)
}