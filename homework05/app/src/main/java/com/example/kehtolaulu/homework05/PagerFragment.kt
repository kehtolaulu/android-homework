package com.example.kehtolaulu.homework05

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.FragmentPagerAdapter


class PagerFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pager, null)
        viewPager = view.findViewById(R.id.pager)
        pagerAdapter = MyFragmentPagerAdapter(childFragmentManager)
        (pagerAdapter as MyFragmentPagerAdapter).addFragment(PageFragment.newInstance(1))
        (pagerAdapter as MyFragmentPagerAdapter).addFragment(PageFragment.newInstance(2))
        (pagerAdapter as MyFragmentPagerAdapter).addFragment(PageFragment.newInstance(3))
        viewPager.adapter = pagerAdapter
        tabLayout = view.findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
        return view
    }

    companion object {
        fun newInstance(): PagerFragment {
            return PagerFragment()
        }
    }

    private inner class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val mFragmentList = ArrayList<Fragment>()

        override fun getItem(position: Int): Fragment {
            return PageFragment.newInstance(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return "Fragment $position"
        }

        fun addFragment(fragment: Fragment) {
            mFragmentList.add(fragment)
        }
    }

}
