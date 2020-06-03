package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlinx.android.synthetic.main.activity_quiz_question.view.*
import javax.security.auth.login.LoginException

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1 // default for the first question position
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
        questionOptionOne.setOnClickListener(this)
        questionOptionTwo.setOnClickListener(this)
        questionOptionThree.setOnClickListener(this)
        questionOptionFour.setOnClickListener(this)
        submitButton.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionsList!!.get(mCurrentPosition -1) // Getting question from the list with the help of current position
        defaultFunctionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            submitButton.text = "FINISH"
        }else {
            submitButton.text = "SUBMIT"
        }

        progressBarLine.progress = mCurrentPosition
        progressBarOutOf.text = "$mCurrentPosition" + "/" + "${progressBarLine.max}"

        questionTitle.text = question.question
        image.setImageResource(question.image)
        questionOptionOne.text = question.optionOne
        questionOptionTwo.text = question.optionTwo
        questionOptionThree.text = question.optionThree
        questionOptionFour.text = question.optionFour
    }

    private fun defaultFunctionsView() {

        val options = ArrayList<TextView>()
        options.add(0, questionOptionOne)
        options.add(1, questionOptionTwo)
        options.add(2, questionOptionThree)
        options.add(3, questionOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#3700B3"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.text_view_appearance
            )
        }
    }

    override fun onClick(v: View?) {

        fun answerView(answer: Int, drawableView: Int) {
            when (answer) {
                1 -> questionOptionOne.background = ContextCompat.getDrawable(this, drawableView)
                2 -> questionOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
                3 -> questionOptionThree.background = ContextCompat.getDrawable(this, drawableView)
                4 -> questionOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }

        fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
            defaultFunctionsView()
            mSelectedOptionPosition = selectedOptionNum


            tv.setTextColor(Color.parseColor("#009999"))
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.text_view_appearance_on_tap
            )
        }

        when (v?.id) {
            R.id.questionOptionOne -> {
                selectedOptionView(questionOptionOne, 1)

            }
            R.id.questionOptionTwo -> {
                selectedOptionView(questionOptionTwo, 2)
            }
            R.id.questionOptionThree -> {
                selectedOptionView(questionOptionThree, 3)
            }
            R.id.questionOptionFour -> {
                selectedOptionView(questionOptionFour, 4)
            }
            R.id.submitButton -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "You have successfully completed the Quiz",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.text_view_appearance_wrong_answer_border)
                    }
                    answerView(question.correctAnswer, R.drawable.text_view_appearance_correct_answer_border)
                    if(mCurrentPosition == mQuestionsList!!.size){
                        submitButton.text = "FINISH"
                    } else {
                        submitButton.text = "GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }
}