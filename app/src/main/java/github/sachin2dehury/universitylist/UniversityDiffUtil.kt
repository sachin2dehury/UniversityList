package github.sachin2dehury.universitylist

import androidx.recyclerview.widget.DiffUtil

class UniversityDiffUtil : DiffUtil.ItemCallback<UniversityResponseItem>() {
    override fun areItemsTheSame(
        oldItem: UniversityResponseItem,
        newItem: UniversityResponseItem,
    ): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(
        oldItem: UniversityResponseItem,
        newItem: UniversityResponseItem,
    ): Boolean {
        return oldItem == newItem
    }
}
