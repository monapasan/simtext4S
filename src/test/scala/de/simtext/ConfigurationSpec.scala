package de.simtext

import org.specs2.mutable.Specification


class ConfigurationSpec extends Specification {
  "tokenization" should {
    val removeStopWords = Configuration.tokenization.get("removeStopWords")
    "have a somehting in options" in {
      removeStopWords.isEmpty must not equalTo true
    }
  }
  "similarityCheck" should {
    val method = Configuration.similarityChecker.get("method")
    "have a somehting in options" in {
      method.isEmpty must not equalTo true
    }
  }
  "queryComposition" should {
    val method = Configuration.queryComposition.get("method")
    "have a somehting in options" in {
      method.isEmpty must not equalTo true
    }
  }
}
