package com.example.baitaptuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.Annotation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class homemusic extends AppCompatActivity {
    TextView txtstat, txttimeend, txttitle;
    SeekBar sksong;
    ImageButton btnPrev, btnplay, btnstop, btnNext, btnprevlistmusic, btnhome;
    ArrayList<listmusic> arrayListmusicplay;
    String tennhac, vitri;
    MediaPlayer mediaPlayer;
    int i;
    Animation annotation;
    ImageView imgrotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemusic);
        anhxa();
        Intent intent = getIntent();
        i = intent.getIntExtra("vitri",0);
        addsong();
        playmusic();
        annotation = AnimationUtils.loadAnimation(this,R.anim.animation_rotate);
        imgrotate.startAnimation(annotation);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                     mediaPlayer.pause();
                     btnplay.setImageResource(R.drawable.playmusic);
                }else {
                    mediaPlayer.start();
                    btnplay.setImageResource(R.drawable.pausemusic);
                }
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
//                mediaPlayer.release();
                btnplay.setImageResource(R.drawable.playmusic);
                playmusic();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if (i > arrayListmusicplay.size()-1){
                    i=0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                playmusic();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if (i < 0){
                    i = arrayListmusicplay.size()-1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                playmusic();
            }
        });
        sksong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(sksong.getProgress());
            }
        });
        btnprevlistmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homemusic.this, listViewMusic.class);
                startActivity(intent);
            }
        });
        updatetime();
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),homemusic.class);
                startActivity(intent);
                //vo lại
                Intent start = new Intent(Intent.ACTION_MAIN);
                start.addCategory(Intent.CATEGORY_HOME);
                startActivity(start);
                finish();
            }
        });
    }

    private void anhxa(){
        txttitle = (TextView) findViewById(R.id.titleten);
        txtstat = (TextView) findViewById(R.id.timestart);
        txttimeend = (TextView) findViewById(R.id.timeend);
        sksong = (SeekBar) findViewById(R.id.sbtime);
        btnNext = (ImageButton) findViewById(R.id.btnnext);
        btnPrev = (ImageButton) findViewById(R.id.btnprev);
        btnplay = (ImageButton) findViewById(R.id.btnplay);
        btnstop = (ImageButton) findViewById(R.id.btnstop);
        btnprevlistmusic = (ImageButton) findViewById(R.id.prevlistmusic);
        btnhome = (ImageButton) findViewById(R.id.outhomemuisic);
        imgrotate = (ImageView) findViewById(R.id.imageViewroteta);
    }

    private  void addsong(){
        arrayListmusicplay = new ArrayList<>();
        arrayListmusicplay.add(new listmusic("Hoa Hai Duong",R.raw.hoa_hai_duong));
        arrayListmusicplay.add(new listmusic("La 1 Thang Con Trai",R.raw.la_mot_thang_con_trai));
        arrayListmusicplay.add(new listmusic("Em Gi Oi",R.raw.em_gi_oi));
        arrayListmusicplay.add(new listmusic("Bac Phan",R.raw.bac_phan));
        arrayListmusicplay.add(new listmusic("Duong Quyen Tinh Yeu",R.raw.duong_quyen_tinh_yeu));
    }
    private void playmusic(){
        mediaPlayer = MediaPlayer.create(homemusic.this, arrayListmusicplay.get(i).getFile());
        txttitle.setText(arrayListmusicplay.get(i).getTen());
        mediaPlayer.start();
        timemusic();
    }
    private void timemusic(){
        SimpleDateFormat time = new SimpleDateFormat("mm:ss");
        txttimeend.setText(time.format(mediaPlayer.getDuration()));
        sksong.setMax(mediaPlayer.getDuration());
    }
    private void updatetime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat formattime = new SimpleDateFormat("mm:ss");
                txtstat.setText(formattime.format(mediaPlayer.getCurrentPosition()));
                handler.postDelayed(this,400);
                //update seekpart
                sksong.setProgress(mediaPlayer.getCurrentPosition());
                //tiep bai
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer media) {
                        i++;
                        if (i > arrayListmusicplay.size()-1){
                            i=0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        playmusic();
                    }
                });
            }
        },100);
    }
}