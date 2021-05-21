package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

/**
 * The Station class creates a list of weather variables within each weather station.
 *
 * @author Sheila Kirwan
 *
 */



@Entity
public class Station extends Model {
  public String name;
  public String latitude;
  public String longitude;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public double latestTemperature;
  public double latesttemperaturefahrenheit;
  public double latestPressure;
  public String latestWeatherCodeStr;
  public String beaufort;
  public String convertToTextDir;
  public double latestWindChill;
  public double minTempReading;
  public double maxTempReading;
  public double minWindReading;
  public double maxWindReading;
  public double minPressureReading;
  public double maxPressureReading;
  public String tempTrend;
  public String windTrend;
  public String pressureTrend;


  public Station(String name, String latitude, String longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getName() {
    return this.name;
  }

}