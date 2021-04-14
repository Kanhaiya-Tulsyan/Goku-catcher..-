package com.example.goku_catcher

import android.media.TimedText
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    var score:Int=0
    var imagearray=ArrayList<ImageView>()
    var handler: Handler= Handler()
    var runnable: Runnable= Runnable {  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score = 0
        imagearray= arrayListOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)
        hideimages()


        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                timeText.text = "OVER"
                handler.removeCallbacks(runnable)
                for (image in imagearray) {
                    image.visibility = View.INVISIBLE
                }
            }

        }.start()
    }
    fun hideimages() {
        runnable = Runnable {
            for (image in imagearray) {
                image.visibility = View.INVISIBLE
            }
            val random= kotlin.random.Random
            val index=random.nextInt(8-0)

            imagearray[index].visibility = View.VISIBLE
            handler.postDelayed(runnable, 400)
        }
        handler.post(runnable)
    }




    fun increaseScore(view: View){
        score++
        scoreText.text="Score: "+score
    }



}