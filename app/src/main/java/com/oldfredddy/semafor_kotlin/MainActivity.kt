package com.oldfredddy.semafor_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var imageArray: IntArray =
        intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)
    var counter: Int = 0
    var timer: Timer? = null
    var is_run: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onClickStartStop(view: View) {
//        imSemafor.setImageResource(R.drawable.semafor_green)
//        imageButton.setImageResource(R.drawable.button_stop)
        view as ImageButton //каст
        if (!is_run) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            is_run = true
        } else  {
            imSemafor.setImageResource(R.drawable.semafor_grey)
            timer?.cancel()
            counter = 0

            imageButton.setImageResource(R.drawable.button_start)

            is_run = false
        }


    }

    private fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread() {
                    imSemafor.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }
        }, 0, 1000)
    }
}