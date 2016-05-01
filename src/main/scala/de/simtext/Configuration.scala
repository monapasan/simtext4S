package de.simtext

import com.typesafe.config.ConfigFactory

object Configuration {
  private val path = "application.conf"
  private val config = ConfigFactory.load(path)

  def similarityChecker: Map[String, String] = {
    val cfg = config.getConfig("similaritytest")
    Map(
      "method" -> cfg.getString("method")
    )
  }

  def tokenization: Map[String, String] = {
    val cfg = config.getConfig("tokenization")
    Map(
      "ignorenumbers" -> cfg.getString("ignore.numbers"),
      "removeStopWords" -> cfg.getString("removestopwords"),
      "ignorelettercase" -> cfg.getString("ignore.lettercase"),
      "ignorepunctuation" -> cfg.getString("ignore.punctuation"),
      "ignoreumlauts" -> cfg.getString("ignore.umlauts")
    )
  }

  def queryComposition: Map[String,String] = {
    val cfg = config.getConfig("querycomposition")

    Map(
      "method" -> cfg.getString("method")
    )
  }

  def punctuationsMark: List[String] = "!" :: "." :: "?" :: Nil
}
