package io.navendra.livewordroom.view.adapters

import io.navendra.livewordroom.model.Word
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import io.navendra.livewordroom.R
import android.content.Context

class WordListAdapter (context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    //region VARIABLES
    private val mInflater: LayoutInflater
    var mWords: List<Word>? = null // Cached copy of words
    //endregion

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView

        init {
            wordItemView = itemView.findViewById(R.id.textView)
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (mWords != null) {
            val current = mWords!![position]
            holder.wordItemView.text = current.mWord
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.text = "No Word"
        }
    }

    /**
     * getItemCount() is called many times, and when it is first called,
     * mWords has not been updated (means initially, it's null, and we can't return null).
     */
    override fun getItemCount(): Int {
        return if (mWords != null)
            mWords!!.size
        else
            0
    }
}