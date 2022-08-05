package com.example.myapplication.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.ui.Model
import com.example.myapplication.ui.MyAdapter

class HomeFragment : Fragment() {

    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
                val view:View= inflater.inflate(R.layout.fragment_home2, container, false)

                listView=view.findViewById(R.id.list)
                list=ArrayList<Model>()


                list.add(Model("Android","Mobile OS"))
                list.add(Model("PHP","web development"))
                list.add(Model("Flutter","Hybrid development"))

                val adapter=MyAdapter(requireActivity(),list)
                listView.adapter=adapter

            listView.setOnItemClickListener()
            {
                    adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

                        val intent=Intent(activity,Xyz::class.java)
                        startActivity(intent)

                  /*  Toast.makeText(activity,i,Toast.LENGTH_LONG).show()

                case 0:

                case 1:

                case 2:
                */
            }


        return view
    }


}