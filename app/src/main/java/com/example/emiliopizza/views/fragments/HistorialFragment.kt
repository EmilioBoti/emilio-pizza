package com.example.emiliopizza.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emiliopizza.R
import com.example.emiliopizza.views.adapters.HistorialAdapter
import com.example.emiliopizza.views.interactors.HistorialPresenter
import com.example.emiliopizza.views.interfaces.IHistorial
import com.example.emiliopizza.views.models.Ordered
import kotlinx.coroutines.launch

class HistorialFragment : Fragment(), IHistorial.PresenterView {
    private lateinit var container: RecyclerView
    private lateinit var historialPresenter: HistorialPresenter
    private lateinit var historialAdapter: HistorialAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_historial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Historial"

        container = view.findViewById(R.id.containerlistOrdered)

        historialPresenter = HistorialPresenter(this)

        lifecycleScope.launch {
            historialPresenter.getListOrdered()
        }

    }

    override fun getListItemOrdered(listOrdered: MutableList<Ordered>) {
        historialAdapter = HistorialAdapter(activity?.applicationContext!!, listOrdered)
        container.apply {
            layoutManager = GridLayoutManager(activity, 2, RecyclerView.VERTICAL, false)
            adapter = historialAdapter
        }
    }
}