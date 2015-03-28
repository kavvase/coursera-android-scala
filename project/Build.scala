import android.Keys._
import sbt.Keys._
import sbt._

object Build extends android.AutoBuild {
  import Dependencies._

  lazy val mySettings = super.settings ++ android.Plugin.androidBuild ++ Seq(
    scalaVersion := "2.11.6",
    platformTarget in Android := "android-22",
    proguardCache in Android ++= Seq(
      ProguardCache("org.scaloid") % "org.scaloid"
    ),
    proguardOptions in Android ++= Seq(
      "-dontobfuscate",
      "-dontoptimize"
    ),
    scalacOptions in Compile ++= Seq(
      "-feature"
    ),
    sourceGenerators in Compile := Seq((sourceGenerators in Compile).value.last),
    shellPrompt := { s =>
      (scala.Console.CYAN + "%s > " + scala.Console.RESET) format {
        Project.extract(s).currentProject.id
      }
    },
    run <<= run in Android,
    install <<= install in Android
  )

  lazy val root = Project("coursera-android-scala", file("."))
    .aggregate(helloAndroid)

  lazy val helloAndroid = Project("hello-android", file("hello-android"))
    .settings(mySettings: _*)
    .settings(libraryDependencies ++= compile(proguard, scaloid))

  lazy val helloScaloid = Project("hello-scaloid", file("hello-scaloid"))
    .settings(mySettings: _*)
    .settings(libraryDependencies ++= compile(proguard, scaloid))

  lazy val theAnswer = Project("the-answer", file("the-answer"))
    .settings(mySettings: _*)
    .settings(libraryDependencies ++= compile(proguard, scaloid))

}
