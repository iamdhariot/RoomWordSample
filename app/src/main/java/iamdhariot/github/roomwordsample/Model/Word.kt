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

package iamdhariot.github.roomwordsample.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Room allows you to create tables via an Entity.
 * @see Word data class
 * Word class describe the Entity that represent the SQLite table for your words.
 * Room will use these properties to both create the table and instantiate objects from rows in the database.
 *
 * @Entity: Entity class represent a SQLite table. here word_table is table name.
 *
 * @PrimaryKey: word is a primary key every entity needs it. here, each words represent a primary key.
 *
 * @ColumnInfo: Specifies the name of the column in the table if you want it to be different from the name
 * of the member variable. This names the column "word".
 *
 * Every property that's stored in the database needs to have public visibility. (Kotlin by default)
 *
 * In case you want to  auto generate PrimaryKey:
 * @PrimaryKey(autoGenerate = true) val id: Int
 * */
@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)