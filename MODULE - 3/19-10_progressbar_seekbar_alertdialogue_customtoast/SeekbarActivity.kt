package com.example.listexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_seek_bar.*

class SeekbarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)

        seek1.setOnSeekBarChangeListener(this)
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        var r=0
        var g=0
        var b=0

        r=seek1.progress
        g=seek2.progress
        b=seek3.progress

        img.setBackgroundColor(Color.rgb(r,g,b))



    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}