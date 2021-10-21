package disiiy.khaper.guessthemovie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import disiiy.khaper.guessthemovie.R
import disiiy.khaper.guessthemovie.databinding.FragmentTryAgainBinding

class TryAgainFragment : Fragment() {

    private lateinit var tryAgainBinding: FragmentTryAgainBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tryAgainBinding = FragmentTryAgainBinding.inflate(inflater, container, false)
        return tryAgainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tryAgainBinding.btnTryagain.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_tryAgainFragment_to_welcomeFragment))
    }

}