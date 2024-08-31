package com.example.walmarttakehome.ui

import android.content.Intent
import android.os.Bundle

import androidx.activity.ComponentActivity

import com.example.feature_domain.repository.FeatureRepo
import com.example.feature_ui.view.FeatureActivity
import com.example.walmarttakehome.R

import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repo: FeatureRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        startActivity(Intent(this@MainActivity, FeatureActivity::class.java))
    }
}