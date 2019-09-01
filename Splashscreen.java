package com.kjhan.bharathdynamicslimited;

//import com.kjhan.bharathdynamicslimited.MainActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

//import java.util.Random;
public class Splashscreen extends Activity{
    Thread splashTread;
    ViewFlipper vflipper;
    MediaPlayer playsound;
    //int[] ids;
    //int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

         playsound=MediaPlayer.create(this,R.raw.sarejahan1);

       vflipper=findViewById(R.id.viewflipper);
        int[] ids = new int[]{R.drawable.bdllogo2,R.drawable.bdllogo1,R.drawable.bdllogo3,R.drawable.bharat_dynamics_logo,R.drawable.bdllastslide};


      //  Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        //imageView.startAnimation(animation);
        //this.imageView.setImageDrawable(getResources().getDrawable(ids[0]));

        playsound.start();
        for(int i:ids)
        {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(i);
            vflipper.addView(imageView);
            vflipper.setFlipInterval(2000);
            vflipper.setAutoStart(true);
            vflipper.setInAnimation(this, R.anim.fade_in);
            vflipper.setOutAnimation(this, R.anim.fade_out);
            if(i==5)
            {
                vflipper.stopFlipping();
            }
        }

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 9900) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splashscreen.this,
                            MainActivity.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);

                    overridePendingTransition(R.anim.alpha,R.anim.translate);
                    //Splashscreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splashscreen.this.finish();
                }

            }
        };
      splashTread.start();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        playsound.release();
        finish();
    }

}
