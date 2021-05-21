package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;
import java.util.List;

/**
 * The Dashboard class renders a table which has a list of weather related readings for each weather station
 * It also contains methods to add a new Station object for a member and also to delete a Station object for a member
 * Finally, it includes a failed attempt at alphabetizing the stations.
 * @author Sheila Kirwan
 *
 */

public class Dashboard extends Controller {

  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();// This is getting the logged in member
    List<Station> stations = member.stations;// This is getting the stations associated with that member
    for (Station station : stations) {
      StationAnalytics.updateReadings(station);
    }
    render("dashboard.html", stations);
  }

  public static void addStation(String name, String latitude, String longitude) {
    Logger.info("Adding a new station called " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Logger.info("Deleting a Playlist");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }

/* Attempted to Alphabetize the stations on the dashboard
  public static String sortStation(List<Station> stations) {
    stations.sort(Comparator.comparing(Station::getName));
    return
  }
*/


}