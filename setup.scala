// -*- scala -*-
//> using scala 2.12
//> using dep io.get-coursier::coursier-cli:2.1.5

package scala_cli.runx

object setup {
  val preArgs: Array[String] = Array("launch", "giter8", "--", "https://github.com/vic/scala-cli-g8.git")
  def main(args: Array[String]): Unit = coursier.cli.Coursier.main(preArgs ++ args)
}
