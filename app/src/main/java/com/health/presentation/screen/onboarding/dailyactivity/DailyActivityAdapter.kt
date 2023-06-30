package com.health.presentation.screen.onboarding.dailyactivity

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.health.R
import com.health.databinding.ItemDailyActivityBinding
import com.health.extension.inflate

class DailyActivityAdapter(
    private val onItemClick: (Int) -> Unit
) :
    ListAdapter<DailyActivityModel, BestFilmsActorViewHolder>(BestFilmsActorDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestFilmsActorViewHolder =
        BestFilmsActorViewHolder(ItemDailyActivityBinding.bind(parent.inflate(R.layout.item_daily_activity)))

    override fun onBindViewHolder(holder: BestFilmsActorViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClick)
}

class BestFilmsActorViewHolder(private val binding: ItemDailyActivityBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        dailyActivityModel: DailyActivityModel,
        onItemClick: (Int) -> Unit,
    ) {
        with(binding) {
            ivIconActivity.setImageResource(dailyActivityModel.iconActivity)
            tvAmountCalories.text = dailyActivityModel.amountCalories.toString()
            tvDescription.text = itemView.context.getString(dailyActivityModel.description)
            if (dailyActivityModel.isSelected) {
                root.setBackgroundResource(R.drawable.blue_bg)
            } else {
                root.setBackgroundColor(Color.TRANSPARENT)
            }
            root.setOnClickListener {
                onItemClick(dailyActivityModel.id)
            }
        }
    }
}

private class BestFilmsActorDiffUtil : DiffUtil.ItemCallback<DailyActivityModel>() {

    override fun areItemsTheSame(oldItem: DailyActivityModel, newItem: DailyActivityModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DailyActivityModel, newItem: DailyActivityModel): Boolean =
        oldItem == newItem
}
