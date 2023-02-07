package com.ozancanguz.bmicalculator.ui.fragments.results

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozancanguz.bmicalculator.R
import com.ozancanguz.bmicalculator.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null

    private val binding get() = _binding!!

    private val args:ResultFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.recalculatebtn.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_bmiFragment)
        }


        observe()

        return view
    }

    private fun observe() {


        val bmi=args.bmi.toFloat().toString()
        if(bmi<= 16.toString()){
            binding.progressBar.visibility=View.VISIBLE
            binding.bmitv.text= args.bmi.toFloat().toString()
            binding.statustv.text=" Thinness"
            binding.CommentTv.text="You are very thin. You need to get some weight !"
            binding.progressBar.visibility=View.INVISIBLE
        }else if(bmi> 18.toString() && bmi<25.toString()){
            binding.progressBar.visibility=View.VISIBLE
            binding.bmitv.text= args.bmi.toFloat().toString()
            binding.statustv.text="Normal"
            binding.CommentTv.text="You have a normal body weight. Good Job !"
            binding.progressBar.visibility=View.INVISIBLE
        }else if(bmi>25.toString()){
            binding.progressBar.visibility=View.VISIBLE
            binding.bmitv.text= args.bmi.toFloat().toString()
            binding.statustv.text="Overweight"
            binding.CommentTv.text="You are very thin. You need to get some weight !"
            binding.progressBar.visibility=View.INVISIBLE
        }

    }


}