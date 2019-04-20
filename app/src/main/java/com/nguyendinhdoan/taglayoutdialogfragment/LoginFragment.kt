package com.nguyendinhdoan.taglayoutdialogfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), EditNameDialogFragment.EditNameDialogListener {

    companion object {
        private const val LOGIN_FRAGMENT_REQUEST_CODE = 1
        private const val EDIT_NAME_DIALOG_TAG = "EDIT_NAME_DIALOG_TAG"
        private const val LOGIN_POSITION_KEY = "LOGIN_POSITION_KEY"

        fun newInstance(fragmentPosition: Int): LoginFragment {
            val loginFragment = LoginFragment()
            val args = Bundle()
            args.putInt(LOGIN_POSITION_KEY, fragmentPosition)
            loginFragment.arguments = args
            return loginFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        show_dialog_button.setOnClickListener {
            val dialogTitle = activity!!.getString(R.string.dialog_title)
            val editNameDialogFragment = EditNameDialogFragment.newInstance(dialogTitle)
//            editNameDialogFragment.setTargetFragment(this@LoginFragment, LOGIN_FRAGMENT_REQUEST_CODE)
            editNameDialogFragment.show(childFragmentManager, editNameDialogFragment.tag)
        }
    }

    override fun onEditNameDialogListener(yourName: String) {
        Toast.makeText(activity, "name: $yourName", Toast.LENGTH_SHORT).show()
    }
}