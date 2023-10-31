package tranhph26979.fpoly.bai6_rettrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tranhph26979.fpoly.bai6_rettrofit.Adapter.UserAdapter
import tranhph26979.fpoly.bai6_rettrofit.dagger.ExerciseApplication
import tranhph26979.fpoly.bai6_rettrofit.model.UserModel
import tranhph26979.fpoly.bai6_rettrofit.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    private lateinit var viewModel: UserViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as ExerciseApplication).appComponent.inject(this)
        recyclerView=findViewById(R.id.recycleview)
        adapter= UserAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUsers().observe(this,{users ->
            adapter.setUserList(users)
        })
    }
}