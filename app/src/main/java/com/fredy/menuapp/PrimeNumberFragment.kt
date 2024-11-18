package com.fredy.menuapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fredy.menuapp.databinding.FragmentPrimeNumberBinding

class PrimeNumberFragment : Fragment() {

    private var _binding: FragmentPrimeNumberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrimeNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheckPrime.setOnClickListener {
            val input = binding.etNumberInput.text.toString()
            if (input.isNotEmpty()) {
                val number = input.toIntOrNull()
                if (number != null && number > 0) {
                    val isPrime = checkPrime(number)
                    binding.tvResult.text = if (isPrime) {
                        "$number es un número primo."
                    } else {
                        "$number no es un número primo."
                    }
                } else {
                    Toast.makeText(requireContext(), "Por favor, ingrese un número válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkPrime(number: Int): Boolean {
        if (number <= 1) return false
        for (i in 2..number / 2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}