package com.example.facebooklayout.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Friend::class], version = 1)
abstract class FriendDatabase: RoomDatabase(){
    abstract fun getFriendDAO() : FriendDAO

    companion object{
        @Volatile
        private var instance: FriendDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                FriendDatabase::class.java,
                "friend_db"
            ).build()

    }
}
