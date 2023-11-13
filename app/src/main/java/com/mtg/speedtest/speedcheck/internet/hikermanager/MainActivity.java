package com.mtg.speedtest.speedcheck.internet.hikermanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtNameHike, edtLocation, edtDateHike, edtLengthHike, edtDifficultyLevel, edtDescription;
    private RadioButton radioYes, radioNo;
    private ImageView imvAdd;
    private TextView tvHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();

    }

    private void initEvents() {
        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewHike();
            }
        });

        imvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewHike();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void addNewHike() {
        String nameHike = edtNameHike.getText().toString().trim();
        String location = edtLocation.getText().toString().trim();
        String dateHike = edtDateHike.getText().toString().trim();
        String lengthHike = edtLengthHike.getText().toString().trim();
        String difficultyLevel = edtDifficultyLevel.getText().toString().trim();
        String description = edtDescription.getText().toString().trim();
        String parkingAvailable = "";

        if (radioYes.isChecked()) {
            parkingAvailable = "Yes";
        } else {
            parkingAvailable = "No";
        }

        if (nameHike.equals("") || location.equals("") || dateHike.equals("") || lengthHike.equals("") || difficultyLevel.equals("")) {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.error);

            dialog.findViewById(R.id.tvError).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        } else {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.success);

            TextView tvNameConfirm = dialog.findViewById(R.id.tvNameConfirm);
            TextView tvLocationConfirm = dialog.findViewById(R.id.tvLocationConfirm);
            TextView tvDateConfirm = dialog.findViewById(R.id.tvDateConfirm);
            TextView tvParkingAvailable = dialog.findViewById(R.id.tvParkingAvailable);
            TextView tvLengthConfirm = dialog.findViewById(R.id.tvLengthConfirm);
            TextView tvDifficultyLevel = dialog.findViewById(R.id.tvDifficultyLevel);

            tvNameConfirm.setText("Name: " + nameHike);
            tvLocationConfirm.setText("Location: " + location);
            tvDateConfirm.setText("Date of the hike: " + dateHike);
            tvParkingAvailable.setText("Parking available: " + parkingAvailable);
            tvLengthConfirm.setText("Length of the hike: " + lengthHike);
            tvDifficultyLevel.setText("Difficulty level: " + difficultyLevel);


            dialog.findViewById(R.id.tvCancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.findViewById(R.id.tvYes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            dialog.show();
        }

    }

    private void initViews() {
        edtNameHike = findViewById(R.id.edtNameHike);
        edtLocation = findViewById(R.id.edtLocation);
        edtDateHike = findViewById(R.id.edtDateHike);
        edtLengthHike = findViewById(R.id.edtLengthHike);
        edtDifficultyLevel = findViewById(R.id.edtDifficultyLevel);
        edtDescription = findViewById(R.id.edtDescription);
        radioYes = findViewById(R.id.radioYes);
        radioNo = findViewById(R.id.radioNo);
        imvAdd = findViewById(R.id.imvAdd);
        tvHome = findViewById(R.id.tvHome);
    }
}