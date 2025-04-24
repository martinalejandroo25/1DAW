package weather;

public class WeatherService {
    public static void update(String city) throws Exception {
        OpenMeteoClient.updateCurrentWeather(city);
        OpenMeteoClient.updateForecast(city);
    }

    public static String getCurrentPrecipitation() { return OpenMeteoClient.getCurrentPrecipitation(); }
    public static String getCurrentTemperature()  { return OpenMeteoClient.getCurrentTemperature(); }
    public static String getCurrentWind()         { return OpenMeteoClient.getCurrentWind(); }
    public static String getCurrentHumidity()     { return OpenMeteoClient.getCurrentHumidity(); }

    public static String[] getForecastTime()         { return OpenMeteoClient.getForecastTime(); }
    public static String[] getForecastPrecipitation() { return OpenMeteoClient.getForecastPrecipitation(); }
    public static String[] getForecastTemperature()   { return OpenMeteoClient.getForecastTemperature(); }
    public static String[] getForecastWind()          { return OpenMeteoClient.getForecastWind(); }
    public static String[] getForecastHumidity()      { return OpenMeteoClient.getForecastHumidity(); }
}