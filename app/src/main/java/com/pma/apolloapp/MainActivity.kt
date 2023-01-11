package com.pma.apolloapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pma.apolloapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var txtView: TextView

    private lateinit var binding: ActivityMainBinding


    //this is how fragments are changed
    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)

        fragmentTransaction.commit()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getSupportActionBar()?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> replaceFragment(HomeFragment())

                R.id.profile -> replaceFragment(InfoFragment())

                R.id.logout -> {
                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                }

                else ->{}
            }
            true

        }
    }
}