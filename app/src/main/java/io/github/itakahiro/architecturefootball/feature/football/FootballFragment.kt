package io.github.itakahiro.architecturefootball.feature.football

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import io.github.itakahiro.architecturefootball.databinding.FragmentFootballBinding

class FootballFragment : Fragment() {

    private lateinit var binding: FragmentFootballBinding

    private val viewModel =
        FootballViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFootballBinding.inflate(inflater, container, false)
        // このようにしても良い
//        binding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_football, container, false
//        )
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editText.addTextChangedListener { text ->
            viewModel.updateButton(text.isNullOrBlank())
        }
        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.submitText(text)
        }

        // この部分はDataBindingで実装
//        viewModel.isEnabled.observe(viewLifecycleOwner, Observer { isEnabled ->
//            binding.button.isEnabled = isEnabled
//        })
    }
}