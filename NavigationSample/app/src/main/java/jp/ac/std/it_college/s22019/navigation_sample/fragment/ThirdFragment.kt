package jp.ac.std.it_college.s22019.navigation_sample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import jp.ac.std.it_college.s22019.navigation_sample.R
import jp.ac.std.it_college.s22019.navigation_sample.databinding.FragmentThirdBinding

/**
 * ３つ目の画面用フラグメント
 */
class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.display.text = "<${args.choice}>"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}