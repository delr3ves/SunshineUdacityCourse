package io.delr3ves.sunshine.app.model;

import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Sergio Arroyo - @delr3ves
 */
@Data
public class DailyWeatherInfo implements Serializable {

    private Long dt;
    private TemperatureSummary temp;
    private List<WeatherCondition> weather;

    public WeatherCondition getFirstWeatherCondition() {
        if (weather == null || weather.isEmpty()) {
            return new WeatherCondition();
        }
        return weather.get(0);
    }

    public String getDay() {
        return getReadableDateString(dt, "E");
    }
    public String getDate() {
        return getReadableDateString(dt, "MMM d");
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} - {1} - {2}",
                getReadableDateString(getDt(), "E, MMM d"), getFirstWeatherCondition().getMain(),
                formatHighLows(getTemp().getMax(), getTemp().getMin()));
    }

    /* The date/time conversion code is going to be moved outside the asynctask later,
        * so for convenience we're breaking it out into its own method now.
        */
    private String getReadableDateString(long time, String mask) {
        Date date = new Date(time * 1000);
        SimpleDateFormat format = new SimpleDateFormat(mask);
        return format.format(date).toString();
    }

    /**
     * Prepare the weather high/lows for presentation.
     */
    private String formatHighLows(double high, double low) {
        // For presentation, assume the user doesn't care about tenths of a degree.
        long roundedHigh = Math.round(high);
        long roundedLow = Math.round(low);

        String highLowStr = roundedHigh + "/" + roundedLow;
        return highLowStr;
    }
}
