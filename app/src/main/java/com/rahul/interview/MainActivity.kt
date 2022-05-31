package com.rahul.interview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import com.rahul.handleractivity.HandlerActivity

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   fun onHandler (){
//       val intent = Intent(this, HandlerActivity::class.java)
//       startActivity(intent)
   }
}