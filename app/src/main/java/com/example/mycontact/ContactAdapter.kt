package com.example.mycontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (private val contactList: ArrayList<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val textViewName : TextView = view.findViewById<TextView>(R.id.textViewName)
        val textViewPhone : TextView = view.findViewById<TextView>(R.id.textViewPhone)

        init {
            view.setOnClickListener{
                //TODO: Handle click event
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]
        holder.textViewName.text = contact.name
        holder.textViewPhone.text = contact.phone
    }

    override fun getItemCount(): Int {
        return contactList.size
    }


}