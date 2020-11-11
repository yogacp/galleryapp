package app.isfaaghyth.starter

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import app.isfaaghyth.imagedetail.viewmodel.ImageDetailViewModel
import app.isfaaghyth.starter.databinding.ActivityFullImageBinding
import com.utsman.abstraction.extensions.*
import com.utsman.abstraction.state.ResultState
import com.utsman.data.constant.AppConstant
import com.utsman.data.model.Photo
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Yoga C. Pranata on 11/11/2020.
 * Android Engineer
 */
class ShowFullImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullImageBinding
    private val viewModel: ImageDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initArguments()
        observePhoto()
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return true
    }

    private fun initArguments() {
        val data = intent.extras
        data.notNull { bundle ->
            val imageId = bundle.getString(AppConstant.INTENT_KEY.IMAGE_ID)
            imageId.notNullOrEmpty {
                viewModel.getPhoto(it)
            }
        }
    }

    private fun setupToolbar(title: String) {
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setupView(photo: Photo?) {
        binding.imageView.loadUrl(photo?.urls?.full, photo?.id ?: "0")
        setupToolbar(getString(R.string.photo_from).format(photo?.user?.name))
    }

    private fun showLoading(isShow: Boolean) {
        binding.layoutLoading.setVisibleIf(isShow)
    }

    private fun observePhoto() {
        viewModel.photo.observe(this, Observer {
            when (it) {
                is ResultState.Idle -> {
                    // idle
                }
                is ResultState.Loading -> {
                    showLoading(true)
                }
                is ResultState.Error -> {
                    val throwable = it.throwable
                    showLoading(false)
                    toast("error: ${throwable?.message}")
                }
                is ResultState.Message -> {
                    showLoading(false)
                    toast("Message: ${it.msg}")
                }
                is ResultState.Success -> {
                    showLoading(false)
                    val data = it.payload
                    setupView(data)
                }
            }
        })
    }

}