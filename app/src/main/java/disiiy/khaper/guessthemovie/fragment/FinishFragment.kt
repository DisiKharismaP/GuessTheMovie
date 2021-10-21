package disiiy.khaper.guessthemovie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import disiiy.khaper.guessthemovie.R
import disiiy.khaper.guessthemovie.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {
    private lateinit var finishBinding: FragmentFinishBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        finishBinding = FragmentFinishBinding.inflate(inflater, container, false)
        return finishBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        finishBinding.btnFinish.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_finishFragment_to_welcomeFragment))
    }
}