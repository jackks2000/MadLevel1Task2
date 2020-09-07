package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityConjunctionQuizBinding

class ConjunctionQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConjunctionQuizBinding
    private var correctAnswers: Int = 0;
    private val questions: Int = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConjunctionQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.btnSubmit.setOnClickListener{
            checkAnwers()
            Log.i("submit", "submit")
        }
    }

    private fun checkAnwers(){

        Log.i("check answer", "check answer")

        if (binding.input1.text.toString().toUpperCase() == "T") onAnswerCorrect() else Log.i("False", "False")
//        if (binding.input1.text.toString() == "T") onAnswerCorrect()
        if (binding.input2.text.toString().toUpperCase() == "F") onAnswerCorrect()
        if (binding.input3.text.toString().toUpperCase() == "F") onAnswerCorrect()
        if (binding.input4.text.toString().toUpperCase() == "F") onAnswerCorrect()

        var incorrectAnwers: Int = questions - correctAnswers
        Log.i("incorrect answers", incorrectAnwers.toString())
        if (incorrectAnwers == 0) Toast.makeText(this, "Alle antwoorden zijn juist", Toast.LENGTH_SHORT).show() else Toast.makeText(this,
            "$incorrectAnwers fouten antwoorden", Toast.LENGTH_SHORT).show()

        correctAnswers = 0

    }

    private fun onAnswerCorrect(){
        correctAnswers += 1
        Log.i("Correct answers", correctAnswers.toString())
    }
}