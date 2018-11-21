package com.example.kehtolaulu.homework05

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.ProgressBar
import android.widget.Toast
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.intellij.lang.annotations.Flow
import org.reactivestreams.Subscription
import java.util.function.Consumer

class RecyclerFragment : Fragment() {
    companion object {
        fun newInstance(): RecyclerFragment {
            return RecyclerFragment()
        }
    }

    lateinit var studentAdapter: StudentAdapter
    lateinit var diff: StudentListDiffCallback
    lateinit var toolbar: Toolbar
    lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        toolbar = view.findViewById(R.id.toolbar)
        progressBar = view.findViewById(R.id.progress_bar)
        progressBar.visibility = ProgressBar.INVISIBLE
        (activity as MainActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)
        val studentsRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        studentsRecyclerView.layoutManager = LinearLayoutManager(context)
        diff = StudentListDiffCallback()
        studentAdapter = StudentAdapter(diff)
        studentAdapter.submitList(StudentsHelper.list)
        studentsRecyclerView.adapter = studentAdapter
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var students = StudentsHelper.list
        when (item.itemId) {
            R.id.item_sort_by_age -> {
                sortByAge(students)
                Toast.makeText(context, "Age sorting", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.item_sort_in_alph -> {
                sortByAlpha(students)
                Toast.makeText(context, "Alpha sorting", Toast.LENGTH_SHORT)
                        .show()
            }
        }
        return true
    }

    fun sortByAlpha(students: List<Student>) {
        Flowable.fromIterable(students)
                .take(12)
                .map { s -> Student(s.name + s.name.length, s.age) }
                .sorted { o1, o2 -> o1.name.compareTo(o2.name) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSubscribe { showLoading() }
                .toList()
                .doAfterTerminate { hideLoading() }
                .subscribe { students -> studentAdapter.submitList(students) }
    }

    private fun showLoading() {
        progressBar.visibility = ProgressBar.VISIBLE;
    }

    private fun hideLoading() {
        progressBar.visibility = ProgressBar.INVISIBLE;

    }

    fun sortByAge(students: List<Student>) {
        Flowable.fromIterable(students)
                .take(12)
                .map { s -> Student(s.name + s.name.length, s.age) }
                .sorted { o1, o2 -> o1.age.compareTo(o2.age) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSubscribe { showLoading() }
                .toList()
                .doAfterTerminate { hideLoading() }
                .subscribe { students -> studentAdapter.submitList(students) }
    }
}
