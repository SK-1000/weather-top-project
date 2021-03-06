package controllers;

import models.Member;
import models.Reading;
import models.Station;
import play.*;
import play.mvc.*;


/**
 * The Personal Details Java class renders a view page which outlines options to edit customer details. Unfortunately I didn't manage to get this working.
 *
 * @author Sheila Kirwan
 *
 */

public class PersonalDetails extends Controller {
  public static void index() {
    Logger.info("Rendering Edit Personal Details"); //Includes logging message in the console
    render("personaldetails.html"); // displays the personal details view
  }


  //attempt at code to update email address of logged in member
  public static void updateDetails (String email, String password) {

    Member member = Accounts.getLoggedInMember();
    member.setEmail(email);
    member.setPassword(password);
    Logger.info("This members email and password have been updated");
    render ("login.html");
  }

}
