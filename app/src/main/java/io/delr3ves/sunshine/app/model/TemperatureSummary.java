package io.delr3ves.sunshine.app.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sergio Arroyo - @delr3ves
 */
@Data
public class TemperatureSummary implements Serializable {

    private Float max;
    private Float min;
}
