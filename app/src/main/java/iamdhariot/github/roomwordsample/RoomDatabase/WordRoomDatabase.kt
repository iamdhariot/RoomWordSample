/*
 *  Copyright 2020 iamdhariot. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package iamdhariot.github.roomwordsample.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import iamdhariot.github.roomwordsample.Dao.WordDao
import iamdhariot.github.roomwordsample.Model.Word

/**
 * Room Database
 * Room is a database layer on top of an SQLite database.
 * Room takes care of mundane tasks that you used to handle with an SQLiteOpenHelper.
 * Room uses the DAO to issue database queries to its database.
 * By default, to avoid the poor UI performance issues, room doesn't allow you to issues queries on the main thread.
 * When room queries return LiveData, the queries are automatically run asynchronously on the background thread.
 * Your room database class must be abstract and extend RoomDatabase.
 * Usually, you only need one instance of a Room database for the whole app.
 *
 * */
// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [Word::class], version = 1, exportSchema = false)
public abstract class WordRoomDatabase: RoomDatabase() {
    abstract fun wordDao():WordDao
    companion object{
        // Singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}