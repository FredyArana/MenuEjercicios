package com.fredy.menuapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.fredy.menuapp.databinding.FragmentTriangleAreaBinding

class TriangleAreaFragment : Fragment() {

    private var _binding: FragmentTriangleAreaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTriangleAreaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculateArea.setOnClickListener {
            val baseInput = binding.etBaseInput.text.toString()
            val heightInput = binding.etHeightInput.text.toString()

            if (baseInput.isNotEmpty() && heightInput.isNotEmpty()) {
                val base = baseInput.toDoubleOrNull()
                val height = heightInput.toDoubleOrNull()

                if (base != null && height != null && base > 0 && height > 0) {
                    val area = 0.5 * base * height
                    binding.tvAreaResult.text = "El área del triángulo es: $area"
                } else {
                    Toast.makeText(requireContext(), "Por favor, ingrese valores válidos para la base y la altura.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Los campos no pueden estar vacíos.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.etBaseInput.addTextChangedListener {
            val base = it.toString()
            binding.tvBaseValue.text = base
            binding.tvBaseValue.visibility = if (base.isNotEmpty()) View.VISIBLE else View.GONE
        }

        binding.etHeightInput.addTextChangedListener {
            val height = it.toString()
            binding.tvHeightValue.text = height
            binding.tvHeightValue.visibility = if (height.isNotEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}