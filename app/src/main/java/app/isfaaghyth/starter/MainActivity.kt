package app.isfaaghyth.starter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import app.isfaaghyth.home.viewmodel.HomeViewModel
import app.isfaaghyth.starter.databinding.ActivityMainBinding
import app.isfaaghyth.starter.databinding.ItemListSimpleBinding
import com.utsman.abstraction.extensions.loadUrl
import com.utsman.abstraction.extensions.setup
import com.utsman.abstraction.extensions.toast
import com.utsman.abstraction.state.ResultState
import com.utsman.data.model.Photo
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupData()
        setupSwipeRefresh()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            setupData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setupRecyclerView(photos: List<Photo>) {
        val layoutManager = GridLayoutManager(this, 2)
        binding.rvMain.setup(
            photos,
            ItemListSimpleBinding::class.java,
            { binding, photo ->
                binding.imgItem.loadUrl(url = photo.urls.small, id = photo.id)
            },
            {
                toast("Clicked")
            },
            layoutManager
        )
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
                    is ResultState.Message -> {
                        toast("Message: ${it.msg}")
                    }
                    is ResultState.Success -> {
                        toast("success")
                        val data = it.payload ?: emptyList()
                        setupRecyclerView(data)
                    }
                }
            })
        }
    }

}
