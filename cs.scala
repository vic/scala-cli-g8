// -*- scala -*-
//> using scala 2.12
//> using dep io.get-coursier::coursier-cli:2.1.5

package scala_cli.runx

object cs {
  def main(args: Array[String]): Unit = coursier.cli.Coursier.main(args)
}
