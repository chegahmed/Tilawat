package com.example.tilawat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{


    MediaPlayer mediaPlayer;
    ImageView artistImage;
    TextView leftTime,rightTime;
    SeekBar seekBar;
    Button prevButton,nextButton,playButton;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setUpUI();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);
                }
                SimpleDateFormat dateFormat =new SimpleDateFormat("mm:ss");
                int currentPosition =mediaPlayer.getCurrentPosition();
                int duration =mediaPlayer.getDuration();
                leftTime.setText(String.valueOf(dateFormat.format(new Date(currentPosition))));
                rightTime.setText(String.valueOf(dateFormat.format(new Date(duration))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setMax(mediaPlayer.getDuration());
    }



    public  void setUpUI(){

        mediaPlayer =new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);

        artistImage = (ImageView) findViewById(R.id.ImageId);
        leftTime = (TextView) findViewById(R.id.leftTime);
        rightTime = (TextView) findViewById(R.id.rightTime);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        prevButton =(Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        playButton = (Button) findViewById(R.id.playButton);

        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.prevButton:
                backMusic();
                break;
            case R.id.playButton:
                if (mediaPlayer.isPlaying()){
                    pauseMusic();
                }else {
                    startMusic();
                }

                break;
            case R.id.nextButton:
                nextMusic();

                break;
        }

    }

    public void startMusic(){
        if (mediaPlayer!=null){
            mediaPlayer.start();
            updateThread();
            playButton.setBackgroundResource(R.drawable.ic_play_button);
        }
    }

    public void pauseMusic(){
        if(mediaPlayer!=null ){
            mediaPlayer.pause();
            playButton.setBackgroundResource(R.drawable.ic_pause_button);
        }
    }

    public void backMusic(){
        if(mediaPlayer.isPlaying() ){
            mediaPlayer.seekTo(0);
        }
    }
    public void nextMusic(){
        if(mediaPlayer.isPlaying() ){
            mediaPlayer.seekTo(mediaPlayer.getDuration()-1000);
        }
    }



    public void updateThread(){

        thread =new Thread(){
            @Override
            public void run() {

                try {
                    while (mediaPlayer!=null && mediaPlayer.isPlaying()){
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                SimpleDateFormat dateFormat =new SimpleDateFormat("mm:ss");
                                int currentPosition =mediaPlayer.getCurrentPosition();
                                int duration =mediaPlayer.getDuration();

                                //update The text
                                leftTime.setText(String.valueOf(dateFormat.format(new Date(currentPosition))));
                                rightTime.setText(String.valueOf(dateFormat.format(new Date(duration))));
                            }
                        });
                    }


                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                //   super.run();
            }
        };
        thread.start();
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        thread.interrupt();
        thread=null;

        super.onDestroy();
    }
}