package com.example.shop.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shop.DB.DAO.ProductDAO
import com.example.shop.DB.Entity.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun ProductDao(): ProductDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "shop.db").allowMainThreadQueries()
            .build()
    }
}