package github.sachin2dehury.universitylist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import github.sachin2dehury.universitylist.databinding.MainActivityBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: MainActivityBinding? = null

    private val viewModel: UniversityViewModel by viewModels()

    private val universityPagingAdapter = UniversityPagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpUi()
        subscribeToObserver()
    }

    private fun subscribeToObserver() {
        lifecycleScope.launch {
            viewModel.getPager().flow.collectLatest {
                universityPagingAdapter.submitData(it)
            }
        }
    }

    private fun setUpUi() = binding?.run {
        recyclerView.adapter = universityPagingAdapter
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
