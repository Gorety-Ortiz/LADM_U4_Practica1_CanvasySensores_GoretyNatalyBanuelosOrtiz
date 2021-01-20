package mx.tecnm.tepic.ladm_u4_practica1_canvas_sensores


import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display

class MainActivity : AppCompatActivity(), SensorEventListener {
    var l : Lienzo ? =null
    lateinit var sensorManagerMovimineto : SensorManager
    lateinit var sensorManagerProximacion : SensorManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManagerMovimineto = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManagerProximacion = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        setContentView(Dibujar(this,sensorManagerMovimineto,sensorManagerProximacion))

    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {

        var mover = Intent(this,Dibujar::class.java)
        mover.putExtra("X",event!!.values[0])
        mover.putExtra("Y",event!!.values[1])
        mover.putExtra("Z",event!!.values[2])



    }

}
