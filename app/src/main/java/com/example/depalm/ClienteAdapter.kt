package com.example.depalm

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class ClienteAdapter(private val clienteList:List<Cliente>) : RecyclerView.Adapter<ClienteViewHolder>(){

    private val db = FirebaseFirestore.getInstance()
    private var updateClienteList: MutableList<Cliente> = clienteList as MutableList<Cliente>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
       return ClienteViewHolder(
           LayoutInflater.from(parent.context)
               .inflate(R.layout.cliente_item,parent,false)
       )
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        val currentItem = clienteList[position]

        holder.iTvNombre.text = currentItem.nombre
        holder.iTvApodo.text = currentItem.apodo
        holder.iTvFiado.text = currentItem.fiado
        holder.iTvEnvases.text = currentItem.envases

        holder.buttonEliminar.setOnClickListener {
            db.collection(globalEmail+"-clientes").document(currentItem.nombre).delete()
           updateClienteList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return clienteList.size
    }

}

class ClienteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val buttonEliminar : ImageButton = itemView.findViewById(R.id.delete_cliente_button)

    val iTvNombre : TextView = itemView.findViewById(R.id.tvNombre)
    val iTvApodo : TextView = itemView.findViewById(R.id.tvApodo)
    val iTvFiado : TextView = itemView.findViewById(R.id.tvFiado)
    val iTvEnvases : TextView = itemView.findViewById(R.id.tvEnvases)
}

