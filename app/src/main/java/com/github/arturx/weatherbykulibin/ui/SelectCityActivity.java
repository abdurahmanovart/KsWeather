package com.github.arturx.weatherbykulibin.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.arturx.weatherbykulibin.MapFragment;
import com.github.arturx.weatherbykulibin.R;

public class SelectCityActivity extends AppCompatActivity {

    private static final String EXTRA_CITY_NAME = "city_name";
    private TextInputEditText mEditText;
    private Button mOkButton;
    private Button mShowMapButton;
    private TextInputLayout mTextInputLayout;
    private LinearLayout mPlaceForMapLayout;

    public static Intent createExplicitIntent(Context context) {
        return new Intent(context, SelectCityActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        initUI();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.exit_app_question)
                .setTitle(R.string.exit)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    private void initUI() {
        initTextFields();
        initButtons();
        initPlaceForMapLayout();
    }

    private void initPlaceForMapLayout() {
        mPlaceForMapLayout = findViewById(R.id.place_for_map_layout);
    }

    private void initTextFields() {
        mEditText = findViewById(R.id.input_city_edit_text);
        mTextInputLayout = findViewById(R.id.text_input_layout);
    }

    private void initButtons() {
        mOkButton = findViewById(R.id.ok_button);
        mShowMapButton = findViewById(R.id.show_map_button);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = mEditText.getText().toString();
                if (cityName.length() < 3) {
                    showAlertDialog();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_CITY_NAME, cityName);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        mShowMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlaceForMapLayout.setVisibility(View.INVISIBLE);
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.map_container, MapFragment.newInstance())
                        .commit();
            }
        });
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.enter_city)
                .setMessage(R.string.enter_correct_city_name)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
