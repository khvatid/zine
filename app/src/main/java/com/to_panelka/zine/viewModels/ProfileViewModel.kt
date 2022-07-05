package com.to_panelka.zine.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.to_panelka.zine.database.ZineDatabase
import com.to_panelka.zine.database.entities.ProfileEntity
import com.to_panelka.zine.database.repository.ProfileRepository

class ProfileViewModel(application: Application): ViewModel() {
    private val repository: ProfileRepository

    val profile : LiveData<ProfileEntity>

    init {
        val zineDatabase = ZineDatabase.getInstance(application)
        val profileDao = zineDatabase.profileDao()
        repository = ProfileRepository(profileDao)
        if (repository.profile.value == null)
            repository.createProfile(ProfileEntity(fullName = "User Admin",null))
        profile = repository.profile
    }

    fun updateProfile(){
        repository.updateProfile(profile = profile.value!!)
    }

    fun resetProfile(){
        repository.deleteProfile(profile.value!!.fullName)
        repository.createProfile(ProfileEntity(fullName = "User Admin",null))
    }

}