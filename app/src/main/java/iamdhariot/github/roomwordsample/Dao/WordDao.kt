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

package iamdhariot.github.roomwordsample.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import iamdhariot.github.roomwordsample.Model.Word


/**
 * DAO (Data access object)
 * you specify SQL queries and associate them with method calls. The compiler checks the SQL and
 * generates queries from convenience annotations for common queries, such as @Insert.
 * Room uses the DAO to create a clean API for your code.
 * DAO must be an interface or an abstract class.
 * By default all the queries must be executed on a separate thread.
 * Room has coroutines support, allowing your queries to be annotated with the suspend modifier and
 * then called from a coroutine or from another suspension function.
 *
 *
 * @see WordDao
 *
 * @Dao:  represent a DAO class for room.
 *
 * suspend fun insert(word: Word): Declares a suspend function to insert one word.
 *
 * @Insert: The @Insert annotation is a special DAO method annotation where you don't have to provide
 * any SQL.(There are also @Delete and @Update annotations for deleting and updating row).
 *
 * onConflict = OnConflictStrategy.IGNORE: The selected onConflict strategy ignores a new word if
 * it's exactly the same as one already in the list.
 *
 * suspend fun deleteAll(): Declares a suspend function to delete all the words.
 *
 * @Query("DELETE FROM word_table"): @Query requires that you provide a SQL query as a string parameter to the annotation,
 * allowing for complex read queries and other operations.
 *
 * LiveData :a lifecycle library class for data observation.
 * @see LiveData When data changes you usually want to take some action, such as displaying the updated data in the UI.
 * This means you have to observe the data so that when it changes, you can react.
 *
 * Use a return value of type LiveData in your method description, and Room generates all necessary code to update
 * the LiveData when the database is updated.
 * */

@Dao
interface WordDao{
    @Query("SELECT * FROM word_table ORDER BY word ASC") //Query that returns a list of words sorted in ascending order.
    fun getAlphabetizedWords(): LiveData<List<Word>> // getting live data

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()


}