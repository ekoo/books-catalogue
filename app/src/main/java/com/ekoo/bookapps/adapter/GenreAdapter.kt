package com.ekoo.bookapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekoo.bookapps.R
import com.ekoo.bookapps.model.GenreResponseModel
import com.ekoo.bookapps.ui.booksByGenreActivity.BooksByGenreActivity
import kotlinx.android.synthetic.main.item_genre.view.*
import org.jetbrains.anko.startActivity

class GenreAdapter(private val genreList: List<GenreResponseModel.GenreModel>): RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val title = view.item_genre_title_textView
        private val count = view.total_textView
        private var genre: GenreResponseModel.GenreModel? = null

        init {
            view.setOnClickListener {
                genre?.id?.let {
                    view.context.startActivity<BooksByGenreActivity>("genreId" to it.toString())
                }
            }
        }

        fun bind( genre: GenreResponseModel.GenreModel){
            title.text = genre.title
            count.text = genre.count.toString()
            this.genre = genre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false))
    }

    override fun getItemCount(): Int = genreList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        genreList[position].let {
            holder.bind(it)
        }
    }
}