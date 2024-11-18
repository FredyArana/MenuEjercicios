package com.fredy.menuapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fredy.menuapp.databinding.FragmentCompositeCheckerBinding

class CompositeCheckerFragment : Fragment() {

    private var _binding: FragmentCompositeCheckerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompositeCheckerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheckComposite.setOnClickListener {
            val input = binding.etNumberInput.text.toString()
            if (input.isNotEmpty()) {
                val number = input.toIntOrNull()
                if (number != null && number > 0) {
                    val factors = findFactors(number)
                    val isComposite = factors.size > 2

                    val factorsText = "Factores de $number: ${factors.joinToString(", ")}"
                    binding.tvFactorsResult.text = factorsText

                    val explanationText = if (isComposite) {
                        "$number es un número compuesto porque tiene más de dos divisores (factores), lo que significa que no es un número primo."
                    } else {
                        "$number no es un número compuesto porque solo tiene dos divisores o menos (es un número primo)."
                    }
                    binding.tvCompositeExplanation.text = explanationText
                } else {
                    Toast.makeText(requireContext(), "Por favor, ingrese un número válido mayor que 0.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun findFactors(number: Int): List<Int> {
        val factors = mutableListOf<Int>()
        for (i in 1..number) {
            if (number % i == 0) {
                factors.add(i)
            }
        }
        return factors
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}