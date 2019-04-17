package com.nguyendinhdoan.taglayoutdialogfragment

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainAdapter(
    private val context: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    companion object {
        private const val FRAGMENT_PAGER_TOTAL = 2
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return LoginFragment.newInstance(position)
            1 -> return RegisterFragment.newInstance(position)
        }
        return null
    }

    override fun getCount(): Int {
        return FRAGMENT_PAGER_TOTAL
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> return context.getString(R.string.tab_login)
            1 -> return context.getString(R.string.tag_register)
        }
        return null
    }

}