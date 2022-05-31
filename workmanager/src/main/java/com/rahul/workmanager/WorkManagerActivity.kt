package com.rahul.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.work.*


class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val data = Data.Builder()
            .putString(Constants.USER_ID, "1432")
            .build()
        val request = OneTimeWorkRequestBuilder<YourWorkerClass>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance(this).enqueue(request)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id)
            .observe(this as LifecycleOwner, { it ->
                val status: String = it.state.name

                Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
                Log.d("TAG", "$status ${it.outputData.getString(Constants.USER_ID)}")
            })

    }
}