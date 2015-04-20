package coursera.vortex.modernartui;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ColorFragment extends Fragment {
	
	private static final String TAG = "ColorFragment";
	
	private ImageView rect;
	
//	public static ColorFragment newInstance(int color) {
//        ColorFragment frag = new ColorFragment();
//        
//        Bundle args = new Bundle();
//        args.putInt("color", color);
//        frag.setArguments(args);
//        
//        return frag;
//    }
	
	public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Entered onCreate()");
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public void onActivityCreated(Bundle savedState) {
		Log.i(TAG, "Entered onActivityCreated()");
		super.onActivityCreated(savedState);
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i(TAG, "Entered onCreateView()");

		View view = inflater.inflate(R.layout.color_rect, container, false);

		rect = (ImageView) view.findViewById(R.id.colorImage);
		
        return view;
    }
	
	public ImageView getRect() {
		return rect;
	}
}
