package io.navendra.livewordroom.view

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.navendra.livewordroom.R
import io.navendra.livewordroom.viewmodel.WordViewModel

import kotlinx.android.synthetic.main.activity_main.*
import io.navendra.livewordroom.model.Word
import io.navendra.livewordroom.view.adapters.WordListAdapter
import android.widget.Toast
import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    //region VARIABLES
    private val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    private lateinit var mWordViewModel: WordViewModel
    private lateinit var viewAdapter: WordListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initRecycler()

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        mWordViewModel.getAllWords().observe(this, Observer {
            if(it!=null){
                viewAdapter.mWords = it
                viewAdapter.notifyDataSetChanged()

            }
        })

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
    }

    private fun initRecycler(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = WordListAdapter(this)
        recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(this@MainActivity,LinearLayoutManager.VERTICAL))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY))
            mWordViewModel.insert(word)
        } else {
            Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
            ).show()
        }
    }
}
