import mill._
import $ivy.`com.lihaoyi::mill-contrib-playlib:`,  mill.playlib._

object playscalaseed extends PlayModule with SingleModule {

  def scalaVersion = "2.13.12"
  def playVersion = "2.9.0"
  def twirlVersion = "2.0.1"

  object test extends PlayTests
}
