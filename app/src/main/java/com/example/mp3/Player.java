package com.example.mp3;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class Player {

    public void play(final ImageButton btn_play, final ImageButton btn_pause,
                     final ImageButton btn_stop,
                     final MediaPlayer mediaPlayer, final Context context ){
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                if(mediaPlayer.isPlaying()){
                    msgPlay(context);
                    btn_play.setBackgroundResource(R.drawable.palyblue);
                    btn_pause.setBackgroundResource(R.drawable.pause);
                    btn_stop.setBackgroundResource(R.drawable.stop);

                 //imageView.setImageResource(R.drawable.disk);
                }
            }
        });
    }

    public void pause(final ImageButton btn_pause, final ImageButton btn_play,
                      final MediaPlayer mediaPlayer, final Context context){
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    msgPause(context);
                    mediaPlayer.pause();
                    btn_pause.setBackgroundResource(R.drawable.pause2);
                    btn_play.setBackgroundResource(R.drawable.play3);
                }
            }
        });
    }

    public void stop(final ImageButton btn_stop, final ImageButton btn_play,
                     final MediaPlayer mediaPlayer, final Context context){
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    msgStop(context);
                    mediaPlayer.stop();
                    btn_stop.setBackgroundResource(R.drawable.stop2);
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    btn_play.setBackgroundResource(R.drawable.play3);
                }
            }
        });
    }

    public void loopingSong (final ImageButton btn_looping, final MediaPlayer mediaPlayer, final Context context){
        btn_looping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(mediaPlayer.isLooping()){
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    msgLooping(context);
                    mediaPlayer.isLooping();
                    btn_looping.setBackgroundResource(R.drawable.shuffle);

            }
        });

    }

    public void nextSong(final ImageButton btn_next, final ImageButton btn_play, final MediaPlayer mediaPlayer, final Context context){
        btn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                try{
                    mediaPlayer.prepare();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                msgNext(context);
                mediaPlayer.start();
                btn_next.setBackgroundResource(R.drawable.righticon2);
                btn_play.setBackgroundResource(R.drawable.play3);
                }
        });
    }

    public void msgPlay(Context context){
        Toast toast = Toast.makeText(context, "Play", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void msgPause(Context context){
        Toast toast = Toast.makeText(context, "Pause", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void msgStop(Context context){
        Toast toast = Toast.makeText(context, "Stop", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void msgLooping(Context context){
        Toast toast = Toast.makeText(context, "Repetir", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    private void msgNext(Context context){
        Toast toast = Toast.makeText(context, "Siguiente", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

}
