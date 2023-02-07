package com.ozancanguz.bmicalculator.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ozancanguz.bmicalculator.R
import com.ozancanguz.bmicalculator.ui.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
//splash ekran için bir Thread oluşturuyoruz
        val background = object : Thread() {
            override fun run() {
                try {

                    pb.visibility= View.VISIBLE
                    Thread.sleep(6000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    pb.visibility= View.INVISIBLE
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

    }
}