package com.example.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.icu.text.UnicodeSetSpanner;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Player player;
    private Spinner sp_music;
    private ImageButton btn_play, btn_pause, btn_stop, btn_looping, btn_next, btn_back ;
    private ImageView iv;
    private MediaPlayer [] mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv = (ImageView) findViewById(R.id.img_logo);
        sp_music = (Spinner) findViewById(R.id.sp_music);
        btn_play = (ImageButton) findViewById(R.id.btn_play);
        btn_pause = (ImageButton) findViewById(R.id.btn_pause);
        btn_stop = (ImageButton) findViewById(R.id.btn_stop);
        btn_looping = (ImageButton) findViewById(R.id.btn_looping);
        btn_next = (ImageButton) findViewById(R.id.btn_next);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        player = new Player();
        mediaPlayer=loadMusic();


            String [] songs = new String[]{
                    "rosalia",
                    "thesmithscatorce",
                    "thesmithscinco",
                    "thesmithscuatro",
                    "thesmithsquince",
                    "thesmithsocho",
                    "onestepcloser",
                    "withyou",
                    "papercut"
            };

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                    this,android.R.layout.simple_list_item_1, songs
            );

            stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            sp_music.setAdapter(stringArrayAdapter);

            sp_music.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    position = sp_music.getSelectedItemPosition();
                    if(mediaPlayer[position].isPlaying()){
                        mediaPlayer[position].stop();
                    }else{
                        player.stop(btn_stop,btn_play,mediaPlayer[position],MainActivity.this);
                        player.nextSong(btn_next, btn_play,mediaPlayer[sp_music.getSelectedItemPosition()+1], MainActivity.this);
                        player.play(btn_play, btn_pause, btn_stop,mediaPlayer[position], MainActivity.this);
                        player.play(btn_play, btn_pause, btn_stop,mediaPlayer[position], MainActivity.this);
                        player.pause(btn_pause, btn_play, mediaPlayer[position],MainActivity.this);
                        player.loopingSong(btn_looping, mediaPlayer[position], MainActivity.this);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        int position = sp_music.getSelectedItemPosition();
        player.stop(btn_stop,btn_play,mediaPlayer[position],this);
    }


    public MediaPlayer[] loadMusic (){
    MediaPlayer [] listMp3 = new MediaPlayer[10];
    listMp3 [0] = MediaPlayer.create(this, R.raw.rosalia);
    listMp3 [1] = MediaPlayer.create(this, R.raw.thesmithscatorce);
    listMp3 [2] = MediaPlayer.create(this, R.raw.thesmithscinco);
    listMp3 [3] = MediaPlayer.create(this, R.raw.thesmithscuatro);
    listMp3 [4] = MediaPlayer.create(this, R.raw.thesmithsquince);
    listMp3 [5] = MediaPlayer.create(this, R.raw.thesmithsocho);
    listMp3 [6] = MediaPlayer.create(this, R.raw.onestepcloser);
    listMp3 [7] = MediaPlayer.create(this, R.raw.withyou);
    listMp3 [8] = MediaPlayer.create(this, R.raw.papercut);

    return listMp3;
    }





}



/**
 * //Comprobamos el estado de la memoria externa (tarjeta SD)
 *         String estado = Environment.getExternalStorageState();
 *
 *         if (estado.equals(Environment.MEDIA_MOUNTED))
 *         {
 *             sdDisponible = true;
 *             sdAccesoEscritura = true;
 *             Toast.makeText(this,"HE ENTRADO EN EL IF", Toast.LENGTH_SHORT).show();
 *         }
 *         else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
 *         {
 *             sdDisponible = true;
 *             sdAccesoEscritura = false;
 *             Toast.makeText(this,"HE ENTRADO EN EL ELSE IF", Toast.LENGTH_SHORT).show();
 *         }
 *         else
 *         {
 *             sdDisponible = false;
 *             sdAccesoEscritura = false;
 *             Toast.makeText(this,"HE ENTRADO EN EL ELSE", Toast.LENGTH_SHORT).show();
 *         }
 **/