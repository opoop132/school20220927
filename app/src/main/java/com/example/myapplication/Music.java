package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Music extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        setTitle("동요재생");

        Intent intent = getIntent();
        String tag = intent.getStringExtra("intent_tag");

        TextView title = findViewById(R.id.title);
        ImageView image = findViewById(R.id.image);
        TextView lyrics = findViewById(R.id.lyrics);

        Resources res= getResources();

        int tv_id = res.getIdentifier("title"+tag, "string", getPackageName());
        String tv_key = res.getString(tv_id);
        title.setText(tv_key);

        int iv_id = res.getIdentifier("image"+tag, "string", getPackageName());
        String iv_key = res.getString(iv_id);
        int id_img = res.getIdentifier(iv_key, "drawable", getPackageName());
        image.setImageResource(id_img);

        int tv_id2 = res.getIdentifier("lyrics"+tag, "string", getPackageName());
        String tv_key2 = res.getString(tv_id2);
        lyrics.setText(tv_key2);

        int audio_id = res.getIdentifier("audio"+tag, "string", getPackageName());
        String audio_key = res.getString(audio_id);
        int audio_id1 = res.getIdentifier(audio_key, "raw", getPackageName());
        mp= MediaPlayer.create(this,audio_id1);
        mp.setLooping(false);
        mp.start();
    }
    public void back(View v){
        if(mp.isPlaying()){
            mp.stop();
            mp.release();
        }
    }


}
