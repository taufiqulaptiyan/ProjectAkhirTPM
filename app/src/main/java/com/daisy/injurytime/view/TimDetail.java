package com.daisy.injurytime.view;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.daisy.injurytime.R;

import androidx.appcompat.app.AppCompatActivity;

public class TimDetail extends AppCompatActivity {
    TextView tv_namatim,tv_deskripsitim,tv_timliga;
    ImageView ifoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tim);

        tv_namatim = findViewById(R.id.tv_namatim);
        tv_deskripsitim = findViewById(R.id.tv_deskripsitim);
        tv_timliga= findViewById(R.id.tv_timliga);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String timliga =bundle.getString("timliga");
        String detail = bundle.getString("detail");

        tv_namatim.setText(nama);
        tv_timliga.setText(timliga);
        tv_deskripsitim.setText(detail);
        tv_deskripsitim.setMovementMethod(new ScrollingMovementMethod());
    }
}