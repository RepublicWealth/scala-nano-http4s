package au.com.republicwealth.spike.http4s

import org.http4s.util.UrlCodingUtils.urlDecode

import scalaz.concurrent.Task
import scalaz.stream.Process


class RhoRoutes extends RhoService with SwaggerSupport {
  // This is needed for the routes that return json4s `JValues`

  "Just a friendly hello route" **
    GET / "hello" |>> { () => Ok("Hello world!") }

  "An XHR example that just echos a result" **
    GET / "things" / *  |>> { (rest: Seq[String]) =>
      Ok(s"Calculating the rest: ${rest.map(urlDecode(_)).mkString("/")}")
    }

  "Data fetching route for models of android phones" **
    GET / "data" / 'id |>> { (id: String) =>
      val data = if (id == "all") Data.getPhones()
                 else Data.getPhonesMatching(id)
      Ok(data)
    }

  // Twirl routes require the twirl sbt plugin and import of the correct typeclass instances
  "Twirl routes are valid responses" **
    GET / "twirl-home" |>> Ok(html.home("http4s"))

  "Scalaz-stream makes it simple to compose routes, and cleanup resources" **
    GET / "cleanup" |>> {
      val stream = Process.constant("foo ")
        .take(40)
        .onComplete(Process.eval_(Task{logger.info("Finished!")}))

      Ok(stream)
    }
}
