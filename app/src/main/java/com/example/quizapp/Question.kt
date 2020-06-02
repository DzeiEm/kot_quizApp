package com.example.quizapp

//kotlinfile...apsirasom kaip atrodys klausimas
data class Question (
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
