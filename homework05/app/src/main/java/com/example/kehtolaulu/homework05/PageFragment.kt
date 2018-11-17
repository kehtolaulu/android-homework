package com.example.kehtolaulu.homework05

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

class PageFragment : Fragment() {

    private var pageNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arg = arguments.toString()
        pageNumber = if (arguments != null) arguments!!.getInt("num") else 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val result = inflater.inflate(R.layout.fragment_page, container, false)
        val pageHeader = result.findViewById<TextView>(R.id.pager_title)
        pageHeader.text = "Fragment " + (pageNumber)
        return result
    }

    companion object {
        fun newInstance(page: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt("num", page)
            fragment.arguments = args
            return fragment
        }
    }
}
