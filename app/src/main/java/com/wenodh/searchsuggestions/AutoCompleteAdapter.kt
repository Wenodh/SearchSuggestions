package com.wenodh.searchsuggestions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import androidx.annotation.LayoutRes
import kotlinx.android.synthetic.main.item_auto_complete_text_view.view.*

class AutoCompleteAdapter(
    private val c: Context,
    @LayoutRes private val layoutResource: Int,
    private val movies: List<String>
) :
    ArrayAdapter<String>(c, layoutResource, movies) {

    var filteredMovies: List<String> = listOf()

    override fun getCount(): Int = filteredMovies.size

    override fun getItem(position: Int): String = filteredMovies[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(c).inflate(layoutResource, parent, false)
        view.tvSearch.text = filteredMovies[position]
        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
                filteredMovies = filterResults.values as List<String>
                notifyDataSetChanged()
            }

            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val queryString = charSequence?.toString()?.toLowerCase()

                val filterResults = FilterResults()
                filterResults.values = if (queryString == null || queryString.isEmpty())
                    movies
                else
                    movies.filter {
                        it.toLowerCase().contains(queryString)
                    }
                return filterResults
            }
        }
    }
}