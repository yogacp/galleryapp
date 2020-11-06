package app.isfaaghyth.starter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.isfaaghyth.starter.databinding.ItemListSimpleBinding
import com.utsman.abstraction.extensions.inflate
import com.utsman.abstraction.extensions.loadUrl
import com.utsman.data.model.Photo

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemListSimpleBinding.bind(view)

        fun bind(photo: Photo) = binding.run {
            imgItem.loadUrl(url = photo.urls.small, id = photo.id)
        }
    }

    private val list: MutableList<Photo> = mutableListOf()

    fun addList(list: List<Photo>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = parent inflate R.layout.item_list_simple
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}