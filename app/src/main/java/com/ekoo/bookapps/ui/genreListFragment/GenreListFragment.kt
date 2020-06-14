package com.ekoo.bookapps.ui.genreListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.ekoo.bookapps.R
import com.ekoo.bookapps.adapter.GenreAdapter
import com.ekoo.bookapps.model.GenreResponseModel
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import com.ekoo.bookapps.utils.visibleWhen
import kotlinx.android.synthetic.main.fragment_genre_list.*

class GenreListFragment : Fragment() {

    companion object {
        fun newInstance() = GenreListFragment()
    }

    private lateinit var viewModel: GenreListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_genre_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GenreListViewModel::class.java)
        viewModel.allGenre.observe(viewLifecycleOwner, Observer { state ->
            genre_list_progressBar.visibleWhen(state is Loading)
            genre_list_error_msg_textView.visibleWhen(state is Error)
            genre_list_retry_button.visibleWhen(state is Error)

            if (state is Success){
                val response = state.response as GenreResponseModel
                genre_list_recyclerView.adapter = GenreAdapter(response.genreList)
            }

            if (state is Error){
                genre_list_error_msg_textView.text = state.exception.localizedMessage
            }
        })

        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        genre_list_recyclerView.addItemDecoration(dividerItemDecoration)
        genre_list_retry_button.setOnClickListener {
            viewModel.getAllGenre()
        }
    }
}