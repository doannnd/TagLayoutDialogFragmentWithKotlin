package com.nguyendinhdoan.taglayoutdialogfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RegisterFragment: Fragment() {

    companion object {
        private const val REGISTER_POSITION_KEY = "REGISTER_POSITION_KEY"

        fun newInstance(fragmentPosition: Int): RegisterFragment {
            val registerFragment = RegisterFragment()
            val args = Bundle()
            args.putInt(REGISTER_POSITION_KEY, fragmentPosition)
            registerFragment.arguments = args
            return registerFragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}