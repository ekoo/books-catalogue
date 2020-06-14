package com.ekoo.bookapps.ui.booksByWriterActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ekoo.bookapps.R
import com.ekoo.bookapps.model.WriterDetailResponseModel
import com.ekoo.bookapps.utils.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_books_by_writer.*

class BooksByWriterActivity : AppCompatActivity() {

    private val viewModel: BooksByWriterViewModel by lazy {
        ViewModelProvider(this)[BooksByWriterViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_by_writer)
        setSupportActionBar(books_by_writer_toolbar)
        books_by_writer_toolbar.setTitleTextColor(android.graphics.Color.WHITE)

        intent.getIntExtra("writerId", 0).let {writerId ->
            viewModel.getBooksByWriter(writerId)
            books_by_writer_retry_button.setOnClickListener {
                initPicture()
                viewModel.getBooksByWriter(writerId)
            }
        }

        initPicture()
        viewModel.fetchState.observe(this, Observer { state->

            books_by_writer_progressBar.visibleWhen(state is Loading)
            books_by_writer_error_msg_textView.visibleWhen(state is Error)
            books_by_writer_retry_button.visibleWhen(state is Error)

            if (state is Success){
                val result = state.response as WriterDetailResponseModel
                books_by_writer_name_textView.text = result.result.name
                books_by_writer_email_textView.text = result.result.email
            }

            if (state is Error){
                books_by_writer_error_msg_textView.text = state.exception.localizedMessage
            }
        })
    }

    private fun initPicture() {
        intent.getStringExtra("writerPhoto")?.let {
            Picasso.get().load(it.fixImageUrl()).into(books_by_writer_imageView)
        }
    }
}