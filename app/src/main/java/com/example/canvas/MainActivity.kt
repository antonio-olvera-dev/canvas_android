package com.example.canvas


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.inflate
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.canvas.data.model.SignatureRequest
import com.example.canvas.data.service.SignatureClient
import com.example.canvas.data.service.SignatureService
import com.example.canvas.databinding.ActivityMainBinding
import com.example.canvas.main_canvas.MainCanvas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {


    lateinit var mainCanvas: MainCanvas
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainCanvas = MainCanvas(this)
        mainCanvas.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        mainCanvas.contentDescription = getString(R.string.canvasContentDescription)
        val inflate = inflate(applicationContext, R.layout.activity_main, null)
        inflate.findViewById<LinearLayout>(R.id.ly_canvas).addView(mainCanvas)




        inflate.findViewById<Button>(R.id.bt_canvas).setOnClickListener {

            GlobalScope.launch(Dispatchers.Main) {

                var text = ""
                withContext(Dispatchers.IO) {
                    text = mainCanvas.controller.parseToJpeg()

                   val newSignatureRequest =  SignatureRequest(
                        "cmkck4j3",
                        text,
                        text
                    )
                    SignatureService().postSignature(newSignatureRequest)
                }
                inflate.findViewById<TextView>(R.id.tv_canvas).text = text.substring(text.length - 10, text.length)
            }


        }

        setContentView(inflate)
    }


}