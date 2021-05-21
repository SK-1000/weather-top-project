package utils;

import models.Reading;
import models.Station;
import java.util.List;
import java.lang.Math;

/**
 * The StationAnalytics utils class contains the majority of the calculations for this application.
 *
 * @author Sheila Kirwan
 *
 */

public class StationAnalytics {


  public static double getLatestTemp(List<Reading> readings) {
    Reading latestReading = null;
    double latestTemp = 0.;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestTemp = latestReading.temp;
    }
    return latestTemp;
  }

  public static double getLatestTempFahrenheit(List<Reading> readings) {
    Reading latestReading = null;
    double latestTemp = 0.;
    double latestTempFahrenheit = 0.0;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestTemp = latestReading.temp;
      latestTempFahrenheit = (latestTemp*9/5+32);
    }
    return latestTempFahrenheit;
  }


  public static double getMinTemp(List<Reading> readings) {
    Reading minTempReading = null;
    if (readings.size() > 0) {
      minTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temp < minTempReading.temp) {
          minTempReading = reading;
          System.out.println("THe minimum temperature value for this station: " + minTempReading.temp);
        }

      }

    }
    return minTempReading.temp;

  }


  public static double getMaxTemp(List<Reading> readings) {
    Reading maxTempReading = null;
    if (readings.size() > 0) {
      maxTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temp > maxTempReading.temp) {
          maxTempReading = reading;
          System.out.println("The maximum Temperature for this station: " + maxTempReading.temp);
        }

      }

    }
    return maxTempReading.temp;

  }


  public static double getLatestPressure(List<Reading> readings) {
    Reading latestReading = null;
    double latestPressure = 0;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestPressure = latestReading.pressure;
    }
    return latestPressure;
  }

  public static double getMinPressure(List<Reading> readings) {
    Reading minPressureReading = null;
    if (readings.size() > 0) {
      minPressureReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure < minPressureReading.pressure) {
          minPressureReading = reading;
          System.out.println("The minimum pressure value for this station: " + minPressureReading.pressure);
        }

      }

    }
    return minPressureReading.pressure;

  }


  public static double getMaxPressure(List<Reading> readings) {
    Reading maxPressureReading = null;
    if (readings.size() > 0) {
      maxPressureReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure > maxPressureReading.pressure) {
          maxPressureReading = reading;
          System.out.println("The maximum Pressure for this station: " + maxPressureReading.pressure);
        }

      }

    }
    return maxPressureReading.pressure;

  }


  public static String getWeatherCode(List<Reading> readings) {
    Reading latestReading = null;
    String codeDefinition = "invalid code";
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      switch (latestReading.code) {
        case 100:
          codeDefinition = "clear";
          break;
        case 200:
          codeDefinition = "partial clouds";
          break;
        case 300:
          codeDefinition = "cloudy";
          break;
        case 400:
          codeDefinition = "light showers";
          break;
        case 500:
          codeDefinition = "heavy showers";
          break;
        case 600:
          codeDefinition = "rain";
          break;
        case 700:
          codeDefinition = "snow";
          break;
        case 800:
          codeDefinition = "thunder";
          break;
        default:
          codeDefinition = "invalid code";
      }
    }
    return codeDefinition;
  }

  public static String getLatestWind(List<Reading> readings) {

    Reading latestReading = null;
    String beaufort = "No Wind Info Available";
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);

      if (latestReading.windSpeed <= 1) {
        beaufort = "0 hpa";
      } else if (latestReading.windSpeed > 1 && latestReading.windSpeed <= 5) {
        beaufort = "1 hpa";
      } else if (latestReading.windSpeed >= 6 && latestReading.windSpeed <= 11) {
        beaufort = "2 hpa";
      } else if (latestReading.windSpeed > 12 && latestReading.windSpeed <= 19) {
        beaufort = "3 hpa";
      } else if (latestReading.windSpeed > 20 && latestReading.windSpeed <= 28) {
        beaufort = "4 hpa";
      } else if (latestReading.windSpeed > 29 && latestReading.windSpeed <= 38) {
        beaufort = "5 hpa";
      } else if (latestReading.windSpeed > 39 && latestReading.windSpeed <= 49) {
        beaufort = "6 hpa";
      } else if (latestReading.windSpeed > 50 && latestReading.windSpeed <= 61) {
        beaufort = "7 hpa";
      } else if (latestReading.windSpeed >= 62 && latestReading.windSpeed <= 74) {
        beaufort = "8 hpa";
      } else if (latestReading.windSpeed > 75 && latestReading.windSpeed <= 88) {
        beaufort = "9 hpa";
      } else if (latestReading.windSpeed > 89 && latestReading.windSpeed <= 102) {
        beaufort = "10 hpa";
      } else if (latestReading.windSpeed > 103 && latestReading.windSpeed <= 117) {
        beaufort = "11 hpa";
      }
    }
    return beaufort;
  }


  public static String getWindDirection(List<Reading> readings) {
    Reading latestReading = null;
    String convertToTextDir = "invalid Direction";
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      if ((latestReading.windDirection >= 348.75) && (latestReading.windDirection <= 360) || (latestReading.windDirection >= 0) &&
          (latestReading.windDirection <= 11.25)) {
        convertToTextDir = "North";
      } else if ((latestReading.windDirection >= 11.25) && (latestReading.windDirection <= 33.75)) {
        convertToTextDir = "North North East";
      } else if ((latestReading.windDirection >= 33.75) && (latestReading.windDirection <= 56.25)) {
        convertToTextDir = "North East";
      } else if ((latestReading.windDirection >= 56.25) && (latestReading.windDirection <= 78.75)) {
        convertToTextDir = "East North East";
      } else if ((latestReading.windDirection >= 78.25) && (latestReading.windDirection <= 101.25)) {
        convertToTextDir = "East";
      } else if ((latestReading.windDirection >= 101.25) && (latestReading.windDirection <= 123.75)) {
        convertToTextDir = "East South East";
      } else if ((latestReading.windDirection >= 123.75) && (latestReading.windDirection <= 146.25)) {
        convertToTextDir = "South East";
      } else if ((latestReading.windDirection >= 146.25) && (latestReading.windDirection <= 168.75)) {
        convertToTextDir = "South South East";
      } else if ((latestReading.windDirection >= 168.75) && (latestReading.windDirection <= 191.25)) {
        convertToTextDir = "South";
      } else if ((latestReading.windDirection >= 191.25) && (latestReading.windDirection <= 213.75)) {
        convertToTextDir = "South South West";
      } else if ((latestReading.windDirection >= 213.75) && (latestReading.windDirection <= 236.25)) {
        convertToTextDir = "South West";
      } else if ((latestReading.windDirection >= 236.25) && (latestReading.windDirection <= 258.75)) {
        convertToTextDir = "West South West";
      } else if ((latestReading.windDirection >= 258.75) && (latestReading.windDirection <= 281.25)) {
        convertToTextDir = "West";
      } else if ((latestReading.windDirection >= 281.25) && (latestReading.windDirection <= 303.75)) {
        convertToTextDir = "West North West";
      } else if ((latestReading.windDirection >= 303.75) && (latestReading.windDirection <= 326.25)) {
        convertToTextDir = "North West";
      } else if ((latestReading.windDirection >= 236.25) && (latestReading.windDirection <= 348.75)) {
        convertToTextDir = "North North West";
      }

    }
    return convertToTextDir;
  }


  // Wind Chill calculation


  public static double getWindChill(List<Reading> readings) {
    Reading latestReading = null;
    double latestWindChill = 0;
    if (readings.size() > 0) {
      latestReading = readings.get(readings.size() - 1);
      latestWindChill = Math.round(13.12 + 0.6215 * latestReading.temp - 11.37 * Math.pow(latestReading.windSpeed, 0.16) + 0.3965 * latestReading.temp * Math.pow(latestReading.windSpeed, 0.16));
      System.out.println("The wind chill index is " + latestWindChill);
    }
    return latestWindChill;
  }


  public static double getMinWind(List<Reading> readings) {
    Reading minWindReading = null;
    if (readings.size() > 0) {
      minWindReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed < minWindReading.windSpeed) {
          minWindReading = reading;
          System.out.println("The minimum wind speed for this station: " + minWindReading.windSpeed);
        }

      }

    }
    return minWindReading.windSpeed;

  }


  public static double getMaxWind(List<Reading> readings) {
    Reading maxWindReading = null;
    if (readings.size() > 0) {
      maxWindReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed > maxWindReading.windSpeed) {
          maxWindReading = reading;
          System.out.println("The maximum wind speed for this station: " + maxWindReading.windSpeed);
        }

      }

    }
    return maxWindReading.windSpeed;

  }


  public static void updateReadings(Station station) {

    try {
      station.latestPressure = StationAnalytics.getLatestPressure(station.readings);
    } catch (NullPointerException e) {
      station.latestPressure = 0.0;
    }

    station.latestWeatherCodeStr = StationAnalytics.getWeatherCode(station.readings);
    station.latestTemperature = StationAnalytics.getLatestTemp(station.readings);

    try {
      station.latestTemperatureFahrenheit = StationAnalytics.getLatestTempFahrenheit(station.readings);
    } catch (NullPointerException e) {
      station.latestTemperatureFahrenheit = 0.0;
    }

    station.beaufort = StationAnalytics.getLatestWind(station.readings);
    station.convertToTextDir = StationAnalytics.getWindDirection(station.readings);
    station.latestWindChill = StationAnalytics.getWindChill(station.readings);

    try {
      station.tempTrend = StationAnalytics.getThreeMostRecentReadingsTemp(station.readings);
    } catch (NullPointerException e) {
      station.tempTrend = "";
    }

    try {
      station.windTrend = StationAnalytics.getThreeMostRecentReadingsWind(station.readings);
    } catch (NullPointerException e) {
      station.windTrend = "";
    }

    try {
      station.pressureTrend = StationAnalytics.getThreeMostRecentReadingsPressure(station.readings);
    } catch (NullPointerException e) {
      station.windTrend = "";
    }
    try {
      station.minTempReading = StationAnalytics.getMinTemp(station.readings);
    } catch (NullPointerException e) {
      station.minTempReading = 0.0;
    }


    try {
      station.maxTempReading = StationAnalytics.getMaxTemp(station.readings);
    } catch (NullPointerException e) {
      station.maxTempReading = 0.0;
    }


    try {
      station.minWindReading = StationAnalytics.getMinWind(station.readings);
    } catch (NullPointerException e) {
      station.minWindReading = 0.0;
    }


    try {
      station.maxWindReading = StationAnalytics.getMaxWind(station.readings);
    } catch (NullPointerException e) {
      station.maxWindReading = 0.0;
    }

    try {
      station.minPressureReading = StationAnalytics.getMinPressure(station.readings);
    } catch (NullPointerException e) {
      station.minPressureReading = 0.0;
    }


    try {
      station.maxPressureReading = StationAnalytics.getMaxPressure(station.readings);
    } catch (NullPointerException e) {
      station.maxPressureReading = 0.0;
    }


  }

