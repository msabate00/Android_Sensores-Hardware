package cat.copernic.msabatem.sensoresejercicios

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt


class Actividad4 : AppCompatActivity(), SensorEventListener {

    var cali = arrayOf(0F,0F,0F);
    var caliO = arrayOf(0F,0F,0F);
    private lateinit var sensorManager: SensorManager
    private var mAcel: Sensor? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad4)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAcel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        draw();

        findViewById<Button>(R.id.btn_calibrar).setOnClickListener {
            caliO[0] = -cali[0];
            caliO[1] = cali[1];
        }


    }



    fun draw(){

        val bitmap = Bitmap.createBitmap(
            400,  // Width
            400,  // Height
            Bitmap.Config.ARGB_8888 // Config
        )
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.BLACK)
        val paint = Paint()


        fun drawExterior(){
            paint.style = Paint.Style.STROKE
            paint.color = Color.RED
            paint.isAntiAlias = true
            val radius = Math.min(canvas.width, canvas.height / 2)
            val padding = 5
            canvas.drawCircle(
                (canvas.width / 2).toFloat(),  // cx
                (canvas.height / 2).toFloat(),  // cy
                (radius - padding).toFloat(),  // Radius
                paint // Paint
            )
        }



        fun drawBall(x: Float =  (canvas.width / 2).toFloat()-200, y: Float = (canvas.height / 2).toFloat()-200){


            paint.style = Paint.Style.FILL
            paint.color = Color.parseColor("#034efc");
            val radius = 25

            canvas.drawCircle(
                x+200,  // cx
                y+200,  // cy
                radius.toFloat(),  // Radius
                paint // Paint
            )

            paint.color = (Color.WHITE);
            canvas.drawCircle(
                (canvas.width / 2).toFloat(),  // cx
                (canvas.height / 2).toFloat(),  // cy
                5F,  // Radius
                paint // Paint
            )

        }

        drawExterior();
        drawBall((cali[0] + caliO[0])*20, (-cali[1] + caliO[1])*20);










        findViewById<ImageView>(R.id.iv_image).setImageBitmap(bitmap)


    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Do something here if sensor accuracy changes.
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){

            cali[0] = event.values[0];
            cali[1] = event.values[1];
            cali[2] = event.values[2];
            draw();
        }
    }

    override fun onResume() {
        super.onResume()
        mAcel?.also { values ->
            sensorManager.registerListener(this, values, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }



}