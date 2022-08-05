package com.example.fragmentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v=inflater.inflate(R.layout.fragment_blank, container, false)
        var btn=v.findViewById<Button>(R.id.btn)

        var bundle=arguments
        var message=bundle!!.getString("mydata")
        var tv=v.findViewById<TextView>(R.id.tv)
        tv.text=message;


        btn.setOnClickListener {
            var i =Intent(activity,SecondActivity::class.java)
            startActivity(i)
        }
        return v;
    }


}