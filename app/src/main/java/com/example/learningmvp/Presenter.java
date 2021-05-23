package com.example.learningmvp;

public class Presenter implements Contract.Presenter{
    Contract.Model model;

    Contract.View view;

    public Presenter(Contract.Model model, Contract.View view){
        this.model = model;
        this.view = view;
    };

    @Override
    public void forecast(long celsius, long humidity) {
        String weatherName = model.forecastWeather(celsius, humidity);
        view.updateWeatherBG(weatherName);
        weatherName = Utils.convertString(weatherName);
        view.updateWeatherName(weatherName);
    }
}
