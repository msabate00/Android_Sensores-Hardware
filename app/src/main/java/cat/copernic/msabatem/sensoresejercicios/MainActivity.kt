package cat.copernic.msabatem.sensoresejercicios

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_act_1).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad1::class.java)
            startActivity(switchActivityIntent)
        }

        findViewById<Button>(R.id.btn_act_2).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad2::class.java)
            startActivity(switchActivityIntent)
        }

        findViewById<Button>(R.id.btn_act_3).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad3::class.java)
            startActivity(switchActivityIntent)
        }

        findViewById<Button>(R.id.btn_act_4).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad4::class.java)
            startActivity(switchActivityIntent)
        }

        findViewById<Button>(R.id.btn_act_5).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad5::class.java)
            startActivity(switchActivityIntent)
        }

        findViewById<Button>(R.id.btn_act_6).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad6::class.java)
            startActivity(switchActivityIntent)
        }

        findViewById<Button>(R.id.btn_act_8).setOnClickListener {
            val switchActivityIntent = Intent(this, Actividad8::class.java)
            startActivity(switchActivityIntent)
        }
        findViewById<Button>(R.id.btn_act_9).setOnClickListener {
            /*val switchActivityIntent = Intent(this, Actividad9::class.java)
            startActivity(switchActivityIntent)*/
            // Create a Uri from an intent string. Use the result to create an Intent.
            val gmmIntentUri = Uri.parse("google.streetview:cbll=41.56960892488165, 1.9963458366425217")
            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps")
            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent)
        }



    }
}