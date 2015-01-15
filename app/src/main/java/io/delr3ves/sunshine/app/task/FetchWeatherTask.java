package io.delr3ves.sunshine.app.task;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import io.delr3ves.sunshine.app.model.DailyWeatherInfo;
import io.delr3ves.sunshine.app.model.ForecastInformation;
import io.delr3ves.sunshine.app.service.WeatherRetrieverService;
import retrofit.RestAdapter;

/**
 * @author Sergio Arroyo - @delr3ves
 */
public class FetchWeatherTask extends AsyncTask<String, Void, ForecastInformation> {

    private WeatherRetrieverService weatherRetrieverService;
    private ArrayAdapter<DailyWeatherInfo> mAdapter;

    public FetchWeatherTask(ArrayAdapter<DailyWeatherInfo> adapter) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.openweathermap.org")
                .build();
        this.weatherRetrieverService = restAdapter.create(WeatherRetrieverService.class);
        this.mAdapter = adapter;
    }

    public FetchWeatherTask(WeatherRetrieverService weatherRetrieverService) {
        this.weatherRetrieverService = weatherRetrieverService;
    }

    @Override
    protected ForecastInformation doInBackground(String... params) {
        return weatherRetrieverService.retrieveWeather(params[0]);
    }

    @Override
    protected void onPostExecute(ForecastInformation forecastInformation) {
        super.onPostExecute(forecastInformation);
        mAdapter.clear();
        mAdapter.addAll(forecastInformation.getList());
    }
}
