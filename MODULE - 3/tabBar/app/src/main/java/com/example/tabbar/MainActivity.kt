package com.example.tabbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    var tablayout:TabLayout?=null
    var viewPager:ViewPager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tablayout = findViewById(R.id.mytablayout)
        viewPager=findViewById(R.id.myviewpager)


        tablayout!!.tabGravity=TabLayout.GRAVITY_FILL;

        setUpViewPager(viewPager!!)
        tablayout!!.setupWithViewPager(viewPager)

    }
    fun setUpViewPager(viewPager:ViewPager)
    {
        var adapter:ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ChatsFragment(),"Chats")
        adapter.addFragment(StatusFragment(),"Status")
        viewPager.adapter =adapter
    }
    class ViewPagerAdapter :FragmentPagerAdapter{
         var fragmentList:ArrayList<Fragment> = ArrayList()
        var fragmentTitleList:ArrayList<String> = ArrayList()

        constructor(supportFragmentManager: FragmentManager):super(supportFragmentManager)

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList.get(position)
        }
        fun addFragment(fragment:Fragment,title:String)
        {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }
    }
}