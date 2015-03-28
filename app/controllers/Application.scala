package controllers

import play.api._
import play.api.mvc._
import it.alese.emailchecker.EmailChecker

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def check(email: String) = Action {
    val check = EmailChecker.check(email)
    Ok(check.toString)
  }
}
