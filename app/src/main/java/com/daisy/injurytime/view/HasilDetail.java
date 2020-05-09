package com.daisy.injurytime.view;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.daisy.injurytime.R;

import androidx.appcompat.app.AppCompatActivity;

public class HasilDetail extends AppCompatActivity {
    TextView tv_tanggal_detail,tv_jam_detail,tv_home_detail,tv_home_skor_detail,tv_away_detail,tv_away_skor_detail,
    tv_home_goal,tv_away_goal,tv_home_shots,tv_away_shots,tv_home_for,tv_away_for,tv_home_mid,tv_away_mid,
    tv_home_def,tv_away_def,tv_home_gk,tv_away_gk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_hasil);

        tv_tanggal_detail = findViewById(R.id.tv_tanggal_detail);
        tv_jam_detail = findViewById(R.id.tv_jam_detail);
        tv_home_detail = findViewById(R.id.tv_home_detail);
        tv_home_skor_detail = findViewById(R.id.tv_home_skor_detail);
        tv_away_detail = findViewById(R.id.tv_away_detail);
        tv_away_skor_detail = findViewById(R.id.tv_away_skor_detail);
        tv_home_goal = findViewById(R.id.tv_home_goal);
        tv_away_goal = findViewById(R.id.tv_away_goal);
        tv_home_shots = findViewById(R.id.tv_home_shots);
        tv_away_shots = findViewById(R.id.tv_away_shots);
        tv_home_for = findViewById(R.id.tv_home_for);
        tv_away_for = findViewById(R.id.tv_away_for);
        tv_home_mid = findViewById(R.id.tv_home_mid);
        tv_away_mid = findViewById(R.id.tv_away_mid);
        tv_home_def = findViewById(R.id.tv_home_def);
        tv_away_def = findViewById(R.id.tv_away_def);
        tv_home_gk = findViewById(R.id.tv_home_gk);
        tv_away_gk = findViewById(R.id.tv_away_gk);

        Bundle bundle = getIntent().getExtras();

        String tanggal = bundle.getString("tanggal");
        String jam = bundle.getString("jam");
        String  home= bundle.getString("home");
        String  home_skor= bundle.getString("home_skor");
        String  away= bundle.getString("away");
        String  away_skor= bundle.getString("away_skor");
        String  home_goal= bundle.getString("home_goal");
        String  away_goal= bundle.getString("away_goal");
        String  home_shots= bundle.getString("home_shots");
        String  away_shots= bundle.getString("away_shots");
        String  home_for= bundle.getString("home_for");
        String  away_for= bundle.getString("away_for");
        String  home_mid= bundle.getString("home_mid");
        String  away_mid= bundle.getString("away_mid");
        String  home_def= bundle.getString("home_def");
        String  away_def= bundle.getString("away_def");
        String  home_gk= bundle.getString("home_gk");
        String  away_gk= bundle.getString("away_gk");


        tv_tanggal_detail.setText(tanggal);
        tv_jam_detail.setText(jam);
        tv_home_detail.setText(home);
        tv_home_skor_detail.setText(home_skor);
        tv_away_detail.setText(away);
        tv_away_skor_detail.setText(away_skor);
        tv_home_goal.setText(home_goal);
        tv_away_goal.setText(away_goal);
        tv_home_shots.setText(home_shots);
        tv_away_shots.setText(away_shots);
        tv_home_for.setText(home_for);
        tv_away_for.setText(away_for);
        tv_home_mid.setText(home_mid);
        tv_away_mid.setText(away_mid);
        tv_home_def.setText(home_def);
        tv_away_def.setText(away_def);
        tv_home_gk.setText(home_gk);
        tv_away_gk.setText(away_gk);

//        tv_deskripsiliga.setMovementMethod(new ScrollingMovementMethod());
    }
}
