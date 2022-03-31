package cat.copernic.msabatem.sensoresejercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Actividad5 : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad5)




        var bt1 = findViewById<Button>(R.id.btn_1);
        var bt2 = findViewById<Button>(R.id.btn_2);
        var bt3 = findViewById<Button>(R.id.btn_3);
        var bt4 = findViewById<Button>(R.id.btn_4);
        var bt_parlar = findViewById<Button>(R.id.btn_parlar);
        var et_textveu = findViewById<EditText>(R.id.et_textveu);

        bt1.isEnabled = false;
        bt2.isEnabled = false;
        bt3.isEnabled = false;
        bt4.isEnabled = false;

        et_textveu.setText("Mira como tira esta moto: iiiiiiiiiiii")

        tts = TextToSpeech(this, this)

        val speechListener = object : UtteranceProgressListener() {
            // https://developer.android.com/reference/kotlin/android/speech/tts/UtteranceProgressListener
            override fun onStart(p: String?) {

                bt1.post {
                    bt1.isEnabled = false
                    bt2.isEnabled = false
                    bt3.isEnabled = false
                    bt4.isEnabled = false
                    bt_parlar.isEnabled = false;
                }
            }

            override fun onDone(p: String?) {

                bt1.post {
                    bt1.isEnabled = true
                    bt2.isEnabled = true
                    bt3.isEnabled = true
                    bt4.isEnabled = true
                    bt_parlar.isEnabled = true
                }
            }

            override fun onError(p: String?) {

                bt1.post {
                    bt1.isEnabled = true
                    bt2.isEnabled = true
                    bt3.isEnabled = true
                    bt4.isEnabled = true
                    bt_parlar.isEnabled = true
                }
            }
        }

        tts.setOnUtteranceProgressListener(speechListener)

        bt1.setOnClickListener {
            bt1.isEnabled = false
            bt2.isEnabled = false
            bt3.isEnabled = false
            bt4.isEnabled = false
            bt_parlar.isEnabled = false
            parlar(1);
        }
        bt2.setOnClickListener {
            bt1.isEnabled = false
            bt2.isEnabled = false
            bt3.isEnabled = false
            bt4.isEnabled = false
            bt_parlar.isEnabled = false
            parlar(2);
        }
        bt3.setOnClickListener {
            bt1.isEnabled = false
            bt2.isEnabled = false
            bt3.isEnabled = false
            bt4.isEnabled = false
            bt_parlar.isEnabled = false
            parlar(3);
        }
        bt4.setOnClickListener {
            bt1.isEnabled = false
            bt2.isEnabled = false
            bt3.isEnabled = false
            bt4.isEnabled = false
            bt_parlar.isEnabled = false
            parlar(4);
        }

        bt_parlar.setOnClickListener {
            bt1.isEnabled = false
            bt2.isEnabled = false
            bt3.isEnabled = false
            bt4.isEnabled = false
            bt_parlar.isEnabled = false
            parlar(5);
        }
    }

    private fun parlar(type: Int){
        var text = "";

        when(type){
            1->text = "Uno";
            2->text = "Dos";
            3->text = "Tres";
            4->text = "Si, es el cuatro";
            5->text = findViewById<EditText>(R.id.et_textveu).text.toString();
        }



        // https://developer.android.com/reference/android/speech/tts/TextToSpeech --> constants
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.getDefault())

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                findViewById<Button>(R.id.btn_1).isEnabled = true;
                findViewById<Button>(R.id.btn_2).isEnabled = true;
                findViewById<Button>(R.id.btn_3).isEnabled = true;
                findViewById<Button>(R.id.btn_4).isEnabled = true;
                findViewById<Button>(R.id.btn_parlar).isEnabled = true;

            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
}