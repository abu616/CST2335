package com.example.andrew.androidlabs;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherForecast extends Activity {

    protected static final String ACTIVITY_NAME = "WeatherForecast";

    class ForecastQuery extends AsyncTask<String, Integer, String> {

        String windSpeed;
        String minTemp;
        String maxTemp;
        String currentTemp;

        @Override
        protected String doInBackground(String... urls) {
            try{
                if (urls.length == 0) return "";
                InputStream connection = getConnection( urls[0]);
                publishProgress( 35);
                // do stuff
                //connection.
                publishProgress( 100);
                return "";
            } catch (IOException e){
                e.printStackTrace();
                return "";
            }
        }
    }
    private static InputStream getConnection(String url) throws IOException {
        URL address = new URL("http://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=d99666875e0e51521f0040a3d97d0f6a&mode=xml&units=metric");
        HttpURLConnection urlConnection = (HttpURLConnection) address.openConnection();
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoInput(true);
        urlConnection.connect();
        if (urlConnection.getResponseCode() != 200) return null;
        return urlConnection.getInputStream();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        Log.i(ACTIVITY_NAME, "In onCreate()");
    }
}