package com.rathiesh.countrydetail.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rathiesh.countrydetail.data.storage.entity.CountryEntity

@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetAllValue(countryList: List<CountryEntity>)

    @Query("SELECT * FROM CountryEntity")
    fun getValue(): List<CountryEntity>
}