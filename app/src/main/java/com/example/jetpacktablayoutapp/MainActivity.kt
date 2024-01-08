package com.example.jetpacktablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.jetpacktablayoutapp.ViewPagerAdapter
import androidx.viewpager2.widget.ViewPager2 // Ensure you import ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        adapter = ViewPagerAdapter(this)
        adapter.addFragment(AFragment().apply { arguments = createBundleWithUserName("Sandeep") }, "First")
        adapter.addFragment(BFragment().apply { arguments = createBundleWithUserName("Kudugi") }, "Second")
        adapter.addFragment(CFragment().apply { arguments = createBundleWithUserName("Savitha") }, "Third")

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }

    private fun createBundleWithUserName(userName: String): Bundle {
        return Bundle().apply {
            putString("USER_NAME", userName)
        }
    }
}


