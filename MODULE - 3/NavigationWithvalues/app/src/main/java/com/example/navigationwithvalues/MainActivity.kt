package com.example.navigationwithvalues

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn_submit=findViewById<Button>(R.id.btn_submit)
        //Custom toast
        var custom_toasts=findViewById<LinearLayout>(R.id.custom_toast)
        val layout=layoutInflater.inflate(R.layout.customtoast,custom_toasts)

        // dynamic text
        var mainContainer=findViewById<LinearLayout>(R.id.ll_main)
        var textview=TextView(this)

        btn_submit.setOnClickListener{
            //Custom toast
            var toast=Toast(applicationContext)
            toast.duration=Toast.LENGTH_SHORT
            toast.setGravity(Gravity.CENTER_VERTICAL,0,0)
            toast.view=layout
            toast.show()
            //dynamic text

            textview.layoutParams=LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            textview.text="This is dynamic text"
            textview.setTextSize(20f)
            textview.setTextColor(Color.CYAN)
            mainContainer?.addView(textview);

        }

    }
}