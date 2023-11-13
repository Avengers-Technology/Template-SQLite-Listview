package com.mtg.speedtest.speedcheck.internet.hikermanager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditHikeAct extends AppCompatActivity {
    private CommonsModel commonsModel;
    private EditText edtNameHikeEdit, edtLocationEdit, edtDateHikeEdit, edtLengthHikeEdit, edtDifficultyLevelEdit, edtDescriptionEdit;
    private RadioButton radioYesEdit, radioNoEdit;
    private ImageView imvUpdate;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_hike_act);
        databaseHelper = new DatabaseHelper(this);
        initData();
        initViews();
        showViews();
        initEvents();
    }

    private void initEvents() {
        imvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editHike();
            }
        });
    }

    private void editHike() {
        String nameHike = edtNameHikeEdit.getText().toString().trim();
        String location = edtLocationEdit.getText().toString().trim();
        String dateHike = edtDateHikeEdit.getText().toString().trim();
        String lengthHike = edtLengthHikeEdit.getText().toString().trim();
        String difficultyLevel = edtDifficultyLevelEdit.getText().toString().trim();
        String description = edtDescriptionEdit.getText().toString().trim();
        String parkingAvailable = "Yes";

        if (radioYesEdit.isChecked()) {
            parkingAvailable = "Yes";
        } else {
            parkingAvailable = "No";
        }

        commonsModel.setName(nameHike);
        commonsModel.setLocation(location);
        commonsModel.setDate(dateHike);
        commonsModel.setLengthOfTheHike(lengthHike);
        commonsModel.setDifficultyLevel(difficultyLevel);
        commonsModel.setDescription(description);
        commonsModel.setParkingAvailable(parkingAvailable);
        databaseHelper.updateModel(commonsModel);
        finish();
    }

    private void showViews() {
        edtNameHikeEdit.setText(commonsModel.name);
        edtLocationEdit.setText(commonsModel.location);
        edtDateHikeEdit.setText(commonsModel.date);
        edtLengthHikeEdit.setText(commonsModel.lengthOfTheHike);
        edtDifficultyLevelEdit.setText(commonsModel.difficultyLevel);
        edtDescriptionEdit.setText(commonsModel.description);
        if (commonsModel.parkingAvailable.equals("Yes")) {
            radioYesEdit.setChecked(true);
        } else {
            radioNoEdit.setChecked(true);
        }
    }

    private void initViews() {
        edtNameHikeEdit = findViewById(R.id.edtNameHikeEdit);
        edtLocationEdit = findViewById(R.id.edtLocationEdit);
        edtDateHikeEdit = findViewById(R.id.edtDateHikeEdit);
        edtLengthHikeEdit = findViewById(R.id.edtLengthHikeEdit);
        edtDifficultyLevelEdit = findViewById(R.id.edtDifficultyLevelEdit);
        edtDescriptionEdit = findViewById(R.id.edtDescriptionEdit);
        radioYesEdit = findViewById(R.id.radioYesEdit);
        radioNoEdit = findViewById(R.id.radioNoEdit);
        imvUpdate = findViewById(R.id.imvUpdate);
    }

    private void initData() {
        commonsModel = (CommonsModel) getIntent().getExtras().getSerializable("data");
    }
}
