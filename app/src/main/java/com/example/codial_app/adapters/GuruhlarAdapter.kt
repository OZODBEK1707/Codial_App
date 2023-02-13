package com.example.codial_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codial_app.Models.Guruh
import com.example.codial_app.databinding.ItemGuruhlarMalumotBinding

class GuruhlarAdapter(var list: List<Guruh>,var rvClick: RvClick) : RecyclerView.Adapter<GuruhlarAdapter.Vh>() {
    inner class Vh(var itemRv: ItemGuruhlarMalumotBinding) : RecyclerView.ViewHolder(itemRv.root){
        fun onBind(guruh: Guruh, position: Int) {
            itemRv.txtGuruhName.text = guruh.nomi

            itemRv.korishParent.setOnClickListener {
                rvClick.showClick(guruh,position)
            }

            itemRv.editParent.setOnClickListener {
                rvClick.editClick(guruh,position)
            }

            itemRv.deleteParent.setOnClickListener {
                rvClick.deleteClick(guruh,position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemGuruhlarMalumotBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position] , position)
    }

    override fun getItemCount(): Int = list.size
}

interface RvClick{
    fun showClick(guruh: Guruh,position: Int)
    fun editClick(guruh: Guruh,position: Int)
    fun deleteClick(guruh: Guruh,position: Int)
}