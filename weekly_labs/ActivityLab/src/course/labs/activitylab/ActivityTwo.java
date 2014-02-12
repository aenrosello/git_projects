package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
    private int mCreate;
    private int mStart;
    private int mResume;
    private int mRestart;

    private TextView mTvCreate;
    private TextView mTvStart;
    private TextView mTvResume;
    private TextView mTvRestart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		this.mTvCreate = (TextView) findViewById(R.id.create);
        this.mTvStart = (TextView) findViewById(R.id.start);
        this.mTvResume = (TextView) findViewById(R.id.resume);
        this.mTvRestart = (TextView) findViewById(R.id.restart);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
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
        Log.i(TAG, "Entered the onCreate() method.");

		// Update the appropriate count variable
        this.setmCreate(this.getmCreate() +1);
		// Update the user interface via the displayCounts() method
        this.displayCounts();



	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();
        Log.i(TAG, "Entered the onStart() method.");
		// Update the appropriate count variable
        this.setmStart(this.getmStart() + 1);
		// Update the user interface
        this.displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();
        Log.i(TAG, "Entered the onResume() method.");
		// Update the appropriate count variable
        this.setmResume(this.getmResume() + 1);
		// Update the user interface
        this.displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();
        Log.i(TAG, "Entered the onPause() method.");
	}

	@Override
	public void onStop() {
		super.onStop();
        Log.i(TAG, "Entered the onStop() method.");
	}

	@Override
	public void onRestart() {
		super.onRestart();
        Log.i(TAG, "Entered the onRestart() method.");
		// Update the appropriate count variable
        this.setmRestart(this.getmRestart() + 1);
		// Update the user interface
        this.displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
        Log.i(TAG, "Entered the onDestroy() method.");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save counter state information with a collection of key-value pairs
        savedInstanceState.putInt(CREATE_KEY, this.getmCreate());
        savedInstanceState.putInt(START_KEY, this.getmStart());
        savedInstanceState.putInt(RESTART_KEY, this.getmRestart());
        savedInstanceState.putInt(RESUME_KEY, this.getmResume());
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + getmCreate());
		mTvStart.setText("onStart() calls: " + getmStart());
		mTvResume.setText("onResume() calls: " + getmResume());
		mTvRestart.setText("onRestart() calls: " + getmRestart());
	
	}

    public int getmCreate() {
        return mCreate;
    }

    public void setmCreate(int mCreate) {
        this.mCreate = mCreate;
    }

    public int getmStart() {
        return mStart;
    }

    public void setmStart(int mStart) {
        this.mStart = mStart;
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
}
