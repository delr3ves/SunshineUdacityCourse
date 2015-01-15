package io.delr3ves.sunshine.app.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sergio Arroyo - @delr3ves
 */
@Data
public class ForecastInformation implements Serializable {

    private List<DailyWeatherInfo> list;

}
