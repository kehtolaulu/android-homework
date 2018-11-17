package com.example.kehtolaulu.homework05

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HomeFragment : Fragment() {
    lateinit var tvHomeTitle : TextView

    companion object {
        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container,
        false)
        tvHomeTitle = view.findViewById(R.id.tv_home_title)
        return view
    }

}
