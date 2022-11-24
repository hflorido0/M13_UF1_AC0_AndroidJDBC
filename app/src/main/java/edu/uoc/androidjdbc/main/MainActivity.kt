package edu.uoc.androidjdbc.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uoc.androidjdbc.R
import edu.uoc.androidjdbc.controller.Controller

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var controller : Controller = Controller()
        controller.init()
    }
}