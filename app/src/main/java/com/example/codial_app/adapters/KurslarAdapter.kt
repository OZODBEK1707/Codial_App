package com.example.codial_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codial_app.Models.Kurslar
import com.example.codial_app.databinding.ItemRvlarBinding

class KurslarAdapter(var list: List<Kurslar>, var rvClick: RvClick) : RecyclerView.Adapter<KurslarAdapter.Vh>() {
    inner class Vh(var itemrv: ItemRvlarBinding) : RecyclerView.ViewHolder(itemrv.root){
        fun onBind(kurslar: Kurslar, position: Int) {
            itemrv.nameItem.text = kurslar.nomi
            itemrv.card.setOnClickListener{
                rvClick.kurslarRvClick(kurslar,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvlarBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    interface RvClick{
        fun kurslarRvClick(kurslar: Kurslar, position: Int)
    }
}