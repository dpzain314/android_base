package com.vuonghung.androidbase.ui.base

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

abstract class BaseActivity : AppCompatActivity() {
    private var mActivity: WeakReference<Context>? = null
    private var listener: OnFinishInputText? = null

    interface OnFinishInputText {
        fun onFinish(viewID: Int)
    }

    open fun setOnFinishInputTextListener(onFinishInputText: OnFinishInputText?) {
        this.listener = onFinishInputText
    }

    abstract fun initial()
    abstract fun getLayout(): Int

    private var mBundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBundle = savedInstanceState
        mActivity = WeakReference(this)
        setContentView(getLayout())
        initial()
    }

    override fun onStop() {
        super.onStop()
        mBundle = Bundle()
    }

    fun addFragment(fragment: Fragment, rootId: Int, isAddBackStack: Boolean) {
        if (isAddBackStack) {
            supportFragmentManager.beginTransaction()
                .add(rootId, fragment, fragment::class.java.simpleName)
                .addToBackStack(fragment::class.java.simpleName).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(rootId, fragment, fragment::class.java.simpleName).commit()
        }
    }

    fun replaceFragment(fragment: Fragment, rootId: Int, isAddBackStack: Boolean) {
        if (isAddBackStack) {
            supportFragmentManager.beginTransaction()
                .replace(rootId, fragment, fragment::class.java.simpleName)
                .addToBackStack(fragment::class.java.simpleName).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(rootId, fragment, fragment::class.java.simpleName)
                .commit()
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(event)

        if (view is EditText) {
            val w = currentFocus
            val location = IntArray(2)
            w!!.getLocationOnScreen(location)
            val x = event.rawX + w.left - location[0]
            val y = event.rawY + w.top - location[1]
            if (event.action === MotionEvent.ACTION_DOWN && (x < w.left || x >= w.right || y < w.top || y > w.bottom)) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(window.currentFocus!!.windowToken, 0)
                if (listener != null) {
                    listener!!.onFinish(view.id)
                }
                view.clearFocus()
            }
        }
        return ret
    }
}
