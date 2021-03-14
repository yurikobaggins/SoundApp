package com.yurikobaggins.soundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = ((Button)view).getText().toString();
                if(buttonText.equals(getString(R.string.stop))) {
                    // もし、ボタンの文字が停止！だったら、音楽を止める
                    mediaPlayer.stop();
                    playButton.setText(getString(R.string.play));
                } else if(buttonText.equals(getString(R.string.play))) {
                    // 音楽をスタートしつつ、ボタンの文字を停止！にする
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.haruurara);
                    mediaPlayer.start();
                    playButton.setText(getString(R.string.stop));
                }
            }
        });
    }
}