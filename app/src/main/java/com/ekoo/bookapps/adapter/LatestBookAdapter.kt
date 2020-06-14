package com.ekoo.bookapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ekoo.bookapps.R
import com.ekoo.bookapps.model.LatestBookResponseModel
import com.ekoo.bookapps.ui.bookDetailActivity.BookDetailActivity
import com.ekoo.bookapps.utils.fixImageUrl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_latest_book.view.*
import org.jetbrains.anko.startActivity

class LatestBookAdapter(private val books: List<LatestBookResponseModel.LatestBooksModel>): RecyclerView.Adapter<LatestBookAdapter.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val title: TextView = view.latest_book_title_textView
        private val image: ImageView = view.latest_book_image_imageView
        private val writer: TextView = view.latest_book_writer
        private val release: TextView = view.latest_book_release
        private var book: LatestBookResponseModel.LatestBooksModel? = null

        init {
            view.setOnClickListener {
                book?.id?.let {
                    view.context.startActivity<BookDetailActivity>("bookId" to it.toString())
                }
            }
        }

        fun bind(book: LatestBookResponseModel.LatestBooksModel){
            Picasso.get().load(book.coverUrl.fixImageUrl()).into(image)
            title.text = book.title
            writer.text = book.writerByWriterId.userByUserId.name
            release.text = book.scheduleTask
            this.book = book
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_latest_book, parent, false))
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        books[position].let {
            holder.bind(it)
        }
    }
}