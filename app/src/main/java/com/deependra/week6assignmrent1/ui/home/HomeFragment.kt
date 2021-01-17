package com.deependra.week6assignmrent1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deependra.week6assignmrent1.Adapter.studentAdapter
import com.deependra.week6assignmrent1.R
import com.deependra.week6assignmrent1.buttomNavActivity
import com.deependra.week6assignmrent1.model.studentDetails

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var lstStudent = arrayListOf<studentDetails>()
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

            lstStudent = (activity as buttomNavActivity).lstStudent

            val context = root.context
            val adapter = studentAdapter(lstStudent, context)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        })
        return root
    }



}