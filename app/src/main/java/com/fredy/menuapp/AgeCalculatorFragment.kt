package com.fredy.menuapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fredy.menuapp.databinding.FragmentAgeCalculatorBinding

class AgeCalculatorFragment : Fragment() {

    private var _binding: FragmentAgeCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAgeCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculateAges.setOnClickListener {
            val anaAgeInput = binding.etAnaAgeInput.text.toString()
            if (anaAgeInput.isNotEmpty()) {
                val anaAge = anaAgeInput.toIntOrNull()
                if (anaAge != null && anaAge >= 6) {
                    val juanAge = anaAge - 5
                    binding.tvAgesResult.text = "Ana tiene $anaAge años.\nJuan tiene $juanAge años."
                } else {
                    Toast.makeText(requireContext(), "Por favor, ingrese una edad válida. La edad mínima permitida es 6 años.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}