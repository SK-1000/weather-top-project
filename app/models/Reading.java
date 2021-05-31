package models;

import javax.persistence.Entity;
import play.db.jpa.Model;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Reading class outlines the parameters relating to the Weather
 *
 * @author Sheila Kirwan
 */



@Entity
public class Reading extends Model {


  public int code;
  public double temp;
  public double windSpeed;
  public int pressure;
  public double windDirection;
  public String timestamp;


  public Reading(int code, double temp, double windSpeed, int pressure, double windDirection, String timestamp) {
    this.code = code;
    this.temp = temp;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
    Date now = new Date();
    this.timestamp = now.toString();
  }

 /* public String getTimestamp() {
    return timestamp;
  }


  public String setTimestamp(String timestamp) {
    this.timestamp = timestamp;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    System.out.println("THE CURRENT TIMESTAMP IS " + (formatter.format(date)));
    timestamp = formatter.format(date);
    return timestamp;
  }
*/
}