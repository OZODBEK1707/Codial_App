package com.example.codial_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codial_app.Models.Mentor
import com.example.codial_app.databinding.ItemRvMentorsBinding

class MentorlarRoyhatiAdapter(var list: List<Mentor>, var rvClick: RvClick) : RecyclerView.Adapter<MentorlarRoyhatiAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvMentorsBinding) : RecyclerView.ViewHolder(itemRv.root){
        fun onBind(mentor : Mentor, position: Int) {
            itemRv.txtGuruhName.text = "${mentor.ismi}\n${mentor.familiya}"
            itemRv.parentFragment.setOnClickListener {
                rvClick.itemClickListener(mentor,position)
            }
            itemRv.deleteParent.setOnClickListener {
                rvClick.deleteClickListener(mentor)
            }
            itemRv.editParent.setOnClickListener {
                rvClick.editClickListener(mentor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvMentorsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position] , position)
    }

    override fun getItemCount(): Int = list.size

    interface RvClick{
        fun itemClickListener(mentor: Mentor, position: Int)
        fun deleteClickListener(mentor: Mentor)
        fun editClickListener(mentor: Mentor)
    }
}