package data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by alberto on 10/18/14.
 */
public class WeatherContract {
    public static final String CONTENT_AUTHORITY = "com.example.android.sunshine.app";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_WEATHER = "weather";
    public static final String PATH_LOCATION = "location";

    public static class LocationEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_LOCATION).build();

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;

        public static final String TABLE_NAME = "location";

        public static final String LOCATION_ID = "id";
        //location query send to openweathermap
        public static final String COLUMN_LOCATION_SETTINGS = "location_settings";

        public static final String COLUMN_CITY_NAME = "city_name";
        //This will be store as a float
        public static final String COLUMN_LATITUDE = "latitude";
        //This will be store as a float
        public static final String COLUMN_LONGITUDE = "longitude";

        public static Uri buildLocationUri(long _id) {
            return ContentUris.withAppendedId(CONTENT_URI, _id);
        }
    }

    public static class WeatherEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_WEATHER).build();
        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_AUTHORITY;

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

        public static Uri buildWeatherUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildWeatherLocation(String locationSettings) {
            return CONTENT_URI.buildUpon().appendPath(locationSettings).build();
        }

        public static Uri buildWeatherLocationWithStartDate(String locationSettings, String startDate) {
            return CONTENT_URI.buildUpon()
                    .appendPath(locationSettings)
                    .appendQueryParameter(COLUMN_DATETEXT, startDate).build();
        }

        public static Uri buildWeatherLocationWithDate(String locationSettings, String date) {
            return CONTENT_URI.buildUpon()
                    .appendPath(locationSettings)
                    .appendPath(date).build();
        }

        public static String getDateFromUri(Uri uri) {
            return uri.getPathSegments().get(2);
        }

        public static String getLocationSettingsFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static String getStartDateFromUri(Uri uri) {
            return uri.getQueryParameter(COLUMN_DATETEXT);
        }

    }
}
