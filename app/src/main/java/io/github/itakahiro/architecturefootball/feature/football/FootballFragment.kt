package io.github.itakahiro.architecturefootball.feature.football

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.itakahiro.architecturefootball.databinding.FragmentFootballBinding
import io.github.itakahiro.architecturefootball.feature.MainActivity
import io.github.itakahiro.architecturefootball.feature.common.PlayCallHistoryListAdapter
import io.github.itakahiro.architecturefootball.feature.football.di.inject
import io.github.itakahiro.architecturefootball.feature.playcalllist.PlayCallListFragment
import io.github.itakahiro.architecturefootball.model.PlayCall
import javax.inject.Inject

class FootballFragment : Fragment() {

    private lateinit var binding: FragmentFootballBinding

    // DIすることで、以下3行を消せる. つまりこれらのクラスに対する依存性を軽減できる.
//    private val dao = App.database.playCallDao()
//    private val repository = PlayCallRepository(dao)
//    private val viewModel = FootballViewModel(repository)
    @Inject
    lateinit var viewModel: FootballViewModel

    override fun onAttach(context: Context) {
//        App.appComponent.inject(this)
        this.inject()
        super.onAttach(context)
    }

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

        binding.editTextInput.addTextChangedListener { text ->
            viewModel.updateButton(text.isNullOrBlank())
        }
        // 入力完了時にソフトウェアキーボードを閉じる処理
        binding.editTextInput.setOnEditorActionListener { v, actionId, event ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handled = hideSoftwareKeyboard()
            }
            return@setOnEditorActionListener handled
        }
        binding.buttonSet.setOnClickListener {
            val text = binding.editTextInput.text.toString()
            viewModel.submitText(text)
            viewModel.savePlayCall(PlayCall(text))
        }
        binding.buttonOpenList.setOnClickListener {
            val playCallListFragment =
                PlayCallListFragment()
            val mainActivity = activity as MainActivity?
            mainActivity?.replaceFragment(playCallListFragment)
        }

        // この部分はDataBindingで実装
//        viewModel.isEnabled.observe(viewLifecycleOwner, Observer { isEnabled ->
//            binding.button.isEnabled = isEnabled
//        })

        val adapter = PlayCallHistoryListAdapter(this, viewModel)
        binding.playCallHistoryList.adapter = adapter
        binding.playCallHistoryList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.loadPlayCallHistoryList()
    }

    // ソフトウェアキーボードを閉じる処理
    private fun hideSoftwareKeyboard(): Boolean {
        val context = context ?: return false
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(
            binding.editTextInput.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
        return true
    }
}
