package com.example.canvas


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import com.example.canvas.main_canvas.MainCanvas


class MainActivity : AppCompatActivity() {


    lateinit var mainCanvas: MainCanvas


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainCanvas = MainCanvas(this)
        mainCanvas.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        mainCanvas.contentDescription = getString(R.string.canvasContentDescription)
        setContentView(R.layout.activity_main)





    }



}