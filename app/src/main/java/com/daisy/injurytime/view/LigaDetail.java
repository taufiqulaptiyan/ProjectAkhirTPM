package com.daisy.injurytime.view;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.daisy.injurytime.R;

import androidx.appcompat.app.AppCompatActivity;

public class LigaDetail extends AppCompatActivity {
    TextView tv_namaliga,tv_deskripsiliga;
    ImageView ifoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_liga);

        tv_namaliga = findViewById(R.id.tv_namaliga);
        tv_deskripsiliga = findViewById(R.id.tv_deskripsiliga);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String detail = bundle.getString("detail");

        tv_namaliga.setText(nama);
        tv_deskripsiliga.setText(detail);
        tv_deskripsiliga.setMovementMethod(new ScrollingMovementMethod());
    }
}
