package com.example.farmacianicols

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farmacianicols.local.FarmaciasUsadas
import com.example.farmacianicols.viewModel.FarmaciasAdapter
import com.example.farmacianicols.viewModel.FarmaciasViewModel
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(),FarmaciasAdapter.PassTheData {

    lateinit var mViewModel : FarmaciasViewModel
    lateinit var mAdapter: FarmaciasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(FarmaciasViewModel::class.java)
        mAdapter = FarmaciasAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = mRecycler
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

mViewModel.exposeLiveDataFromDataBase().observe(viewLifecycleOwner, Observer {
    Log.d("VIEW",it.toString())
    mAdapter.updateAdapter(it)
})

       // view.findViewById<Button>(R.id.button_first).setOnClickListener {
         //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    override fun passTheData(farmacias: FarmaciasUsadas) {
        val bundle = Bundle()
       // bundle.putString("id",farmaci
      //  findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}