package com.wrapcontentdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sotsys016-2 on 5/12/16 in com.wrapcontentdemo.
 */

public class MainActivity extends AppCompatActivity{

    private Button buttonSample;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSample = (Button) findViewById(R.id.btnButtonSample);

        buttonSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateConfirmationDialog(buttonSample.getText().toString());
            }
        });
    }

    private void generateConfirmationDialog(String text) {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);

        // Setting the title and layout for the dialog
        dialog.setContentView(R.layout.dialog_confirmation);
        final TextView tvYes = (TextView) dialog.findViewById(R.id.tvYes);
        TextView tvNo = (TextView) dialog.findViewById(R.id.tvNo);
        final EditText edtText = (EditText) dialog.findViewById(R.id.edtText);
        edtText.setText(text);
        dialog.setCancelable(true);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();

        tvYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                buttonSample.setText(edtText.getText().toString());

            }
        });

        tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
