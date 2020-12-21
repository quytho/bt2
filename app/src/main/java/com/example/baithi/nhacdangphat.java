package com.example.baithi;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class nhacdangphat extends AppCompatActivity {
    ArrayList<Song> arraySong;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhacdangphat);
        final CircleImageView hinhnhac = (CircleImageView) findViewById(R.id.hinhnhac);
        final Animation animationRotate = AnimationUtils.loadAnimation(this, R.anim.anim_quay);

        ImageView close_nhac = (ImageView)findViewById(R.id.close_nhac);
        close_nhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nhacdangphat.this, myaccount.class);
                startActivity(intent);
            }
        });

        hinhnhac.startAnimation(animationRotate);
        addSong();
        MediaPlayer mediaPlayer = MediaPlayer.create(nhacdangphat.this, arraySong.get(position).getFile());
        mediaPlayer.start();
        
    }
    public void addSong(){
         arraySong = new ArrayList<>();
        arraySong.add(new Song("Dân Xóm Anh", R.raw.nahc1));
    }
}
