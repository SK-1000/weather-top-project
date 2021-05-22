package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;


/**
 * This class is returning the views sign up and log in and contains the code to:
 * Register a new user
 * Authenticate an existing user
 * logout
 * find which member is logged in
 *
 *@author Sheila Kirwan
 */

public class Accounts extends Controller {
  public static void signup() {
    render("signup.html");
  }

  public static void login() {
    render("login.html");
  }

  /**
   * When a user clicks submit on the register form in sign up view, they will be routed to this register method. This
   * method creates a new member and saves the new member. It also includes a redirect to the main page where they will have the
   * option to log in.
   */

  public static void register(String firstname, String lastname, String email, String password) {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password);
    member.save();
    redirect("/");
  }

  /**
   * When a user clicks login on the login form in log in view, they will be routed to this register method. They will
   * be routed to the Authenticate method. This finds the member in the database, if the member is found and passwords
   * match, this stores the session id in the members object and renders dashboard or else brings the user back to the login page
   * to retry
   */

  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else if ((member.checkPassword(password) == false)) {
      Logger.info("Authentication failed");
      //  JFrame frame = new JFrame("JOptionPane showMessageDialog example");
      //  JOptionPane.showMessageDialog(frame,"Either your username or Password is incorrect, Please resubmit the correct details", "Autentication Failed",
      //        JOptionPane.PLAIN_MESSAGE);
      redirect("/login");
    }
  }

  /**
   * The users wishes to logout and the session must be cleared. This removes the cookie from the browser
   */
  public static void logout() {
    session.clear();
    redirect("/");
  }


  /**
   * This is a utility method. It is not triggered by any route. It is a general purpose method we will call from our controller
   * whenever we want to know who is logged in. It checks if the session is created, recovers the session id, looks up the database
   * and returns the member object.If no member is found it switches to the log in screen
   */

  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }


}