package ir.mahanfr.chatapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.mahanfr.chatapp.R
import ir.mahanfr.chatapp.adapters.MessageRecyclerviewAdapter
import ir.mahanfr.chatapp.data.models.Chat
import ir.mahanfr.chatapp.ui.activities.MessagingActivity
import ir.mahanfr.chatapp.ui.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        //TODO: Change Dummy For The Real one
        val dummyDataList:ArrayList<Chat> = ArrayList()
        dummyDataList.add(Chat(1, emptyList(), listOf("mahan","admin")))
        dummyDataList.add(Chat(2, emptyList(), listOf("mahan","admin")))
        Log.d("DummyList",dummyDataList.size.toString())
        val recyclerView:RecyclerView = root.findViewById(R.id.fragment_home_recyclerview)
        recyclerView.apply {
            this.adapter = MessageRecyclerviewAdapter(dummyDataList)
            this.layoutManager = LinearLayoutManager(context)
        }
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

}