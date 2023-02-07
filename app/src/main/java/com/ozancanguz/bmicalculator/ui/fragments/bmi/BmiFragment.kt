package com.ozancanguz.bmicalculator.ui.fragments.bmi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.fragment.findNavController
import com.ozancanguz.bmicalculator.R
import com.ozancanguz.bmicalculator.databinding.FragmentBmiBinding


class BmiFragment : Fragment() {

    private var _binding: FragmentBmiBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBmiBinding.inflate(inflater, container, false)
        val view = binding.root


        changeseekBar()

        binding.calculatebtn.setOnClickListener {
            findNavController().navigate(R.id.action_bmiFragment_to_resultFragment)
        }

        // bmi calculation function
          calculateBmi()


        // age changing function
        changeAge()

        // change weight function
        changeWeight()


        return view
    }

    private fun changeWeight() {
        var weight:Int=80
        binding.increaseweight.setOnClickListener {
            binding.weightTv.text=weight++.toString()
        }
        binding.decreaseweight.setOnClickListener {
            binding.weightTv.text=weight--.toString()
        }
    }

    private fun changeAge() {
        var age:Int=18
        binding.increaseage.setOnClickListener {
            binding.agetvv.text= age++.toString()
        }

        binding.decreaseage.setOnClickListener {
            binding.agetvv.text=age--.toString()
        }
    }


    private fun calculateBmi(){

        binding.calculatebtn.setOnClickListener {
            val weight=binding.weightTv.text.toString().toDouble()
            val height=binding.heighttv.text.toString().toDouble()/100
            val bmi=weight/(height*height)
            val directions=BmiFragmentDirections.actionBmiFragmentToResultFragment(bmi.toFloat())
            findNavController().navigate(directions)





        }


    }


    private fun changeseekBar() {
        binding.seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.heighttv.text=p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }


}
