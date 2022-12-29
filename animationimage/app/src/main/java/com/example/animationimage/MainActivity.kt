package com.example.animationimage

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        this add and animate a gif
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val gifDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources, R.drawable.amogus))
            animated_image.setImageDrawable(gifDrawable)
            (gifDrawable as AnimatedImageDrawable).start()
        }
        this add gif with animated drawable
        val frameDrawable = ContextCompat.getDrawable(this,R.drawable.bonk_animated)
        animated_image.setImageDrawable(frameDrawable)
        (frameDrawable as AnimationDrawable).start()
        this use vector drawable
        */
        val animatedVectorDrawable = ContextCompat.getDrawable(this,R.drawable.avd_playtopause)
        animated_image.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }
}