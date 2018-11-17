package com.example.kehtolaulu.homework05

import android.support.v7.util.DiffUtil


class StudentListDiffCallback : DiffUtil.ItemCallback<Student>() {

    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
        return if (oldItem.name == newItem.name) {
            oldItem.age == newItem.age
        } else false
    }
}