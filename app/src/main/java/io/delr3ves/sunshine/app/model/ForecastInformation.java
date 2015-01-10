package io.delr3ves.sunshine.app.model;

import lombok.Data;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sergio Arroyo - @delr3ves
 */
@Data
public class ForecastInformation {

    private List<DailyWeatherInfo> list;

    public List<String> asList() {
        List<String> result = new ArrayList<String>();
        for (DailyWeatherInfo dailyInfo : list) {
            result.add(MessageFormat.format("{0} - {1} - {2}",
                    getReadableDateString(dailyInfo.getDt()), dailyInfo.getFirstWeatherCondition().getMain(),
                    formatHighLows(dailyInfo.getTemp().getMax(), dailyInfo.getTemp().getMin())));
        }
        return result;
    }

    /* The date/time conversion code is going to be moved outside the asynctask later,
 * so for convenience we're breaking it out into its own method now.
 */
    private String getReadableDateString(long time) {
        // Because the API returns a unix timestamp (measured in seconds),
        // it must be converted to milliseconds in order to be converted to valid date.
        Date date = new Date(time * 1000);
        SimpleDateFormat format = new SimpleDateFormat("E, MMM d");
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
