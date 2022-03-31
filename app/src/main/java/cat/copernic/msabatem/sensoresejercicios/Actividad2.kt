package cat.copernic.msabatem.sensoresejercicios

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Actividad2 : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var mGyro: Sensor? = null
    private var mAcel: Sensor? = null
    private var mMagn: Sensor? = null
    private var mGrav: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        mMagn = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mAcel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGrav = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }

    override fun onSensorChanged(event: SensorEvent) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.


        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            findViewById<TextView>(R.id.tv_acel).text = "X:" + event.values[0].toString() + "\n Y: " + event.values[1].toString() + "\n Z: " + event.values[2].toString();
        }
        if(event.sensor.type == Sensor.TYPE_GYROSCOPE){
            findViewById<TextView>(R.id.tv_gyro).text =  "X:" + event.values[0].toString() + "\n Y: " + event.values[1].toString() + "\n Z: " + event.values[2].toString();
        }
        if(event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD){
            findViewById<TextView>(R.id.tv_magn).text =  "X:" + event.values[0].toString() + "\n Y: " + event.values[1].toString() + "\n Z: " + event.values[2].toString();
        }
        if(event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD){
            findViewById<TextView>(R.id.tv_grav).text =  "X:" + event.values[0].toString() + "\n Y: " + event.values[1].toString() + "\n Z: " + event.values[2].toString();
        }


        // Do something with this sensor value.
    }

    override fun onResume() {
        super.onResume()
        mGyro?.also { values ->
            sensorManager.registerListener(this, values, SensorManager.SENSOR_DELAY_NORMAL)
        }
        mAcel?.also { values ->
            sensorManager.registerListener(this, values, SensorManager.SENSOR_DELAY_NORMAL)
        }

        mMagn?.also { values ->
            sensorManager.registerListener(this,values,SensorManager.SENSOR_DELAY_NORMAL)
        }

        mGrav?.also { values ->
            sensorManager.registerListener(this,values,SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}