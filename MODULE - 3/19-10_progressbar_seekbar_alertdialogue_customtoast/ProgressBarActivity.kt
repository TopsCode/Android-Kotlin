package com.example.listexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn1
import kotlinx.android.synthetic.main.activity_progress_bar.*

class ProgressBarActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        btn1.setOnClickListener()
        {
            pb.incrementProgressBy(1)
            setProgress(100*pb.progress)
        }
        btn2.setOnClickListener()
        {
            pb.incrementProgressBy(-1)
            setProgress(100*pb.progress)
        }

    }
}