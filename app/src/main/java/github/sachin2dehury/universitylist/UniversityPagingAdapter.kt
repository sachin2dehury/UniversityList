package github.sachin2dehury.universitylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import github.sachin2dehury.universitylist.databinding.RvItemBinding

class UniversityPagingAdapter :
    PagingDataAdapter<UniversityResponseItem, UniversityViewHolder>(UniversityDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context))
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val binding = RvItemBinding.bind(holder.itemView)
        val item = getItem(position)

        with(binding) {
            text.text = item?.name
        }
    }
}
