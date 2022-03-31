package cat.copernic.msabatem.sensoresejercicios

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Actividad3 : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var mLight: Sensor? = null
    private var mTemp: Sensor? = null
    private var mPress: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad3)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        mPress = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }

    override fun onSensorChanged(event: SensorEvent) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.


        if(event.sensor.type == Sensor.TYPE_LIGHT){
            findViewById<TextView>(R.id.tv_light).text = "Val:" + event.values[0].toString();
        }
        if(event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE){
            findViewById<TextView>(R.id.tv_temp).text =  "X:" + event.values[0].toString() + "\n Y: " + event.values[1].toString() + "\n Z: " + event.values[2].toString();
        }
        if(event.sensor.type == Sensor.TYPE_PRESSURE){
            findViewById<TextView>(R.id.tv_pres).text =  "X:" + event.values[0].toString() + "\n Y: " + event.values[1].toString() + "\n Z: " + event.values[2].toString();
        }


        // Do something with this sensor value.
    }

    override fun onResume() {
        super.onResume()
        mLight?.also { values ->
            sensorManager.registerListener(this, values, SensorManager.SENSOR_DELAY_NORMAL)
        }
        mTemp?.also { values ->
            sensorManager.registerListener(this, values, SensorManager.SENSOR_DELAY_NORMAL)
        }

        mPress?.also { values ->
            sensorManager.registerListener(this,values, SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}