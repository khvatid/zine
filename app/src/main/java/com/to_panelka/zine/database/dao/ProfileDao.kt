package com.to_panelka.zine.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.to_panelka.zine.database.entities.ProfileEntity


@Dao
interface ProfileDao {

    @Insert
    fun insertProfile(profile: ProfileEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profile")
    fun getProfile(): LiveData<ProfileEntity>

    @Query("DELETE FROM profile WHERE id = :id")
    fun deleteProfile(id:Int)



}