package mx.tecnm.tepic.ladm_u4_practica1_canvas_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity): View(p){


    var dia = BitmapFactory.decodeResource(resources,R.drawable.dia1)
    var noche = BitmapFactory.decodeResource(resources,R.drawable.noche)
    var pikachu = BitmapFactory.decodeResource(resources, R.drawable.stitch)


    var calx1=200f
    var caly1=300f
    var incrementoY = 0.5f
    var incrementoX = 0.5f

    //MANDAR A LLAMAR A MOV (CLASE)
    var pika = MOV(0,100,pikachu)
    var dibujo1 = MOV(0,0,dia)
    var dibujo2 = MOV(0,0,noche)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var paint = Paint()

        dibujo2.pintar(c,0f,0f,paint)
        dibujo1.pintar(c,0f,0f,paint)
        pika.pintar(c,calx1,caly1,paint)
    }

}
