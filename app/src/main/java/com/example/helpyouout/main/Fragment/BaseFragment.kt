package com.example.helpyouout.main.Fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ApplicationClass
import com.example.helpyouout.main.BaseActivity
import com.example.helpyouout.utli.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment() {

    /*
    * Lateinit vars*/
    lateinit var mContext: Context
    lateinit var currentView: View
    lateinit var currentFragment: Fragment
    lateinit var prefs: Prefs
    lateinit var baseActivity: BaseActivity

    /*
    * Initialized vars*/


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        currentView = setContentView(inflater, container);
//         inflater.inflate(setContentView(inflater, container), container, false)!!
        baseActivity = activity as BaseActivity

        prefs = ApplicationClass.mInstance.getPrefs()!!

        init()
        buttonClicks()
        setFragment()

        return currentView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    fun setFragment() {

        Handler().postDelayed(object : Runnable {
            override fun run() {
                val fragments = (context as BaseActivity).getLocalFragmentManager().fragments
                for (i in 0 until fragments.size) {
                    if (fragments[i].isVisible) {
                        currentFragment = fragments[i]
                    }
                }
            }
        }, 300)
    }

    fun removeFragment() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                hideKeyboard()
                baseActivity.removeFragment(currentFragment)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun hideKeyboard() {
        baseActivity.hideKeyboard()
    }

    fun go(cls: Class<*>) {
        baseActivity.go(cls)
    }

    fun goWithFinish(cls: Class<*>) {
        baseActivity.goWithFinish(cls)
    }

    fun goWithFinish(cls: Class<*>, bundle: Bundle) {
        baseActivity.goWithFinish(cls, bundle)
    }

    fun go(cls: Class<*>, bundle: Bundle?) {
        baseActivity.go(cls, bundle)
    }



    fun addFragment(newFragment: Fragment) {
        baseActivity.addFragment(newFragment)
    }

    fun replaceFragment(newFragment: Fragment) {
        baseActivity.replaceFragment(newFragment)
    }

//    fun setToolbar(title: String, isBack: Boolean = false, toolbar: Toolbar) {
//        baseActivity.setToolbar(title, isBack, toolbar)
//    }

    fun showProgressDialog() {
        baseActivity.showProgressDialog()
    }

    fun hideProgressDialog() {
        baseActivity.hideProgressDialog()
    }

    fun getCurrentTimeStamp(): Long {
        return System.currentTimeMillis() / 1000
    }

    //TODO abstract methods
//    abstract fun setContentView(): Int

    abstract fun setContentView(inflater: LayoutInflater, container: ViewGroup?): View

    abstract fun init()

    abstract fun buttonClicks()

}