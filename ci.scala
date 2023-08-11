//> using dep "com.lihaoyi::os-lib::0.9.1"
//> using dep "com.lihaoyi::utest:0.8.1"

object testing extends utest.TestSuite:
  import utest._

  trait Runner {
    def apply(sh: os.Shellable*): os.CommandResult
  }

  val NON_INTERACTIVE: Seq[os.Shellable] = Seq(
    "--isApp=true",
    "--isLibrary=true",
    "--targetJavaPlatform=true",
    "--targetJavaScriptPlatform=true",
    "--targetNativePlatform=true",
    "--githubActionsCheckFormat=true",
    "--githubActionsRunTests=true",
    "--githubActionsPublishJitPack=true"
  )

  def gen_project(): (os.Path, Runner) =
    val dir = os.temp.dir()
    println(s"Generated new project at ${dir}")
    os.proc(
      "scala-cli",
      "run",
      os.pwd / "g8.scala",
      "--",
      "-o",
      dir,
      "--force",
      NON_INTERACTIVE,
      s"file://${os.pwd}"
    ).call(mergeErrIntoOut = true, cwd = dir)

    def run_cli(cmd: os.Shellable*): os.CommandResult =
      os.proc("scala-cli", cmd).call(mergeErrIntoOut = true, cwd = dir)

    (dir, run_cli)

  val tests = Tests:
    test("generated project"):
      val (dir, run_cli) = gen_project()

      test("compiles"):
        run_cli("compile", dir)

      test("is formatted"):
        run_cli("fmt", "--check", dir)

      test("runs main"):
        val res = run_cli("run", dir)
        val out = res.out.trim()
        assert(out.contains("Hello World"))

      test("passes tests"):
        val res = run_cli("test", dir)
        val out = res.out.trim()
        assert(out.contains("math works"))

      test("package js"):
        run_cli(
          "--power",
          "package",
          "--js",
          dir,
          "-o",
          dir / "out.js",
          "--js-emit-source-maps",
          "--js-source-maps-path",
          dir / "out.js.map"
        )
