package com.kodilla.testing.weather.stub;

import java.lang.reflect.Array;
import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        return sum/temperatures.getTemperatures().size();
    }

    public double calculateMedianTemperature() {
        List<Double> values = new ArrayList<>();
        double median;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            values.add(temperature.getValue());
        }

        Collections.sort(values);

        if (values.size() % 2 == 0) {
            median = (values.get(values.size() / 2) + values.get(values.size() / 2 - 1)) / 2;
        } else {
            median = values.get(values.size() / 2);
        }
        return median;
    }
}
