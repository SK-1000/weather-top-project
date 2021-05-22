package controllers;


import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;



/**
 * The StationCtrl class renders a stations.html page which contains a list of readings, station summary details.
 *  This class also includes add reading method and delete readings methods.
 * @author Sheila Kirwan
 */


public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    StationAnalytics.updateReadings(station);
    render("station.html", station);

  }


  /**
   * Method to allow the web application to remove a reading from a Station, when the remove reading is button is clicked on the
   * ListReadings View.This will remove the reading and delete it from the Station and the database.
   */

  public static void deletereading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing " + reading.code);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }


  /**
   * Method to allow the web application to add a reading from a Station, when the remove reading is button is clicked on the
   * ListReadings View.This will actually remove the reading and delete it from the Station and the database.
   */

  public static void addReading(Long id, int code, double temp, double windSpeed, int pressure, double windDirection, String timestamp) {
    Reading reading = new Reading(code, temp, windSpeed, pressure, windDirection, timestamp);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/station/" + id);
  }


}