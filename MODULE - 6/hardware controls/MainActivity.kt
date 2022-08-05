package com.example.tts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity()
{
    lateinit var edt:EditText
    lateinit var btn:Button
    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt=findViewById(R.id.edt1)
        btn=findViewById(R.id.btn1)


        tts= TextToSpeech(applicationContext,object:TextToSpeech.OnInitListener
        {
            override fun onInit(p0: Int)
            {

                    if(p0==TextToSpeech.SUCCESS)
                    {

                        val ttsLang: Int = tts.setLanguage(Locale.US)
                        //if(t1.isLanguageAvailable(new Locale("hin"))
                        if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED)
                            {
                                Log.e("TTS", "The Language is not supported!");
                            }
                        else
                        {
                            Log.i("TTS", "Language Supported.");
                        }


                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Initialization failed",Toast.LENGTH_LONG).show()
                    }

            }
        })

        btn.setOnClickListener()
        {

            var data=edt.text.toString()

            val speechStatus: Int = tts.speak(data, TextToSpeech.QUEUE_FLUSH, null)
            if (speechStatus == TextToSpeech.ERROR)
            {
                Log.e("TTS", "Error in converting Text to Speech!");
            }
        }

    }

}