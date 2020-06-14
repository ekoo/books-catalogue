package com.ekoo.bookapps.ui.bookDetailActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ekoo.bookapps.R
import com.ekoo.bookapps.model.BookDetailResponseModel
import com.ekoo.bookapps.ui.booksByWriterActivity.BooksByWriterActivity
import com.ekoo.bookapps.utils.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_book_detail.*
import org.jetbrains.anko.startActivity

class BookDetailActivity : AppCompatActivity() {

    private val viewModel: BookDetailViewModel by lazy {
        ViewModelProvider(this)[BookDetailViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        setSupportActionBar(book_detail_toolbar)
        book_detail_toolbar.setTitleTextColor(android.graphics.Color.WHITE)

        intent.getStringExtra("bookId")?.let {bookId ->
            viewModel.getBookById(bookId)
            book_detail_retry_button.setOnClickListener {
                viewModel.getBookById(bookId)
            }
        }

        viewModel.bookDetail.observe(this, Observer { state ->
            book_detail_progressBar.visibleWhen(state is Loading)
            book_detail_error_msg_textView.visibleWhen(state is Error)
            book_detail_retry_button.visibleWhen(state is Error)
            book_detail_writer_button.visibleWhen(state is Success)
            writer.visibleWhen(state is Success)
            synopsis.visibleWhen(state is Success)

            if (state is Success){
                val response = state.response as BookDetailResponseModel
                response.result.let {bookDetail ->
                    supportActionBar?.title = bookDetail.title
                    Picasso.get().load(bookDetail.coverUrl.fixImageUrl()).into(book_detail_imageView)
                    book_detail_writer_textView.text = bookDetail.writerByWriterId.userByUserId.name
                    book_detail_synopsis_textView.text = bookDetail.synopsis.fromHtml()
                    book_detail_writer_button.setOnClickListener {
                        startActivity<BooksByWriterActivity>(
                            "writerId" to bookDetail.writerByWriterId.userByUserId.id,
                            "writerPhoto" to bookDetail.writerByWriterId.userByUserId.photoUrl
                        )
                    }
                }
            }

            if (state is Error){
                book_detail_error_msg_textView.text = state.exception.localizedMessage
            }
        })
    }
}