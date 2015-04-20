package coursera.vortex.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class VisitMomaDialogFragment extends DialogFragment {
	static private final String URL = "http://www.moma.org/";

	
	public static VisitMomaDialogFragment newInstance() {
		return new VisitMomaDialogFragment();
	}

	// Build AlertDialog using AlertDialog.Builder
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity())
				.setMessage("Click below to learn more about modern art.")
				
				// Set up Yes Button
				.setPositiveButton("Visit MOMA",
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog, int id) {
								visitMoma(true);
							}
						})
				
				// Set up No Button
				.setNegativeButton("Not Now",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								visitMoma(false);
							}
						}).create();
						

	}
	
	// Abort or complete ShutDown based on value of shouldContinue
	private void visitMoma(boolean shouldVisit) {
		if (shouldVisit) {
			// Open a browser to visit the MOMA website
			Intent showSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
			startActivity(showSiteIntent);
		
		} else {
			// Dismiss dialog
			this.dismiss();
		}
	}
}
