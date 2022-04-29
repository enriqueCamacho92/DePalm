package com.example.depalm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ClienteAdapter3(private val clienteList3:List<Cliente>) : RecyclerView.Adapter<ClienteViewHolder3>() {
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    private val db = FirebaseFirestore.getInstance()
    private var updateClienteList: MutableList<Cliente> = clienteList3 as MutableList<Cliente>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder3 {
        return ClienteViewHolder3(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cliente_item2,parent,false), mListener
        )
    }

    override fun onBindViewHolder(holder: ClienteViewHolder3, position: Int) {
        val currentItem = clienteList3[position]

        holder.iTvNombre.text = currentItem.nombre
        holder.iTvApodo.text = currentItem.apodo
        holder.iTvFiado.text = currentItem.fiado
        holder.iTvEnvases.text = currentItem.envases

    }

    override fun getItemCount(): Int {
        return clienteList3.size
    }
}

class ClienteViewHolder3(itemView : View, listener: ClienteAdapter3.onItemClickListener) : RecyclerView.ViewHolder(itemView){
    val iTvNombre : TextView = itemView.findViewById(R.id.tvNombre)
    val iTvApodo : TextView = itemView.findViewById(R.id.tvApodo)
    val iTvFiado : TextView = itemView.findViewById(R.id.tvFiado)
    val iTvEnvases : TextView = itemView.findViewById(R.id.tvEnvases)

    init {
        itemView.setOnClickListener {
            listener.onItemClick(absoluteAdapterPosition)
        }
    }
}