package com.example.learningmvp;

public class Model implements Contract.Model{
    @Override
    public String forecastWeather(long celsius, long humidity) {
        if (celsius <= 27){
            if (humidity <= 45) return "clean";
            if (humidity <= 80) return "clouds";
            if (humidity > 80) return "overcast";
        }
        else if (celsius <= 32){
            if (humidity <= 45) return "sunny";
            if (humidity <= 80) return "partly_sunny";
            if (humidity > 80) return "light_rain";
        }
        else if (celsius > 32){
            if (humidity <= 45) return "hot";
            if (humidity <= 80) return "partly_sunny2";
            if (humidity > 80) return "heavy_rain";
        }
        return null;
    }
}
