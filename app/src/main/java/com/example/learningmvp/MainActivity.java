package com.example.learningmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Contract.View {
    Contract.Presenter presenter;

    private ImageView iv_weather;
    private TextView tv_weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(new Model(), this);
        iv_weather = findViewById(R.id.iv_weather);
        tv_weather = findViewById(R.id.tv_weather_name);
        Button btn_forecast = findViewById(R.id.btn_forecast);
        EditText et_temperature = findViewById(R.id.et_temperature);
        EditText et_humidity = findViewById(R.id.et_humidity);

        btn_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = et_temperature.getText().toString();
                String humidityStr = et_humidity.getText().toString();
                if (celsiusStr.length() == 0){
                    et_temperature.setError("Please enter the Temperature!");
                }
                else if (humidityStr.length() == 0){
                    et_humidity.setError("Please enter the Humidity!");
                }
                else {
                    long celsius = (long) Integer.parseInt(celsiusStr);
                    long humidity = (long) Integer.parseInt(humidityStr);
                    presenter.forecast(celsius, humidity);
                }
            }
        });
    }

    @Override
    public void updateWeatherBG(String weatherName) {
        int drawId = getResources().getIdentifier(weatherName, "drawable", getPackageName());
        iv_weather.setBackgroundResource(drawId);
    }

    @Override
    public void updateWeatherName(String weatherName) {
        tv_weather.setText(weatherName);
    }
}