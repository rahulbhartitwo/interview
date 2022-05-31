package com.rahul.handleractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.rahul.handleractivity.databinding.ActivityHandlerBinding
import kotlinx.coroutines.delay

class HandlerActivity : AppCompatActivity() {
    private var i = 0
   lateinit var binding : ActivityHandlerBinding
   lateinit var myB : Bundle
   lateinit var mHandler : Handler
  lateinit var t : Thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_handler)

        mHandler = object :  Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                myB = msg.data
                val str = myB.getInt("key")
                binding.tvCount.text = str.toString()
                println(str)
            }
        }

        binding.click.setOnClickListener {
            t = Thread(MyRunnable(mHandler))
            t.start()
            Log.e("TAG", "${t.name}")
        }
    }
}

 class MyRunnable() : Runnable {
     private lateinit var h2 : Handler

     constructor(mHandler: Handler) : this() {
         h2 = mHandler
     }

     override fun run() {
         for(i in 0..1000) {
             Thread.sleep(50)
             var message = Message.obtain()
             var b = Bundle()
             b.putInt("key", i)
             message.data = b
             h2.sendMessage(message)
         }
     }
 }