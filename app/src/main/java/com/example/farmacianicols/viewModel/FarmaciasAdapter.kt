package com.example.farmacianicols.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.farmacianicols.R
import com.example.farmacianicols.local.FarmaciasUsadas
import kotlinx.android.synthetic.main.farma_list_view.view.*

class FarmaciasAdapter(val mPassTheData: PassTheData): RecyclerView.Adapter<FarmaciasAdapter.FarmaciasViewHolder>() {
    private var farmainList = emptyList<FarmaciasUsadas>()

    fun updateAdapter(mList: List<FarmaciasUsadas>) {
        farmainList = mList
        notifyDataSetChanged()
    }

    inner class FarmaciasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
     val NombreSucursal = itemView.textView1
        val UbicacionSucursal = itemView.textView2
        val clickListener = itemView.setOnClickListener {
            mPassTheData.passTheFarmacias(farmainList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): FarmaciasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.farma_list_view, parent,
        false)
        return FarmaciasViewHolder(view)
    }


    override fun getItemCount() = farmainList.size

    interface PassTheData {
        fun passTheFarmacias(farmacias : FarmaciasUsadas )
    }

    override fun onBindViewHolder(holder: FarmaciasViewHolder, position: Int) {
        val farmacias = farmainList[position]
        Glide.with(holder.itemView.context).load(farmacias.id)
        holder.UbicacionSucursal.text = farmacias.LocalDirecion
        holder.NombreSucursal.text = farmacias.comunaNombre
    }


}