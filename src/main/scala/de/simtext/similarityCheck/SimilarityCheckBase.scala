package de.simtext.similarityCheck

trait SimilarityCheckBase {
  def compare(queryA: List[String], queryB: List[String]): Float
}