package fr.epsi.epsig2


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (private val catogories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val buttonViewCategory = view.findViewById<Button>(R.id.buttonViewCategory)

        val contentLayoutCategory = view.findViewById<LinearLayout>(R.id.contentLayoutCategory)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = catogories.get(position)
        holder.buttonViewCategory.text = category.title

        holder.buttonViewCategory.setOnClickListener(View.OnClickListener {
            val context = holder.buttonViewCategory.context
            val newIntent = Intent(context, ProductActivity::class.java)
            newIntent.putExtra("title", category.title)
            newIntent.putExtra("products_url", category.products_url)
            context.startActivity(newIntent)
        })

        holder.contentLayoutCategory.setOnClickListener(View.OnClickListener {
            (holder.contentLayoutCategory.context.applicationContext as AppRenduEPSI).showToast(
                category.title
            )
        })

    }

    override fun getItemCount(): Int {
        return catogories.size
    }
}