// Trends
// if the value for the most second most recent is greater than the third most recent and if the value of
//the first most recent is greater than the second most recent tbe the trend is increasing and a up arrow should be
//shown

// if the value of the second recent is less than the third recent and that value of the latest is less than the value
// of the second most recent then the trend is going down.


  public static String getThreeMostRecentReadingsTemp(List<Reading> readings) {
    Reading latestReading = null;
    Reading secondLatestReading = null;
    Reading thirdLatestReading = null;

    String status = "steady";
    if (readings.size() > 2) {
      latestReading = readings.get(readings.size() - 1);
      secondLatestReading = readings.get(readings.size() - 2);
      thirdLatestReading = readings.get(readings.size() - 3);

    }
    if ((secondLatestReading.temp >= thirdLatestReading.temp) && (latestReading.temp >= secondLatestReading.temp)) {
      status = "rising";
    }
    if ((secondLatestReading.temp <= thirdLatestReading.temp) && (latestReading.temp <= secondLatestReading.temp)) {
      status = "falling";
    }

    return status;
  }


  public static String getThreeMostRecentReadingsWind(List<Reading> readings) {
    Reading latestReading = null;
    Reading secondLatestReading = null;
    Reading thirdLatestReading = null;

    String status = "steady";
    if (readings.size() > 2) {
      latestReading = readings.get(readings.size() - 1);
      secondLatestReading = readings.get(readings.size() - 2);
      thirdLatestReading = readings.get(readings.size() - 3);

    }
    if ((secondLatestReading.windSpeed >= thirdLatestReading.windSpeed) && (latestReading.windSpeed >= secondLatestReading.windSpeed)) {
      status = "rising";
    }
    if ((secondLatestReading.windSpeed <= thirdLatestReading.windSpeed) && (latestReading.windSpeed <= secondLatestReading.windSpeed)) {
      status = "falling";
    }

    return status;
  }


  public static String getThreeMostRecentReadingsPressure(List<Reading> readings) {
    Reading latestReading = null;
    Reading secondLatestReading = null;
    Reading thirdLatestReading = null;

    String status = "steady";
    if (readings.size() > 2) {
      latestReading = readings.get(readings.size() - 1);
      secondLatestReading = readings.get(readings.size() - 2);
      thirdLatestReading = readings.get(readings.size() - 3);

    }
    if ((secondLatestReading.pressure >= thirdLatestReading.pressure) && (latestReading.pressure >= secondLatestReading.pressure)) {
      status = "rising";
    }
    if ((secondLatestReading.pressure <= thirdLatestReading.pressure) && (latestReading.pressure <= secondLatestReading.pressure)) {
      status = "falling";
    }

    return status;
  }


}
