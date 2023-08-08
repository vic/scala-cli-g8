# [Giter8](https://www.foundweekends.org/giter8/) launcher for [scala-cli](https://scala-cli.virtuslab.org/)

```shell
scala-cli run https://raw.githubusercontent.com/vic/scala-cli-g8/main/g8.scala -- --help
```

## Motivation

Currently the only launchers for giter8 were `sbt new` and `g8` itself, both of which
have to be already available on the user's system.

However, as `scala-cli` becomes more popular, it's much more probable that people will
have `scala-cli` available before they even get to use `sbt` on their projects.

This repo provides a one-liner launcher that can be run using `scala-cli` and let people
benefit from templates.

