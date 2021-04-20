package com.phro.initiativem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.phro.initiativem.databinding.ActivityMainBinding
import com.phro.initiativem.ui.character.DetailCharacterActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        view = mainBinding.root

        setContentView(view)

        onClickedOnAnotherActivity()
    }

    private fun onClickedOnAnotherActivity() {
        mainBinding.txtAnotherActivity.setOnClickListener {
            changeToDetailActivity()
        }
    }

    private fun changeToDetailActivity() {
        startActivity(
            Intent(
                this,
                DetailCharacterActivity::class.java
            )
        )
    }
}