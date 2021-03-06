package de.simtext

import org.specs2.mutable.Specification

class TokenizerSpec extends Specification {
  "Tokenizer" should {

    "lower case text correctly" in {
      val tokenizer = new Tokenizer(
        ignoreLetterCase = true,
        ignoreNumbers = false,
        ignorePunctuation = false,
        ignoreUmlauts = false
      )

      tokenizer.stringCleanup("Test 123. Gross- und Kleinbuchstaben") mustEqual "test 123. gross- und kleinbuchstaben"
    }

    "remove punctuation completly" in {
      val tokenizer = new Tokenizer(
        ignoreLetterCase = false,
        ignoreNumbers = false,
        ignorePunctuation = true,
        ignoreUmlauts = false
      )

      tokenizer.stringCleanup("Bla'blubb, blub. Test 123. aber 12.02 und 123.04565!") mustEqual "Bla blubb  blub  Test 123  aber 12 02 und 123 04565 "
    }

    "remove numbers" in {
      val tokenizer = new Tokenizer(
        ignoreLetterCase = false,
        ignoreNumbers = true,
        ignorePunctuation = false,
        ignoreUmlauts = false
      )

      tokenizer.stringCleanup("Test 123. aber 12.02 und 123.04565!") mustEqual "Test . aber . und .!"
    }

    "replace umlauts" in {
      val tokenizer = new Tokenizer(
        ignoreLetterCase = false,
        ignoreNumbers = false,
        ignorePunctuation = false,
        ignoreUmlauts = true
      )

      tokenizer.stringCleanup("äöüßæœÄÖÜÆŒ") mustEqual "aeoeuessaeoeAEOEUEAEOE"
    }

    "return list of correct tokens" in {
      val text = "Es ist einfach, nicht genehmigte kabellose Hardware in ein Unternehmen \neinzuschmuggeln. Kabellose Zugriffspunkte sind\n ziemlich billig und einfach aufzustellen. \nBeispielsweise kann ein Beraterteam, das in\n einem Konferenzraum arbeitet, ohne jeden \nbösen Hintergedanken einen kabellosen \nZugriffspunkt installieren, damit alle \nTeammitglieder die einzige Netzwerkbuchse\n im Raum gemeinsam verwenden können. \nEin Hacker, der Böses im Schilde führt, kann\n sich mit seinem Laptop mit WLAN-Karte \nin eine Cafeteria setzen und nach unverschlüsseltem oder WEP\n-verschlüsseltem \nDatenverkehr suchen. In beiden Fällen entstehen\n untragbare Risiken\n. Unabhängig     davon, \nob eine böse Absicht vorliegt, kann das Einbringen\n nicht genehmigter Hardware den \nDatenschutz    und die Netzwerkintegrität zunichte\n machen. Möglichkeiten, um nicht \ngenehmigte kabellose Geräte zu erkennen\n, sind das physische Untersuchen der \nInstallationen (systematische\n Suche nach WLAN-Technik oder »War Driving«), die \nVerwendung von Funkfrequenz-Scangeräten \nzur Bestimmung der Standorte von \nkabellosen Geräten sowie die Verwendung von Systemen, die den    Netzwerkverkehr nach \nnicht autorisierten Geräten absuchen. "

      val tokenizer = new Tokenizer(
        ignoreLetterCase = true,
        ignoreNumbers = false,
        ignorePunctuation = true,
        ignoreUmlauts = true
      )

      tokenizer.tokenize(text) mustEqual List("es", "ist", "einfach", "nicht", "genehmigte", "kabellose", "hardware", "in", "ein", "unternehmen", "einzuschmuggeln", "kabellose", "zugriffspunkte", "sind", "ziemlich", "billig", "und", "einfach", "aufzustellen", "beispielsweise", "kann", "ein", "beraterteam", "das", "in", "einem", "konferenzraum", "arbeitet", "ohne", "jeden", "boesen", "hintergedanken", "einen", "kabellosen", "zugriffspunkt", "installieren", "damit", "alle", "teammitglieder", "die", "einzige", "netzwerkbuchse", "im", "raum", "gemeinsam", "verwenden", "koennen", "ein", "hacker", "der", "boeses", "im", "schilde", "fuehrt", "kann", "sich", "mit", "seinem", "laptop", "mit", "wlan", "karte", "in", "eine", "cafeteria", "setzen", "und", "nach", "unverschluesseltem", "oder", "wep", "verschluesseltem", "datenverkehr", "suchen", "in", "beiden", "faellen", "entstehen", "untragbare", "risiken", "unabhaengig", "davon", "ob", "eine", "boese", "absicht", "vorliegt", "kann", "das", "einbringen", "nicht", "genehmigter", "hardware", "den", "datenschutz", "und", "die", "netzwerkintegritaet", "zunichte", "machen", "moeglichkeiten", "um", "nicht", "genehmigte", "kabellose", "geraete", "zu", "erkennen", "sind", "das", "physische", "untersuchen", "der", "installationen", "systematische", "suche", "nach", "wlan", "technik", "oder", "war", "driving", "die", "verwendung", "von", "funkfrequenz", "scangeraeten", "zur", "bestimmung", "der", "standorte", "von", "kabellosen", "geraeten", "sowie", "die", "verwendung", "von", "systemen", "die", "den", "netzwerkverkehr", "nach", "nicht", "autorisierten", "geraeten", "absuchen")
    }
  }
}
