package io.delr3ves.sunshine.app.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sergio Arroyo - @delr3ves
 */
@Data
public class WeatherCondition implements Serializable {

    private String main;
    private String icon;
}
