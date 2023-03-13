package com.ramil.http.service

import android.app.job.JobParameters
import android.app.job.JobService

class JobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }

}