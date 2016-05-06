package de.simtext.tokenization

trait TokenizationBase {
  def tokenize(origin :String) : List[String]
  def tokenize(origin :List[String]) : List[String]
}
