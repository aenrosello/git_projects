package com.android.roselloquilt;

/**
 * Created by alberto on 9/25/14.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class StudentsFragment extends Fragment {

    private ArrayAdapter<String> mStudentsAdapter;

    public StudentsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.studentsfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            mStudentsAdapter.add("Hello" + new Date().getTime());
            return true;
        }
        return super.onOptionsItemSelected(item);
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