import sbt._

object Dependencies {

  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  val proguard         ="net.sf.proguard"     %  "proguard-base"             % "5.0"
  val scalazCore       = "org.scalaz"         %% "scalaz-core"               % "7.1.0"
  val scaloid          = "org.scaloid"        %% "scaloid"                   % "3.6.1-10"

}