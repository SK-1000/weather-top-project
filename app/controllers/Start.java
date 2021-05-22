package controllers;

import play.Logger;
import play.mvc.Controller;

/**
 * The start class renders a start page which has some pictures and a welcome to the App.
 *
 * @author Sheila Kirwan
 *
 */


public class Start extends Controller {
  public static void index() {
    Logger.info("Rendering Start");
    render("start.html");
  }
}
