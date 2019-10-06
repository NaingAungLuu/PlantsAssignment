package com.androboy.plants.persistence.daos

import androidx.room.*
import com.androboy.plants.data.vos.LoggedInUserVO
import com.androboy.plants.data.vos.PlantVO

@Dao
abstract class LoginUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user : LoggedInUserVO)

    @Query("SELECT * FROM login")
    abstract fun getLoggedInUser(): List<LoggedInUserVO>

    @Query("DELETE FROM login WHERE user_id = :userID ")
    abstract fun deleteLoggedInUser(userID : String) : Int

    fun isDatabaseEmpty():Boolean
    {
        return getLoggedInUser().isEmpty()
    }
}