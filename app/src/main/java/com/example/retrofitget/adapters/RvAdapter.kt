package com.example.retrofitget.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitget.databinding.ItemRvBinding
import com.example.retrofitget.models.MyTodo

class RvAdapter(var list: List<MyTodo> = ArrayList()): RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh (val itemRvBinding: ItemRvBinding): RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(myTodo: MyTodo){
            itemRvBinding.apply {
                itemRvBinding.tvId.text = myTodo.id.toString()
                itemRvBinding.tvName.text =myTodo.sarlavha
                itemRvBinding.tvIzoh.text =myTodo.izoh
                itemRvBinding.tvSana.text =myTodo.sana
                itemRvBinding.tvSarlavha.text = if (myTodo.bajarildi)"Bajarildi" else "Endi bajariladi"

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvAdapter.Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
