package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlinx.android.synthetic.main.activity_quiz_question.view.*
import javax.security.auth.login.LoginException

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionsList = Constants.getQuestions()
        Log.i("Question size","${questionsList.size}")

        val currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]

        progressBarLine.progress = currentPosition
        progressBarOutOf.text  = "$currentPosition" + "/" + "${progressBarLine.max}"

        questionTitle.text = question.question
        image.setImageResource(question.image)

        questionOptionOne.text  = question.optionOne
        questionOptionTwo.text  = question.optionTwo
        questionOptionThree.text  = question.optionThree
        questionOptionFour.text  = question.optionFour



    }
}