package com.example.myapplication


import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var odd_num: Int = 0


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textSwitcher = view.findViewById<TextSwitcher>(R.id.Show_oddNumber)

        textSwitcher.setFactory {
            val textView = TextView(requireActivity())
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.CYAN)
            textView
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        }
        binding.nextPrime.setOnClickListener {
            odd_num += 2
            textSwitcher.setText(odd_num.toString());
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}