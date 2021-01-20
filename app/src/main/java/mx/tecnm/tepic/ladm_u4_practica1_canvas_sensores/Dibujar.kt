package mx.tecnm.tepic.ladm_u4_practica1_canvas_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View

class Dibujar (p:MainActivity, d: SensorManager, v: SensorManager): View(p), SensorEventListener {
    var dia = BitmapFactory.decodeResource(resources,R.drawable.dia1)
    var noche = BitmapFactory.decodeResource(resources,R.drawable.noche)
    var pika = BitmapFactory.decodeResource(resources, R.drawable.stitch)
    var dibujo1 = MOV(0,0,dia)
    var dibujo2 = MOV(0,0,noche)
    var pikachu = MOV(0,100,pika)
    var sensorX : Float = 0f
    var sensorY : Float = 0f
    var sensorZ : Float = 0f
    var prox = 100f
    var sensor1 = d
    var sensor2 = v
    var pinturas = false


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var paint = Paint()

        sensor1.registerListener(this,sensor1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME)
        sensor2.registerListener(this,sensor1.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)


        dibujo2.pintar(c,0f,0f,paint)
        dibujo1.pintar(c,0f,0f,paint)
        pikachu.pintar(c,sensorX*75,sensorZ*150,paint)

        if(pinturas==false) {
            c.drawBitmap(dia, 0f, 0f, paint)
        }
        else {
            c.drawBitmap(noche, 0f, 0f, paint)
        }
        c.drawBitmap(pika,sensorX*75,sensorZ*150,paint)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
    override fun onSensorChanged(event: SensorEvent?) {

        if(Sensor.TYPE_PROXIMITY == event!!.sensor.type){

            if(event!!.values[0]<5)
            {
                pinturas = false
            }
            else
            {
                pinturas = true
            }
            prox=event.values[0]*1000
            invalidate()
        }
        if(Sensor.TYPE_ACCELEROMETER == event!!.sensor.type){
            sensorX  = event!!.values[0]
            sensorY  = event!!.values[1]
            sensorZ  = event!!.values[2]
            invalidate()
        }
    }



}