package com.android.roselloquilt;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mStudentsAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            List<String> studentsTemporalList = new ArrayList<String>();
            studentsTemporalList.add("Ana");
            studentsTemporalList.add("Ana 1");
            studentsTemporalList.add("Ana 2");
            studentsTemporalList.add("Ana 3");
            studentsTemporalList.add("Ana 4");
            studentsTemporalList.add("Ana 5");
            studentsTemporalList.add("Ana 6");
            studentsTemporalList.add("Ana 7");
            studentsTemporalList.add("Ana 8");
            studentsTemporalList.add("Ana 9");
            studentsTemporalList.add("Ana 10");
            studentsTemporalList.add("Ana 11");
            mStudentsAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_students, R.id.list_item_students_textview, studentsTemporalList);
            ListView listView = (ListView) rootView.findViewById(R.id.listview_students);
            listView.setAdapter(mStudentsAdapter);
            return rootView;
        }
    }
}
