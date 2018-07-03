package io.navendra.livewordroom.view

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.navendra.livewordroom.R
import android.text.TextUtils
import android.content.Intent
import kotlinx.android.synthetic.main.activity_new_word.*


class NewWordActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "io.navendra.livewordroom.view.NewWordActivity.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        button_save?.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_word.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = edit_word.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }


}
