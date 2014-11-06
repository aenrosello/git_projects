package data;

import android.provider.BaseColumns;

/**
 * Created by alberto on 10/18/14.
 */
public class WeatherContract {
    public static class WeatherEntry implements BaseColumns {
        public static final String TABLE_NAME = "weather";
        //foreign key to location table
        public static final String COLUMN_LOCATION_KEY = "location_id";
        //This is a {@link Date}
        public static final String COLUMN_DATETEXT = "date";
        // Weather id as returned by API, to identify the icon to be used
        public static final String COLUMN_WEATHER_ID = "weather_id";
        //Store as String
        public static final String COLUMN_SHORT_DESCRIPTION = "short_description";
        //Store as float
        public static final String COLUMN_MIN_TEMP = "min_temp";
        //Store as float
        public static final String COLUMN_MAX_TEMP = "max_temp";
        //Store as float
        public static final String COLUMN_HUMIDITY = "humidity";
        //Store as float
        public static final String COLUMN_PRESSURE = "pressure";
        //Store as float
        public static final String COLUMN_WIND_SPEED = "wind_speed";
        //Store as float
        public static final String COLUMN_DEGRESS = "degress";

    }
}
