package com.fredy.menuapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fredy.menuapp.databinding.FragmentWallConstructionBinding

class WallConstructionFragment : Fragment() {

    private var _binding: FragmentWallConstructionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWallConstructionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculateDays.setOnClickListener {
            val initialWorkersInput = binding.etInitialWorkers.text.toString()
            val initialDaysInput = binding.etInitialDays.text.toString()

            if (initialWorkersInput.isNotEmpty() && initialDaysInput.isNotEmpty()) {
                val initialWorkers = initialWorkersInput.toIntOrNull()
                val initialDays = initialDaysInput.toIntOrNull()

                if (initialWorkers != null && initialWorkers > 0 && initialDays != null && initialDays > 0) {
                    val targetWorkers = 6 // Queremos calcular para 6 trabajadores
                    val requiredDays = (initialWorkers * initialDays) / targetWorkers
                    binding.tvDaysResult.text = "Se necesitarán aproximadamente $requiredDays días para que $targetWorkers trabajadores construyan el muro."
                } else {
                    Toast.makeText(requireContext(), "Por favor, ingrese valores válidos para los trabajadores y días.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Los campos no pueden estar vacíos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}