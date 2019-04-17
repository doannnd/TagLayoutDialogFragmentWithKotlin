package com.nguyendinhdoan.taglayoutdialogfragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import kotlinx.android.synthetic.main.layout_dialog_edit_name.*
import java.lang.ClassCastException

class EditNameDialogFragment : DialogFragment(), TextView.OnEditorActionListener {

    private lateinit var listener: EditNameDialogListener

    companion object {
        private const val TITLE_KEY = "TITLE_KEY"

        fun newInstance(dialogTitle: String): EditNameDialogFragment {
            val editNameDialogFragment = EditNameDialogFragment()
            val args = Bundle()
            args.putString(TITLE_KEY, dialogTitle)
            editNameDialogFragment.arguments = args
            return editNameDialogFragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            listener = targetFragment as EditNameDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement EditNameDialogListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_dialog_edit_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupUI()
        addEvents()
    }

    private fun setupUI() {
        // get dialog title from arguments and set for custom dialog
        val dialogTitle = arguments!!.getString(TITLE_KEY)
        dialog.setTitle(dialogTitle)

        // set request focus and ...
        your_name_edit_text.requestFocus()
        dialog.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

    private fun addEvents() {
        your_name_edit_text.setOnEditorActionListener(this)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            val yourName = your_name_edit_text.text.toString()
            listener.onEditNameDialogListener(yourName)

            // close the dialog and ....
            dismiss()
            return true
        }
        return false
    }

    interface EditNameDialogListener {
        fun onEditNameDialogListener(yourName: String)
    }
}