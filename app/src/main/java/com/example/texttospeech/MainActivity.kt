package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var ettext : EditText
    lateinit var btspeak : Button
    lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ettext=findViewById(R.id.ettext)
        btspeak=findViewById(R.id.btspeak)
        btspeak.isEnabled= false
        tts= TextToSpeech(this,this)
        btspeak.setOnClickListener {
            val text = ettext.text.toString()
            tts.speak(text,TextToSpeech.QUEUE_FLUSH,null," ")
        }

    }
    override fun onInit(p0: Int) {
        if(status==TextToSpeech.SUCCESS)
        {
            var result=tts.setLanguage(Locale.US)
            if(result==TextToSpeech.LANG_MISSING_DATA|| result==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                //Toast
            }
            else
            {
                btspeak.isEnabled=true
            }
        }
        TODO("Not yet implemented")
    }
}
