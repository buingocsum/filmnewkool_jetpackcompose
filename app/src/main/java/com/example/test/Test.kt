package com.example.test

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity

class Test : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("HAHAHA", "onCreate: " + sumab { test(1, 3) })
    }

    fun sumab(a: () -> Int): Int {
        return a.invoke()
    }


    fun test(a: Int, b: Int): Int {
        return a + b
    }
}