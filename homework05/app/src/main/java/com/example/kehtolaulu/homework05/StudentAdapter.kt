package com.example.kehtolaulu.homework05

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StudentAdapter(diffCallback: DiffUtil.ItemCallback<Student>) : ListAdapter<Student, StudentAdapter.StudentViewHolder>(diffCallback) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return StudentViewHolder(inflater.inflate(R.layout.list_item_student, viewGroup, false))
    }

    override fun onBindViewHolder(holder: StudentViewHolder, id: Int) {
        holder.studentName.text = getItem(id).name
        holder.studentAge.text = getItem(id).age.toString()
    }

    inner class StudentViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var studentName: TextView = itemView.findViewById(R.id.tv_name)
        internal var studentAge: TextView = itemView.findViewById(R.id.tv_age)
    }
}
