package com.eh.paraparbd.utils;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CustomSpinnerArrayAdapter implements AdapterView.OnItemSelectedListener{

	public static ArrayAdapter<CharSequence> getAdapter (Context context, int array){

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		return adapter;
	}

	public static void setSpinner(AdapterView.OnItemSelectedListener onItemSelectedListener, Spinner spinner, ArrayAdapter<CharSequence> adapter) {
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(onItemSelectedListener);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
