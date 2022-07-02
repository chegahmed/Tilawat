package com.example.tilawat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.tilawat.Data.DatabaseHandler;
import com.example.tilawat.Model.QuranSurah;
import com.example.tilawat.Util.Constants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{


    MediaPlayer mediaPlayer;
    ImageView artistImage;
    TextView leftTime,rightTime,arabic,latin,location,ayah;
    SeekBar seekBar;
    Button prevButton,nextButton,playButton;
    Thread thread;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        db = new DatabaseHandler(this);

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
     //   mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);

        artistImage = (ImageView) findViewById(R.id.ImageId);
        leftTime = (TextView) findViewById(R.id.leftTime);
        rightTime = (TextView) findViewById(R.id.rightTime);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        prevButton =(Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        playButton = (Button) findViewById(R.id.playButton);
        arabic  = (TextView) findViewById(R.id.sourhArId);
        latin  = (TextView) findViewById(R.id.sourhEnId);
        location  = (TextView) findViewById(R.id.locationId);
        ayah  = (TextView) findViewById(R.id.ayahId);

        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if ( bundle != null ) {

            int id =  bundle.getInt("id");
            // Get items from database
            QuranSurah quranSurah = db.getQuranSurah(id);

            arabic.setText(bundle.getString("arabic"));
            latin.setText(bundle.getString("latin"));
            location.setText(quranSurah.getLocaltion());
            if(quranSurah.getLocaltion() == "1"){
                location.setText(Constants.MAKIYA);
            }else{
                location.setText(Constants.MADANYA);
            }
            ayah.setText(Constants.NOMBRE_AYAH +quranSurah.getAyah());
            String nameFile = quranSurah.getNameFile();


            try {
                AssetFileDescriptor afd = getAssets().openFd("ghamdi/"+nameFile);
                mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                mediaPlayer.prepare();
             // afd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }




        }




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