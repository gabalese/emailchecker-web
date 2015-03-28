package controllers

import play.api.mvc._
import it.alese.emailchecker.EmailChecker

object Application extends Controller {

  def check(email: String) = Action {
    val check = EmailChecker.check(email)
    Ok(check.toString)
  }

  def home() = Action {
    Ok("Hello")
  }
}
