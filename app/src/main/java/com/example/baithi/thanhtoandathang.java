package com.example.baithi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class thanhtoandathang extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanhtoandatahang);
        Intent intent = getIntent();
        final String gc = intent.getStringExtra("gia");

        ImageView close_thanhtoan = (ImageView)findViewById(R.id.close_thanhtoan);

        //Back chitietsanpham
        close_thanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thanhtoandathang.this, chitietsanpham.class);
                 startActivity(intent);
            }
        });


    }


}

