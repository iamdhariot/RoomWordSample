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

package iamdhariot.github.roomwordsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {

    private lateinit var editTextWord: EditText

    companion object{
        const val EXTRA_REPLY = "iamdhariot.github.roomwordsample.NewWordActivity.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editTextWord = findViewById(R.id.edit_text_word)
        val buttonSave = findViewById<Button>(R.id.button_save)
        buttonSave.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(editTextWord.text)){
                setResult(RESULT_CANCELED, replyIntent)
            }else{
                val word = editTextWord.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(RESULT_OK, replyIntent)
            }
            finish()
        }

    }
}