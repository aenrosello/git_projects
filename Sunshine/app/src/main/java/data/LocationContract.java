package data;

import android.provider.BaseColumns;

/**
 * Created by alberto on 10/18/14.
 */
public class LocationContract {
    public static class LocationEntry implements BaseColumns {
        public static final String TABLE_NAME = "location";

        public static final String LOCATION_ID = "id";
        //location query send to openweathermap
        public static final String COLUMN_LOCATION_SETTINGS = "location_settings";

        public static final String COLUMN_CITY_NAME = "city_name";
        //This will be store as a float
        public static final String COLUMN_LATITUDE = "latitude";
        //This will be store as a float
        public static final String COLUMN_LONGITUDE = "longitude";
    }
}
