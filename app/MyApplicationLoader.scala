import controllers.AssetsComponents
import controllers.HomeController
import play.api.Application
import play.api.ApplicationLoader
import play.api.ApplicationLoader.Context
import play.api.BuiltInComponentsFromContext
import play.filters.HttpFiltersComponents
import router.Routes

class MyApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = {
    new MyComponents(context).application
  }
}

class MyComponents(context: Context) extends BuiltInComponentsFromContext(context) with AssetsComponents with HttpFiltersComponents {
  lazy val homeController = new HomeController(controllerComponents)
  override lazy val router = new Routes(httpErrorHandler, homeController, assets)
}
