package com.example.facebooklayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.facebooklayout.Adapter.DetailAdapter
import com.example.facebooklayout.ViewModel.MainViewModel
import com.example.facebooklayout.databinding.ActivityMainBinding

class PostFragment : Fragment() {
    lateinit var binding: ActivityMainBinding
    val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            val detailAdapter by lazy { DetailAdapter(mainViewModel.loadData()) }
            Detail.appy{
                adapter
            }
        }

//        val view = inflater.inflate(R.layout.fragment_post, container, false)
//
//        //1-Adapter
//        val recyclerView = view.findViewById<RecyclerView>(R.id.detailsRecyclerView)
//
//        recyclerView.layoutManager = LinearLayoutManager(
//            this.context,
//            LinearLayoutManager.VERTICAL,
//            false
//        )
//        //2. Data Source
//        var detailsItems: ArrayList<ItemModel> = ArrayList()
//        val v1 = ItemModel("Founder and CEO at Meta", R.drawable.bag)
//        val v2 = ItemModel("Works at Chan Zuckerberg Initiative", R.drawable.bag)
//        val v3 = ItemModel("Studied Computer Science and Psychology at Harvard University", R.drawable.graduation)
//        val v4 = ItemModel("Lives in Palo Alto, California", R.drawable.home)
//        val v5 = ItemModel("From Dobbs Ferry, New York", R.drawable.location)
//
//        detailsItems.add(v1)
//        detailsItems.add(v2)
//        detailsItems.add(v3)
//        detailsItems.add(v4)
//        detailsItems.add(v5)
//
//        //3.Adapter
//        val adapter = MyAdapter(detailsItems)
//        recyclerView.adapter = adapter
//
//
//        // Inflate the layout for this fragment
//        return view


    }
}
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_layout, container, false)
//
//        // Tìm kiếm View trong Fragment
//        val button = view.findViewById<Button>(R.id.my_button)
//
//        // Xử lý sự kiện khi nút được nhấn
//        button.setOnClickListener {
//            // Thực hiện hành động khi nút được nhấn
//        }
//
//        return view
//    }


//}