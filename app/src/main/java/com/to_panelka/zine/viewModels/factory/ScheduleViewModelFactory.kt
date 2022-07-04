package com.to_panelka.zine.viewModels.factory

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.to_panelka.zine.viewModels.ScheduleViewModel

class ScheduleViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.i("VIEW MODEL:","Create ScheduleViewModel")
        return ScheduleViewModel(application) as T
    }
}