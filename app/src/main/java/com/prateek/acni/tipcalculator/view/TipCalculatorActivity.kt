package com.prateek.acni.tipcalculator

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.prateek.acni.tipcalculator.databinding.ActivityMainBinding
import com.prateek.acni.tipcalculator.viewmodel.CalculatorViewModel

import kotlinx.android.synthetic.main.activity_main.*

class TipCalculatorActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //associates and inflates the layout and returns binding,all in one shot
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        //this is to bind child content_layout with viewmodel
        binding.vm= CalculatorViewModel()

        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

/*
showAnswerButton?.setOnClickListener { /* */ }

This is equivalent to the following code in Java:

if (showAnswerButton != null) {
    showAnswerButton.setOnClickListener(/* */);
}



 */
