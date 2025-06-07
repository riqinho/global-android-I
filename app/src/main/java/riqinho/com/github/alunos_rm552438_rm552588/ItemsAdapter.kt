package riqinho.com.github.alunos_rm552438_rm552588

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private  val onItemRemoved: (ItemModel) -> Unit): RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>(){
    private var items = listOf<ItemModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewLocal = view.findViewById<TextView>(R.id.textViewLocal)
        val textViewEvento = view.findViewById<TextView>(R.id.textViewEvento)
        val textViewImpacto = view.findViewById<TextView>(R.id.textViewImpacto)
        val textViewData = view.findViewById<TextView>(R.id.textViewData)
        val textViewPessoas = view.findViewById<TextView>(R.id.textViewPessoas)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item:ItemModel){
            textViewLocal.text = item.local
            textViewEvento.text = item.evento
            textViewImpacto.text = item.impacto
            textViewData.text = item.data
            textViewPessoas.text = item.qtd_pessoas

            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(newItems: List<ItemModel>){
        items = newItems
        notifyDataSetChanged()
    }
}