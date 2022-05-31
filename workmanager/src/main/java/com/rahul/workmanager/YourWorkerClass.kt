package com.rahul.workmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class YourWorkerClass(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val userId = inputData.getString(Constants.USER_ID)
        val data = Data.Builder().putString(Constants.USER_ID, userId).build()
        return Result.success(data)
    }
    }