import sbt._

object Dependencies {

  def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

  val proguard   = "net.sf.proguard" %  "proguard-base" % "5.0"
  val scaloid    = "org.scaloid"     %% "scaloid"       % "3.6.1-10"

}