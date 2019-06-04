## Scala Spark project template

This project is template for an application written in Scala with usage of [Spark](http://spark.apache.org/) framework.
You could use it as an example on generic SBT project organization or as a quick start for an Spark application.

### Dependencies

Project is configured to provide basic set of dependencies to run minimalistic Spark application (one is template
itself).

Frameworks and libraries that are defined in this templates:
* Spark 2.4.3, built with Scala 2.12
* Hadoop 2.8.5
* Kryo 4.0.4
* SLF4j 1.7.25

Also, base docker image contains Spark 2.4.3 built with Scala 2.12

### Packaging

Idea of this templated app is to have dockerized Spark application, ie application itself, its dependencies and relevant
Spark distributed packed as a Docker image.

Such approach allows to run Spark applications with external configurations and without its rebuild.

### How to setup

Pre-requisits:
* Docker (tested with engine version 18.09.2)
* SBT 1.x

Setup:
1. run `sbt new Sigma-Software/scala-spark.g8`
2. use default values for settings or enter your own
3. change directory to newly created project's one
4. run `sbt docker:publishLocal` to build docker image of an application and push it to local registry


### How to run

After setup you would get docker image of an application in your local docker registry.
Run `docker images` to see name and tag of an application image you have built.

You could run container based on this image with the command `docker run -e MASTER=<spark master setting> <app-name>:latest`.

With the default settings and with intention to run Spark with local context command would look like `docker run -e MASTER=local sparkpi:latest`
