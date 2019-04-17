package com.nguyendinhdoan.taglayoutdialogfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        setupToolbar()
        setupTabLayout()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setupTabLayout() {
        tab_layout.setupWithViewPager(view_pager)
        val mainAdapter = MainAdapter(this, supportFragmentManager)
        view_pager.adapter = mainAdapter
    }
}
