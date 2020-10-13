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

package iamdhariot.github.roomwordsample.Repository

import androidx.lifecycle.LiveData
import iamdhariot.github.roomwordsample.Dao.WordDao
import iamdhariot.github.roomwordsample.Model.Word

/**
 * Repository
 * A repository class abstracts access to multiple data sources.
 * The repository is not part of the Architecture Components libraries, but is a suggested best practice
 * for code separation and architecture.
 * A Repository class provides a clean API for data access to the rest of the application.
 * A Repository manages queries and allows you to use multiple backends.
 * In the most common example, the Repository implements the logic for deciding whether
 * to fetch data from a network or use results cached in a local database.
 *
 * */
// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val wordDao: WordDao){
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }


}

