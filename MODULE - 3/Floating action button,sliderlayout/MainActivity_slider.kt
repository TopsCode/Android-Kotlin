package com.example.sliderlayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView

import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity()
{
    lateinit var mDemoSlider: SliderLayout
    lateinit var float1:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mDemoSlider=findViewById(R.id.slider)
        float1=findViewById(R.id.f1)

        val file_maps = HashMap<String, Int>()
        file_maps["a1"] = R.drawable.a
        file_maps["b1"] = R.drawable.b
        file_maps["c1"] = R.drawable.c

            for(name:String in file_maps.keys)
            {
                    var textSliderView=TextSliderView(this)
                    textSliderView.description(name)
                    textSliderView.image(file_maps.get(name)!!)
                    textSliderView.setScaleType(BaseSliderView.ScaleType.Fit)

                mDemoSlider.addSlider(textSliderView)

            }
                 mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomIn);


            float1.setOnClickListener()
            {

                Snackbar.make(it,"success",Snackbar.LENGTH_LONG).show()


            }
    }
}