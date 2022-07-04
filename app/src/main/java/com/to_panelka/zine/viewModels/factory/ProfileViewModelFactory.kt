package com.to_panelka.zine.viewModels.factory

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.to_panelka.zine.viewModels.ProfileViewModel

class ProfileViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.i("VIEW MODEL:","Create ScheduleViewModel")
        return ProfileViewModel(application) as T
    }
}