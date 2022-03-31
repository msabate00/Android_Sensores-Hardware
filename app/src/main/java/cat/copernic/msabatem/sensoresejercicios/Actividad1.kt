package cat.copernic.msabatem.sensoresejercicios

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Actividad1 : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad1)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        val tv = findViewById<TextView>(R.id.tv_listSensors);
        tv.text = "";
        for(item: Sensor in deviceSensors){
            tv.text = tv.text.toString() + "\n" + item.name;
        }


    }
}