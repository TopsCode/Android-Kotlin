package com.example.animationex


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {

    //  lateinit var btn:Button
    //  lateinit var imageView: ImageView
    ////  lateinit var mediaPlayer: MediaPlayer
    //lateinit var tops: AnimationDrawable

    lateinit var mAdView : AdView

         override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


             mAdView = findViewById(R.id.adView)
             val adRequest = AdRequest.Builder().build()
             mAdView.loadAd(adRequest)


        //   btn=findViewById(R.id.btnStart)
        // imageView=findViewById(R.id.imageView);
        //  mediaPlayer= MediaPlayer.create(applicationContext,R.raw.nokia)
        //tops= imageView.getBackground() as AnimationDrawable

        /*  if(tops.isRunning()){
            tops.stop();
        }
        else{
            tops.start();
        }*/
        //   animation()

/*

        btn.setOnClickListener()
        {
                    mediaPlayer.start()

        }

    }

    private fun animation()
    {
        val animation=AnimationUtils.loadAnimation(applicationContext,R.anim.data)
        //animation.start()

        imageView.startAnimation(animation)
    }
*/


    }
}