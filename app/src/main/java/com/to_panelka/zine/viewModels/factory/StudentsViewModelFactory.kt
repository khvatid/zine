package com.to_panelka.zine.viewModels.factory

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.to_panelka.zine.viewModels.StudentsViewModel

class StudentsViewModelFactory(val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.i("VIEW MODEL:","Create StudentViewModel")
        return StudentsViewModel(application) as T
    }
}