package com.example.fragmentex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_1.*


class Fragment1 : Fragment() {


    lateinit var t1:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_1, container, false)

        t1=view.findViewById(R.id.t1)

        t1.setOnClickListener()
        {
            //F to A
            /*val intent=Intent(activity,MainActivity::class.java)
            startActivity(intent)*/

        //F to F
            mydata(Fragment2())


        }

        return view
    }

    private fun mydata(fragment2: Fragment2)
    {
            val fm:FragmentManager= requireFragmentManager()
            val ft:FragmentTransaction=fm.beginTransaction()
            ft.replace(R.id.frmid,fragment2).commit()
    }


}