package com.lechucksoftware.proxy.proxysettings.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.lechucksoftware.proxy.proxysettings.R;
import com.lechucksoftware.proxy.proxysettings.activities.MainActivity;
import com.lechucksoftware.proxy.proxysettings.activities.ProxySettingsCallerActivity;
import com.lechucksoftware.proxy.proxysettings.utils.UIUtils;

public class BetaTestApplicationAlertDialog extends DialogFragment
{
	public static String TAG = "RateApplicationAlertDialog";

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getTheme());
		builder.setTitle(R.string.beta_testing);
		builder.setMessage(R.string.beta_testing_request);
		builder.setCancelable(false);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface paramDialogInterface, int paramInt)
			{
				((MainActivity) getActivity()).dontDisplayAgainBetaTest();
                UIUtils.openBetaTestProject(getActivity());
				getActivity().finish();
			}
		});

		builder.setNegativeButton(getResources().getText(R.string.app_rater_dialog_button_nothanks), new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface paramDialogInterface, int paramInt)
			{
				((MainActivity) getActivity()).dontDisplayAgainBetaTest();
			}
		});

		AlertDialog alert = builder.create();
		return alert;
	}

	public static BetaTestApplicationAlertDialog newInstance()
	{
		BetaTestApplicationAlertDialog frag = new BetaTestApplicationAlertDialog();
		return frag;
	}
}
