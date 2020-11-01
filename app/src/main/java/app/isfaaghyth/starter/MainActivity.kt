package app.isfaaghyth.starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import app.isfaaghyth.home.viewmodel.HomeViewModel
import app.isfaaghyth.starter.databinding.ActivityMainBinding
import com.utsman.abstraction.extensions.toast
import com.utsman.abstraction.state.ResultState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val simpleAdapter = SimpleAdapter()
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setupRecyclerView()
        setupData()
    }

    private fun setupRecyclerView() {
        mainBinding.rvMain.run {
            layoutManager = GridLayoutManager(context, 2)
            adapter = simpleAdapter
        }
    }

    private fun setupData() {
        homeViewModel.run {
            getPhoto()
            photo.observe(this@MainActivity, Observer {
                when (it) {
                    is ResultState.Idle -> {
                        // idle
                    }
                    is ResultState.Loading -> {
                        toast("loading")
                    }
                    is ResultState.Error -> {
                        val throwable = it.throwable
                        toast("error: ${throwable?.message}")
                    }
                    is ResultState.Success -> {
                        toast("success")
                        val data = it.payload ?: emptyList()
                        simpleAdapter.addList(data)
                    }
                }
            })
        }
    }

}
