package com.to_panelka.zine.database.repository

import androidx.lifecycle.LiveData
import com.to_panelka.zine.database.dao.ProfileDao
import com.to_panelka.zine.database.entities.ProfileEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ProfileRepository(private val profileDao: ProfileDao) {
    private val coroutineScope : CoroutineScope = CoroutineScope(Dispatchers.Main)

    val profile : LiveData<ProfileEntity> = profileDao.getProfile()


    fun createProfile (profile : ProfileEntity){
        coroutineScope.launch(Dispatchers.IO){
            profileDao.insertProfile(profile = profile)
        }
    }

    fun updateProfile (profile: ProfileEntity){
        coroutineScope.launch(Dispatchers.IO){
            profileDao.updateProfile(profile = profile)
        }
    }

    fun deleteProfile (id: Int){
        coroutineScope.launch(Dispatchers.IO){
            profileDao.deleteProfile(id = id)
        }
    }

}