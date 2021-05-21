package controllers;

import play.*;
import play.mvc.*;


/**
 * The about Java class renders a view page with outlines options to edit customer details
 *
 * @author Sheila Kirwan
 *
 */

public class PersonalDetails extends Controller {
  public static void index() {
    Logger.info("Rendering Edit Personal Details"); //Includes logging message in the console
    render("personaldetails.html"); // displays the personal details view
  }
}
