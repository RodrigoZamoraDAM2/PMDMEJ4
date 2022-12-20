package com.example.pmdmej41
import com.example.pmdmej41.databinding.ActivityMainBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.editText.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                binding.sumar.setBackgroundColor(getColor(R.color.purple_700))
                binding.restar.setBackgroundColor(getColor(R.color.purple_700))
            }
            else{
                binding.sumar.setBackgroundColor(getColor(R.color.teal_200))
                binding.restar.setBackgroundColor(getColor(R.color.teal_200))
            }
        }
        binding.MainLayout.setOnClickListener{
            binding.editText.clearFocus()
        }
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if(binding.editText.text.toString().isNotEmpty() && binding.editText.text.isDigitsOnly() && binding.editText.text.toString().toInt()>=0) {

                    binding.textView.setText(binding.editText.getText().toString())
                }
            }
        })
        binding.sumar.setOnClickListener(){
            var cuenta = binding.textView.text.toString().toInt()+1
            binding.textView.setText(cuenta.toString())
        }
        binding.restar.setOnClickListener(){
            if(binding.textView.text.toString().toInt()>0) {
                var cuenta = binding.textView.text.toString().toInt() - 1
                binding.textView.setText(cuenta.toString())
            }
        }
    }
}