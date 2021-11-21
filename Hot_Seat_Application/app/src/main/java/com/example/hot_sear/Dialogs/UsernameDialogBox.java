package com.example.hot_sear.Dialogs;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
//import android.support.v4.app.AppCompatDialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;


import com.example.hot_sear.R;
import com.example.hot_sear.Utility.GlobalInfo;


public class UsernameDialogBox extends DialogFragment {
    private EditText editTextUsername;
    private String username;
    private View view;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        view = inflater.inflate(R.layout.dialogbox_username, null);
        editTextUsername = view.findViewById(R.id.username);
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        username = editTextUsername.getText().toString().trim();

                        GlobalInfo.User_Username = username;

                    // sign in the user ...
                    }
                });
        return builder.create();
    }
}