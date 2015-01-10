package io.delr3ves.sunshine.app.model;

import lombok.Data;

import java.util.List;

/**
 * @author Sergio Arroyo - @delr3ves
 */
@Data
public class DailyWeatherInfo {

    private Long dt;
    private TemperatureSummary temp;
    private List<WeatherCondition> weather;

    public WeatherCondition getFirstWeatherCondition() {
        if (weather == null || weather.isEmpty()) {
            return new WeatherCondition();
        }
        return weather.get(0);
    }
}
