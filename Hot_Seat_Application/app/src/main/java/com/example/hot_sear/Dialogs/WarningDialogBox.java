package com.example.hot_sear.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.hot_sear.Function.IUsername;
import com.example.hot_sear.Function.UsernameFunction;
import com.example.hot_sear.R;
import com.example.hot_sear.Utility.GlobalInfo;

public class WarningDialogBox extends DialogFragment {
    private TextView text_tv;
    private View view;
    private String taken_by;

    public WarningDialogBox(String taken_by) {
        this.taken_by = taken_by;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        view = inflater.inflate(R.layout.warning_dialogbox, null);
        text_tv = view.findViewById(R.id.warning);
        text_tv.setText(R.string.occupied_warning+taken_by);
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }
}
