# [Giter8](https://www.foundweekends.org/giter8/) template for [scala-cli](https://scala-cli.virtuslab.org/)

This project provides a g8 template for GitHub hosted scala-cli projects.

```shell
scala-cli run https://raw.githubusercontent.com/vic/scala-cli-g8/main/setup.scala
```

## Features

- Automatically setups GitHub actions workflow.
- If your project is a library, its maven artifacts are automatically published at [JitPack](https://jitpack.io).
- If your project is a binary, new tags are automatically packaged and published on GitHub releases.

## giter8 launcher

Using this launcher you can generate any giter8 template.

```shell
scala-cli run https://raw.githubusercontent.com/vic/scala-cli-g8/main/g8.scala -- --help
```

## coursier launcher

Using this launcher runs [coursier](https://get-coursier.io/) allowing you to use all of its
features like [running jar published apps](https://github.com/coursier/apps).

```shell
scala-cli run https://raw.githubusercontent.com/vic/scala-cli-g8/main/cs.scala -- --help
```

For example, to launch 

## Motivation

Currently the only launchers for giter8 were `sbt new` and `g8` itself, both of which
have to be already available on the user's system.

However, as `scala-cli` becomes more popular, it's much more probable that people will
have `scala-cli` available before they even get to use `sbt` on their projects.

This repo provides a one-liner launcher that can be run using `scala-cli` and let people
benefit from templates.

