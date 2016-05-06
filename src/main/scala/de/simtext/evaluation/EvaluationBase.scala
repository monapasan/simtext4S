package de.simtext.evaluation

import org.apache.spark.rdd.RDD


// Purpose: in order to evaluate all of results that we have and
// filter all results that we don't need
trait EvaluationBase[T] {
  def filter(rdd: T): T
}
