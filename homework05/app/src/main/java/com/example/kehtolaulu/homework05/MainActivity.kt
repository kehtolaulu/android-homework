package com.example.kehtolaulu.homework05

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var homeFragment: HomeFragment
    private lateinit var recyclerFragment: RecyclerFragment
    private lateinit var pagerFragment: PagerFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recycler -> {
                setFragment(recyclerFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pager -> {
                setFragment(pagerFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeFragment = HomeFragment.newInstance()
        recyclerFragment = RecyclerFragment.newInstance()
        pagerFragment = PagerFragment.newInstance()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }

}
