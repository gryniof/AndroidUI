package coursera.vortex.modernartui;

import android.support.v7.app.ActionBarActivity;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends ActionBarActivity {

	private DialogFragment mDialog;
	private SeekBar colorControl;
	
	private static final String TAG = "MainActivity";
	private int maxSliderVal;
	
	private ColorFragment orangeFragment;
	private ColorFragment baigeFragment;
	private ColorFragment yellowFragment;
	private ColorFragment whiteFragment;
	private ColorFragment redFragment;
	
	//orangeFrag
	private int sOrangeR = 255;
	private int sOrangeG = 204;
	private int sOrangeB = 153;
	
	private int eOrangeR = 102;
	private int eOrangeG = 0;
	private int eOrangeB = 204;
		
	//baigeFrag
	private int sBaigeR = 255;
	private int sBaigeG = 255;
	private int sBaigeB = 204;
	
	private int eBaigeR = 255;
	private int eBaigeG = 0;
	private int eBaigeB = 255;
	
	//yellowFrag
	private int sYellowR = 255;
	private int sYellowG = 255;
	private int sYellowB = 102;
	
	private int eYellowR = 153;
	private int eYellowG = 0;
	private int eYellowB = 153;
	
	//redFrag
	private int sRedR = 255;
	private int sRedG = 102;
	private int sRedB = 102;
	
	private int eRedR = 0;
	private int eRedG = 0;
	private int eRedB = 153;
	
	//whiteFrag
	private int maxColorVal = 255;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.i(TAG, "Entered onCreate().");
		
		setupFragments();
		
		//set up the seek bar which changes the colors
		maxSliderVal = ((SeekBar) findViewById(R.id.changeColorSeekBar)).getMax();
		colorControl = (SeekBar) findViewById(R.id.changeColorSeekBar);

		colorControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

				orangeFragment.getRect().setBackgroundColor(setColor(sOrangeR, eOrangeR, sOrangeG, eOrangeG, sOrangeB, eOrangeB, progress));
				baigeFragment.getRect().setBackgroundColor(setColor(sBaigeR, eBaigeR, sBaigeG, eBaigeG, sBaigeB, eBaigeB, progress));
				yellowFragment.getRect().setBackgroundColor(setColor(sYellowR, eYellowR, sYellowG, eYellowG, sYellowB, eYellowB, progress));
				redFragment.getRect().setBackgroundColor(setColor(sRedR, eRedR, sRedG, eRedG, sRedB, eRedB, progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) { }

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) { }
		});
	}
	
	private void setupFragments() {
		orangeFragment = (ColorFragment) getFragmentManager().findFragmentById(R.id.orangeFrag);
		baigeFragment = (ColorFragment) getFragmentManager().findFragmentById(R.id.baigeFrag);
		yellowFragment = (ColorFragment) getFragmentManager().findFragmentById(R.id.yellowFrag);
		whiteFragment = (ColorFragment) getFragmentManager().findFragmentById(R.id.whiteFrag);
		redFragment = (ColorFragment) getFragmentManager().findFragmentById(R.id.redFrag);
		
		orangeFragment.getRect().setBackgroundColor(Color.rgb(sOrangeR, sOrangeG, sOrangeB));
		baigeFragment.getRect().setBackgroundColor(Color.rgb(sBaigeR, sBaigeG, sBaigeB));
		yellowFragment.getRect().setBackgroundColor(Color.rgb(sYellowR, sYellowG, sYellowB));
		whiteFragment.getRect().setBackgroundColor(Color.rgb(maxColorVal, maxColorVal, maxColorVal));
		redFragment.getRect().setBackgroundColor(Color.rgb(sRedR, sRedG, sRedB));
	}
	
	private int setColor(int startRed, int endRed,
						 int startGreen, int endGreen,
						 int startBlue, int endBlue,
						 int currProgress) {
		
		int currRed = startRed + ((endRed-startRed)/maxSliderVal * currProgress); 
		int currGreen = startGreen + ((endGreen-startGreen)/maxSliderVal * currProgress);
		int currBlue = startBlue + ((endBlue-startBlue)/maxSliderVal * currProgress);
		
		return Color.rgb(currRed, currGreen, currBlue);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here.
		int id = item.getItemId();
		
		if (id == R.id.museum_info) {
			mDialog = VisitMomaDialogFragment.newInstance();
			mDialog.show(getFragmentManager(), "Moma");
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
