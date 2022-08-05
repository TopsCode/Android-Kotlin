package com.example.tablayoutex

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class MyAdapter1(fm: FragmentManager)  : FragmentStatePagerAdapter(fm)
{

    var listFragment: MutableList<Fragment> = ArrayList()
    var listtitle: MutableList<String> = ArrayList()




    override fun getCount(): Int
    {
        return listtitle!!.size
    }

    override fun getItem(position: Int): Fragment
    {
      return listFragment!![position]
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return listtitle!!.get(position)
    }

    fun adddata(list: String,fragment: Fragment)
    {
        listtitle!!.add(list)
        listFragment!!.add(fragment)
    }
}