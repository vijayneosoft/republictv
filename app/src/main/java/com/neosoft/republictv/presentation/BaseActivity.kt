package com.neosoft.republictv.presentation

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import com.neosoft.republictv.R
import com.neosoft.republictv.presentation.navigation.Navigator
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.toolbar_with_back_arrow.*

/**
 * Created by Vijay on 30/8/19.
 */

@Suppress("DEPRECATION")
abstract class BaseActivity : AppCompatActivity() {

    var mProgressDialog: ProgressDialog? = null
    var mNavigator: Navigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        injectNavigator()

    }

    abstract fun injectComponent()

    /**
     * TODO
     *  intialize mNavigator
     */
    private fun injectNavigator() {
        mNavigator = ((application as UserApplication).getComponent()?.navigator())

    }

    /**
     * TODO
     * child should override for retry on API failure
     */
    fun retry() {

    }

    /**
     * TODO
     * set toolbar with back arrow
     * @param title
     */
    fun setToolbar(title: String) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val mToolBarTitle = toolbar.findViewById<TextView>(R.id.txt_title)
        mToolBarTitle.setText(title)

    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(R.layout.activity_base)
        container?.addView(LayoutInflater.from(this).inflate(layoutResID, null))
        ButterKnife.bind(this)
        setFullScreenLoader()

    }

    fun setFullScreenLoader() {
        mProgressDialog = ProgressDialog(this)
        mProgressDialog?.setCancelable(false)
    }

    fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun isThereInternetConnection(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        return cm!!.activeNetworkInfo != null
    }


}