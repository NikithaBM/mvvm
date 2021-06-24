package com.nikitha.nblik.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.nikitha.nblik.R
import com.rd.PageIndicatorView
import com.rd.animation.type.AnimationType

class OnBoardingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        supportActionBar?.hide()

        val viewPagerAdapter = ViewPageAdapter(this)
        val viewPager = findViewById<ViewPager>(R.id.viewPager_startup)
        viewPager.adapter = viewPagerAdapter

        val btnFinish = findViewById<Button>(R.id.tvFinish)
        val btnSkip = findViewById<Button>(R.id.tvSkip)

        val pageIndicatorView = findViewById<PageIndicatorView>(R.id.pageIndicatorView)
        pageIndicatorView.count = 4
        pageIndicatorView.setAnimationType(AnimationType.THIN_WORM)


        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                pageIndicatorView.selection = position
                if (position == 0 || position == 1 || position == 2) {
                    btnSkip.visibility = View.VISIBLE
                    btnFinish.visibility = View.INVISIBLE
                } else if (position == 3) {
                    btnSkip.visibility = View.INVISIBLE
                    btnFinish.visibility = View.VISIBLE
                }

            }
            override fun onPageSelected(position: Int) {

            }

        })

        //Check for new installer
       // isFirstTime()

        btnSkip.setOnClickListener { view: View? ->
            startActivity(Intent(this@OnBoardingActivity, LogInSignUpActivity::class.java))
            finish()
            val preferences =
                getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("FirstTimeInstall", "No")
            editor.apply()
        }

        btnFinish.setOnClickListener {
            startActivity(Intent(this@OnBoardingActivity, LogInSignUpActivity::class.java))
            finish()
            val preferences =
                getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("FirstTimeInstall", "No")
            editor.apply()
        }

    }
    private fun isFirstTime() {
        val preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
        val FirstTime = preferences.getString("FirstTimeInstall", "")
        if (FirstTime == "No") {
            startActivity(Intent(applicationContext, LogInSignUpActivity::class.java))
            finish()
        }
    }

    private class ViewPageAdapter(context: Context): PagerAdapter() {

        var context = context
        var resources = intArrayOf(
            R.drawable.onboarding,
            R.drawable.onboarding,
            R.drawable.onboarding,
            R.drawable.onboarding
        )
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view: View

            view =  LayoutInflater.from(context).inflate(R.layout.startup_view_pager_final_item, null)
            container.addView(view)
            val imageView = view.findViewById<ImageView>(R.id.iv_startup)
            imageView.setImageResource(resources.get(position))
            return view
        }

        override fun getCount(): Int {
            return resources.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
            collection.removeView(view as View)
        }

    }
}
