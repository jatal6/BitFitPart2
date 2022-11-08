package com.example.bitfitpart2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface ItemDao {
    @Query("SELECT * FROM food_table")
    fun getAll(): Flow<List<ItemEntity>>

    @Insert
    fun insertAll(foods: List<ItemEntity>)

    @Insert
    fun insert(food: ItemEntity)


    @Query("SELECT avg(foodCalories) FROM food_table")
    fun totalCalories() : String



    @Query("DELETE FROM food_table")
    fun deleteAll()
}