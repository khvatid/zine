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

        profile = repository.profile
    }

    fun updateProfile(profile: ProfileEntity){
        repository.updateProfile(profile = profile)
    }

    fun resetProfile(){
        repository.deleteProfile(profile.value!!.fullName)
        repository.createProfile(ProfileEntity(fullName = "User Admin",null))
    }

    fun createProfile(){
        repository.createProfile(ProfileEntity(fullName = "User Admin", null))
    }

}