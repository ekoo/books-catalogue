package com.ekoo.bookapps.ui.latestBooksFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.ekoo.bookapps.R
import com.ekoo.bookapps.adapter.LatestBookAdapter
import com.ekoo.bookapps.model.LatestBookResponseModel
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import com.ekoo.bookapps.utils.visibleWhen
import kotlinx.android.synthetic.main.fragment_latest_books.*

class LatestBooksFragment : Fragment() {

    companion object {
        fun newInstance() = LatestBooksFragment()
    }

    private lateinit var viewModel: LatestBooksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_latest_books, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LatestBooksViewModel::class.java)
        viewModel.latestBook.observe(viewLifecycleOwner, Observer { state ->
            latest_books_progressBar.visibleWhen(state is Loading)
            latest_books_error_msg_textView.visibleWhen(state is Error)
            latest_books_retry_button.visibleWhen(state is Error)

            if (state is Success){
                val response = state.response as LatestBookResponseModel
                latest_books_recyclerView.adapter = LatestBookAdapter(response.latestBookList)
            }

            if (state is Error){
                latest_books_error_msg_textView.text = state.exception.localizedMessage
            }
        })


        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        latest_books_recyclerView.addItemDecoration(dividerItemDecoration)
        latest_books_retry_button.setOnClickListener {
            viewModel.getLatestBooks()
        }
    }
}