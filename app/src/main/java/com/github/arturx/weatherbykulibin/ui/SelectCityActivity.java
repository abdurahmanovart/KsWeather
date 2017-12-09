package com.github.arturx.weatherbykulibin.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.arturx.weatherbykulibin.R;

public class SelectCityActivity extends AppCompatActivity {

    private static final String EXTRA_CITY_NAME = "city_name";
    private TextInputEditText mEditText;
    private Button mOkButton;

    public static Intent createExplicitIntent(Context context) {
        return new Intent(context, SelectCityActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        initUI();
    }

    private void initUI() {
        mEditText = findViewById(R.id.input_city_edit_text);
        mOkButton = findViewById(R.id.ok_button);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = mEditText.getText().toString();
                if (cityName.length() < 3) {
                    showSnackBar(v);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_CITY_NAME,cityName);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private void showSnackBar(View view) {
        Snackbar.make(view, R.string.error_city_input,Snackbar.LENGTH_LONG).show();
    }


}
