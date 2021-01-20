package mx.tecnm.tepic.ladm_u4_practica1_canvas_sensores

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

class MOV {
    var x = 0f
    var y = 0f
    var ancho = 0f
    var alto = 0f
    var icono : Bitmap?=null
    var invisible = false
    var tipo = 3

    constructor(x:Int, y:Int, b:Bitmap){
        this.icono = b
        this.x = x.toFloat()
        this.y = y.toFloat()
        ancho = icono!!.width.toFloat()
        alto = icono!!.height.toFloat()
        tipo = 3
    }

    fun pintar(c: Canvas, x1:Float,y2:Float, p: Paint){
        if(!this.invisible){
            when(tipo){
                3->{
                    c.drawBitmap(icono!!,x1,y2,p)
                }
            }
        }
    }

    fun invisible(){
        this.invisible = true
    }
    fun visible(){
        this.invisible = false
    }

    fun asignarX(x: Int){
        this.x = x.toFloat()
    }
}