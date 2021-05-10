package com.vuonghung.androidbase.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected var mSavedDataByManual: Boolean = false

    abstract fun setSavedDataByManual(byManual: Boolean)

    fun showToast(msg: String?, duration: Int? = Toast.LENGTH_SHORT) {
        Toast.makeText(this.context, msg, duration!!).show()
    }

    override fun onStop() {
        super.onStop()
    }

    abstract fun viewReadyToUse()
    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewReadyToUse()
    }

    protected fun popBack() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).onBackPressed()
        }
    }

    protected fun replaceFrag(fragment: Fragment, rootId: Int, isBackStack: Boolean = false) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).replaceFragment(fragment, rootId, isBackStack)
        }
    }
}