package com.example.studyapp

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.android_item_row.view.*

class AndroidRecyclerViewAdapter(private val titleList: ArrayList<String>, private val infoList: ArrayList<String>,
                                private val explainings: ArrayList<String>)
    :RecyclerView.Adapter<AndroidRecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.android_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val title = titleList[position]
        val info = infoList[position]
        val explain = explainings[position]
        holder.itemView.apply {
            tvAndroidTitle.text = title
            tvAndroidInfo.text = info
            cvAndroidReview.setOnClickListener {
                val dialogBuilder = AlertDialog.Builder(context)

                dialogBuilder.setMessage(explain)
                    .setNegativeButton("Ok", DialogInterface.OnClickListener{ dialog, _ -> dialog.cancel()})

                val alart = dialogBuilder.create()
                alart.setTitle(title)
                alart.show()
            }
        }
    }

    override fun getItemCount() = titleList.size
}