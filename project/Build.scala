import android.Keys._
import sbt.Keys._
import sbt._

object Build extends android.AutoBuild {

  lazy val mySettings = super.settings ++ android.Plugin.androidBuild ++ Seq(
    scalaVersion := "2.11.6",
    scalacOptions in Compile ++= Seq(
      "-feature"
    ),
    sourceGenerators in Compile := Seq((sourceGenerators in Compile).value.last),
    platformTarget in Android := "android-22",
    proguardCache in Android ++= Seq(
      ProguardCache("org.scaloid") % "org.scaloid"
    ),
    proguardOptions in Android ++= Seq(
      "-dontobfuscate",
      "-dontoptimize"
    ),
    shellPrompt := { s =>
      (scala.Console.CYAN + "%s > " + scala.Console.RESET) format {
        Project.extract(s).currentProject.id
      }
    },
    run <<= run in Android,
    install <<= install in Android
  )

  import Dependencies._

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
