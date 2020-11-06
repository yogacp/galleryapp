package app.isfaaghyth.starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private lateinit var mainBinding: ActivityMainBinding
    private val simpleAdapter = SimpleAdapter()
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupData()
    }

    private fun setupRecyclerView(photos: List<Photo>) {
        val layoutManager = GridLayoutManager(this, 2)
        mainBinding.rvMain.setup(
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
