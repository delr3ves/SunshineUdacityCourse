package io.delr3ves.sunshine.app.service;

import io.delr3ves.sunshine.app.model.ForecastInformation;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Sergio Arroyo - @delr3ves
 */
public interface WeatherRetrieverService {

    @GET("/data/2.5/forecast/daily?mode=json&units=metric&cnt=7")
    ForecastInformation retrieveWeather(@Query("q") String zone);
}
