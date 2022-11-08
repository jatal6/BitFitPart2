package com.example.bitfitpart2
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class ItemEntity (
    @ColumnInfo val foodName : String,
    @ColumnInfo val foodCalories : String,
    @PrimaryKey(autoGenerate = true) val id : Long =0,
)
