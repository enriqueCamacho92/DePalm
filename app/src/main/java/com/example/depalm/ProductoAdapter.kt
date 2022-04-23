package com.example.depalm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ProductoAdapter(private val productoList:List<Producto>) : RecyclerView.Adapter<ProductoViewHolder>(){
    private val db = FirebaseFirestore.getInstance()
    private var updateProductoList: MutableList<Producto> = productoList as MutableList<Producto>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        return ProductoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.producto_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentItem = productoList[position]

        holder.iTvProducto.text = currentItem.producto
        holder.iTvPrecio.text = currentItem.precio

        holder.buttonEliminar.setOnClickListener {
            db.collection(globalEmail+"-productos").document(currentItem.producto).delete()
            updateProductoList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return productoList.size
    }
}

class ProductoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val buttonEliminar : ImageButton = itemView.findViewById(R.id.delete_producto_button)
    val iTvProducto : TextView = itemView.findViewById(R.id.cvProducto)
    val iTvPrecio : TextView = itemView.findViewById(R.id.cvPrecio)
}