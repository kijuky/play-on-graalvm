package controllers

import play.api.mvc.AbstractController
import play.api.mvc.Action
import play.api.mvc.AnyContent
import play.api.mvc.ControllerComponents

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
class HomeController (val cc: ControllerComponents)
    extends AbstractController(cc) {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be
    * called when the application receives a `GET` request with a path of `/`.
    */
  def index(): Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index())
  }
}
