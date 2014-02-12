package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters
    private int mCreate;
    private int mResume;
    private int mRestart;
    private int mStart;

    //TextView variables for each counter displayed on the activity one.
    private TextView mTvCreate;
    private TextView mTvStart;
    private TextView mTvResume;
    private TextView mTvRestart;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// Assign the appropriate TextViews to the TextView variables
		mTvCreate = (TextView) findViewById(R.id.create);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvRestart = (TextView) findViewById(R.id.restart);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Create an intent stating which Activity you would like to start
                Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
				
				// Launch the Activity using the intent
                startActivity(intent);
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {
            // Restore value of counters from saved state
			this.setmCreate(savedInstanceState.getInt(CREATE_KEY, 0));
            this.setmStart(savedInstanceState.getInt(START_KEY, 0));
            this.setmResume(savedInstanceState.getInt(RESUME_KEY, 0));
            this.setmRestart(savedInstanceState.getInt(RESTART_KEY, 0));
		}

        Log.i(TAG,"Entered the onCreate() method.");

		// Update the appropriate count variable
        this.setmCreate(this.getmCreate() + 1);
        // Update the user interface via the displayCounts() method
        this.displayCounts();
	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();
        Log.i(TAG,"Entered the onStart() method.");
		// Update the appropriate count variable
        this.setmStart(this.getmStart() + 1);
		// Update the user interface
        this.displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();
        Log.i(TAG,"Entered the onResume() method.");
		// Update the appropriate count variable
        this.setmResume(this.getmResume() + 1);
		// Update the user interface
        this.displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();
        Log.i(TAG,"Entered the onPause() method.");
	}

	@Override
	public void onStop() {
		super.onStop();
        Log.i(TAG,"Entered the onStop() method.");
	}

	@Override
	public void onRestart() {
		super.onRestart();
        Log.i(TAG,"Entered the onRestart() method.");
		// Update the appropriate count variable
        this.setmRestart(this.getmRestart() + 1);
		// Update the user interface
        this.displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
        Log.i(TAG,"Entered the onDestroy() method.");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    // Save state information with a collection of key-value pairs
        savedInstanceState.putInt(CREATE_KEY, this.mCreate);
        savedInstanceState.putInt(RESTART_KEY, this.mRestart);
        savedInstanceState.putInt(RESUME_KEY, this.mResume);
        savedInstanceState.putInt(START_KEY, this.mStart);
	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + this.getmCreate());
		mTvStart.setText("onStart() calls: " + this.getmStart());
		mTvResume.setText("onResume() calls: " + this.getmResume());
		mTvRestart.setText("onRestart() calls: " + this.getmRestart());
	
	}

    public int getmCreate() {
        return mCreate;
    }

    public void setmCreate(int mCreate) {
        this.mCreate = mCreate;
    }

    public int getmResume() {
        return mResume;
    }

    public void setmResume(int mResume) {
        this.mResume = mResume;
    }

    public int getmRestart() {
        return mRestart;
    }

    public void setmRestart(int mRestart) {
        this.mRestart = mRestart;
    }

    public int getmStart() {
        return mStart;
    }

    public void setmStart(int mStart) {
        this.mStart = mStart;
    }
}
