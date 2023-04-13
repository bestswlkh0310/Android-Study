package com.example.bottomnavwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bottomnavwithfragment.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment

    companion object {
        const val TAG: String = "로그"
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "MainActivity - onCreate() called")
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    Log.d(TAG, "MainActivity - 홈")
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
                }
                R.id.menu_ranking -> {
                    Log.d(TAG, "MainActivity - 랭킹")
                    rankingFragment = RankingFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()
                }
                R.id.menu_profile -> {
                    Log.d(TAG, "MainActivity - 프로필")
                    profileFragment = ProfileFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
                }
            }
            true
        }

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()
    }
}