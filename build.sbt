ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "com.pepegar"

name := "tagless-final"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "3.1.1"
)
