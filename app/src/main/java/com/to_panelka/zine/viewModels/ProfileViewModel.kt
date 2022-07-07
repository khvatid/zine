package com.to_panelka.zine.viewModels

import android.app.Application
import android.util.Log
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

    fun updateProfile(profileUp: ProfileEntity){
        repository.updateProfile(profile = profileUp)
        Log.i("UPDATE PROFILE  :",profileUp.toString())
    }

    fun resetProfile(){
        repository.deleteProfile(profile.value!!.id)
        repository.createProfile(ProfileEntity())
    }

    fun createProfile(){
        repository.createProfile(ProfileEntity())
    }


}