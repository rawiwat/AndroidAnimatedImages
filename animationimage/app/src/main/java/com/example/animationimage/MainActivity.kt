package com.example.animationimage

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val drawableIds = listOf(R.drawable.actually,R.drawable.bonk_animated)
    var pointer = 0
    fun incrementPointer(){
        pointer ++
        if(pointer>= drawableIds.size){
            pointer=0
        }
    }
    fun decrementPointer() {
        pointer--
        if(pointer<0){
            pointer = drawableIds.size - 1
        }
    }

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_next.setOnClickListener{
            incrementPointer()
            animated_image.setImageDrawable(ContextCompat.getDrawable(this, drawableIds[pointer]))
        }
        button_previous.setOnClickListener{
            decrementPointer()
            animated_image.setImageDrawable(ContextCompat.getDrawable(this, drawableIds[pointer]))
        }
        button_play.setOnClickListener{ view ->
            when(pointer){
                0->animatedgif(drawableIds[pointer])
                1->animatedAnimationDrawable(drawableIds[pointer])
            }
            animatedVectorDrawable(R.drawable.avd_playtopause, view as ImageView)
        }


        /*this add and animate a gif*/


        //animatedgif()
        /*this add gif with animated drawable*/
        //animatedAnimationDrawable()
        /*this use vector drawable*/

        //animatedVectorDrawable()
    }

    private fun animatedVectorDrawable(id: Int,view: ImageView) {
        val animatedVectorDrawable = ContextCompat.getDrawable(this, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }

    private fun animatedAnimationDrawable(id: Int) {
        val frameDrawable = ContextCompat.getDrawable(this, id)
        animated_image.setImageDrawable(frameDrawable)
        (frameDrawable as AnimationDrawable).start()
    }

    private fun animatedgif(id: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val gifDrawable =
                ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources, id))
            animated_image.setImageDrawable(gifDrawable)
            (gifDrawable as AnimatedImageDrawable).start()
        }
    }
}