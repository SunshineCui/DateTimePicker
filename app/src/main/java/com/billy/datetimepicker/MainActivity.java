package com.billy.datetimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.billy.datetimepicker.utils.DialogUtils;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DialogUtils.showDateTimePicker(getLayoutInflater(), new DialogUtils.DialogClick() {
            @Override
            public void update(String time) {
                Log.d(TAG,time);
            }
        });
    }


}
