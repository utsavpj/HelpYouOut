package com.example.helpyouout.main

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.provider.Settings
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.ApplicationClass
import com.example.helpyouout.R
import com.example.helpyouout.utli.Prefs
import org.jetbrains.anko.AnkoLogger

public abstract class BaseActivity : AppCompatActivity(),AnkoLogger {

    /*
    * Lateinit vars*/
    lateinit var context: Context
    lateinit var prefs: Prefs
    lateinit var inflater: LayoutInflater

    /*
    * Initialized vars*/
    var TAG: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setContentView() > 0)
            setContentView(setContentView())

        context = this
        TAG = context.javaClass.simpleName

        prefs = ApplicationClass.mInstance.getPrefs()!!

        inflater = LayoutInflater.from(context)

        initProgressDialog(context)
        init()
        buttonClicks()

        Handler().postDelayed({
            getScreenResolution()
        }, 300)

    }

     var progressDialog: ProgressDialog? = null


//    fun setToolbar(title: String, isBack: Boolean = false, titleLayView: View) {
//        titleLayView.txtTitle.text = title
//        titleLayView.txtTitle.setTextColor(getColorInt(R.color.white))
//
//        if (isBack) {
//            titleLayView.imgLeftIcon.setImageDrawable(getMaterialDrawable(MaterialIcons.md_arrow_back))
//        } else {
//            titleLayView.imgLeftIcon.setImageDrawable(getMaterialDrawable(MaterialIcons.md_menu))
//        }
//
//    }

    private fun initProgressDialog(context: Context) {
        progressDialog = ProgressDialog(context)
        progressDialog!!.setMessage("Please wait...")
        progressDialog!!.setCancelable(false)
    }

    fun showProgressDialog() {
        try {
            if (!(context as Activity).isFinishing) {
                if (progressDialog != null && !progressDialog!!.isShowing) {
                    progressDialog!!.show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun hideProgressDialog() {
        try {
            if (!(context as Activity).isFinishing)
                if (progressDialog != null
                        && progressDialog!!.isShowing) {
                    progressDialog!!.dismiss()
                }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun go(cls: Class<*>) {
        startActivity(Intent(context, cls))
    }

    fun goWithFinish(cls: Class<*>) {
        startActivity(Intent(context, cls))
        finish()
    }

    fun goWithFinish(cls: Class<*>, bundle: Bundle) {
        startActivity(Intent(context, cls), bundle)
        finish()
    }

    fun go(cls: Class<*>, bundle: Bundle?) {
        startActivity(Intent(context, cls), bundle)
    }


    /*Fragment Methods*/

    fun getLocalFragmentManager(): FragmentManager {
        return supportFragmentManager
    }

    var lastClicked: Long = 0
    fun addFragment(newFragment: Fragment) {
        if (SystemClock.elapsedRealtime() - lastClicked < 1000) {
            print("Escaped from double click...!!!")
            return
        }
        lastClicked = SystemClock.elapsedRealtime()

        getLocalFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.slide_fragment_horizontal_right_in, R.animator.slide_fragment_horizontal_left_out, R.animator.slide_fragment_horizontal_left_in, R.animator.slide_fragment_horizontal_right_out)
                .add(R.id.container, newFragment, newFragment.javaClass.simpleName)
                .addToBackStack(null)
                .commit()
    }

    fun replaceFragment(newFragment: Fragment) {
        getLocalFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.slide_fragment_horizontal_right_in, R.animator.slide_fragment_horizontal_left_out, R.animator.slide_fragment_horizontal_left_in, R.animator.slide_fragment_horizontal_right_out)
                .replace(R.id.container, newFragment, newFragment.javaClass.simpleName)
                .commit()
    }

    fun removeFragment(newFragment: Fragment) {
        getLocalFragmentManager()
                .beginTransaction()
                .remove(newFragment)
                .commit()

    }

    /**
     * With custom framelayout*/

    fun addFragment(newFragment: Fragment, id: Int) {
        if (SystemClock.elapsedRealtime() - lastClicked < 1000) {
            print("Escaped from double click...!!!")
            return
        }
        lastClicked = SystemClock.elapsedRealtime()

        getLocalFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.slide_fragment_horizontal_right_in, R.animator.slide_fragment_horizontal_left_out, R.animator.slide_fragment_horizontal_left_in, R.animator.slide_fragment_horizontal_right_out)
                .add(id, newFragment, newFragment.javaClass.simpleName)
                .addToBackStack(null)
                .commit()
    }

    fun replaceFragment(newFragment: Fragment, id: Int) {
        getLocalFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.slide_fragment_horizontal_right_in, R.animator.slide_fragment_horizontal_left_out, R.animator.slide_fragment_horizontal_left_in, R.animator.slide_fragment_horizontal_right_out)
                .replace(id, newFragment, newFragment.javaClass.simpleName)
                .commit()
    }


    fun finishWithDelay() {
        Handler().postDelayed(object : Runnable {
            override fun run() {
                finish()
            }

        }, 300)
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun openKeyboard(editText: EditText) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(editText.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0)
        editText.requestFocus()
    }

    interface PermissionListener {
        fun onGranted()

        fun onDenied()
    }


    fun toast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun onSettingsShown() {
        // open setting screen
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.data = Uri.parse("package:" + context.getPackageName())
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        context.startActivity(intent)
    }


    var height = 0
    var width = 0

    fun getScreenResolution() {
        if (height <= 0 || width <= 0) {
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            height = displayMetrics.heightPixels
            width = displayMetrics.widthPixels
        }
    }

    //TODO abstract methods
    abstract fun setContentView(): Int

    abstract fun init()

    abstract fun buttonClicks()
}