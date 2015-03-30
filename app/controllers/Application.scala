package controllers

import play.api.mvc._
import it.alese.emailchecker._
import play.api.libs.json._

object Application extends Controller {

  def check(email: String) = Action {
    val check: ServiceResponse = EmailChecker.check(email)

    check match {
      case RecipientOK => Ok(Json.obj("status" -> "success", "message" -> "Recipient exists"))
      case DoesNotExist => Ok(Json.obj("status" -> "failure", "message" -> "Recipient does not exist"))
      case ServerUnreachable => Ok(Json.obj("status" -> "failure", "message" -> "Unable to connect to mail server"))
      case IPBlacklisted => Ok(Json.obj("status" -> "failure", "message" -> "Unable to connect to mail server"))
      case Denied | BadSyntax => Ok(Json.obj("status" -> "failure", "message" -> "Server does not allow RCPT inspection"))
    }

  }

  def home() = Action {
    Ok(views.html.main.render())
  }
}

