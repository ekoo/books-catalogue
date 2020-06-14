package com.ekoo.bookapps.ui.booksByGenreActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.ekoo.bookapps.R
import com.ekoo.bookapps.adapter.BooksByGenreAdapter
import com.ekoo.bookapps.model.BookListByGenreResponseModel
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import com.ekoo.bookapps.utils.visibleWhen
import kotlinx.android.synthetic.main.activity_books_by_genre.*

class BooksByGenreActivity : AppCompatActivity() {

    private val viewModel: BooksByGenreViewModel by lazy {
        ViewModelProvider(this)[BooksByGenreViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_by_genre)
        setSupportActionBar(books_by_genre_toolbar)
        books_by_genre_toolbar.setTitleTextColor(android.graphics.Color.WHITE)

        intent.getStringExtra("genreId")?.let { genreId->
            viewModel.getBooksByGenre(genreId)
            books_by_genre_retry_button.setOnClickListener {
                viewModel.getBooksByGenre(genreId)
            }
        }

        viewModel.fetchState.observe(this, Observer { state->
            books_by_genre_progressBar.visibleWhen(state is Loading)
            books_by_genre_error_msg_textView.visibleWhen(state is Error)
            books_by_genre_retry_button.visibleWhen(state is Error)

            if (state is Success){
                val response = state.response as BookListByGenreResponseModel
                books_by_genre_recyclerView.adapter = BooksByGenreAdapter(response.bookList)
            }

            if (state is Error){
                books_by_genre_error_msg_textView.text = state.exception.localizedMessage
            }
        })


        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        books_by_genre_recyclerView.addItemDecoration(dividerItemDecoration)
        
    }
}