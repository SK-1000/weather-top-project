package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * The about Java class renders a view page which outlines the premise of the WeatherTop App
 *
 * @author Sheila Kirwan
 *
 */


public class About extends Controller {
  public static void index() {
    Logger.info("Rendering about"); //Includes logging message in the console
    render("about.html"); // displays the about view
  }
}
