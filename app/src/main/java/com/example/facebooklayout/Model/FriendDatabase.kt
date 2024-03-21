package com.example.facebooklayout.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Friend::class], version = 4)
abstract class FriendDatabase: RoomDatabase(){
    abstract fun friendDAO() : FriendDAO


    companion object {
        @Volatile
        private var INSTANCE: FriendDatabase? = null
        fun getInstance(context: Context): FriendDatabase {
            synchronized(this) {
                var instance = INSTANCE
                val MIGRATION_1_4 = object : Migration(1, 4) {
                    override fun migrate(database: SupportSQLiteDatabase) {
                        // Perform the necessary schema changes to migrate from version 1 to version 3
                        // Add a new table
                        database.execSQL("CREATE TABLE IF NOT EXISTS new_table(id INTEGER PRIMARY KEY, name TEXT)")

                        // Rename the column from friendname to friendName
                        database.execSQL("ALTER TABLE friends_table RENAME COLUMN friendname TO friendName")

//                        // Modify an existing table
//                        database.execSQL("ALTER TABLE existing_table ADD COLUMN new_column TEXT")

                    }
                }
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FriendDatabase::
                        class.java,
                        "friends_db"
                    ).addMigrations(MIGRATION_1_4) // Provide the migration path from version 1 to version 3
                    .fallbackToDestructiveMigration()
                    .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}
