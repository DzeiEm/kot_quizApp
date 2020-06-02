package com.example.quizapp

// kotlinfile,
object Constants {

    fun getQuestions(): ArrayList<Question> {

        val questionList = ArrayList<Question>()

        val question1 =
            Question(
                1, "What country does this flag belong to?",
                R.drawable.ic_flag_of_argentina,
                "Germany",
                "Argentina",
                "MAlta",
                "Italy",
                2
            )
        questionList.add(question1)

        val question2 =
            Question(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Germany",
                "Australia",
                "Ispany",
                "Italy",
                2
            )
        questionList.add(question2)

        val question3 =
            Question(
                3, "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Belgium",
                "Australia",
                "Ispany",
                "Italy",
                1
            )
        questionList.add(question3)

        val question4 =
            Question(
                4, "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Germany",
                "Australia",
                "Brazil",
                "Italy",
                3
            )
        questionList.add(question4)

        val question5 =
            Question(
                5, "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Germany",
                "Australia",
                "Ispany",
                "Denmark",
                4
            )
        questionList.add(question5)

        val question6 =
            Question(
                6, "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Germany",
                "Australia",
                "Ispany",
                "Italy",
                1
            )
        questionList.add(question6)

        val question7 =
            Question(
                7, "What country does this flag belong to?",
                R.drawable.ic_flag_of_india,
                "Germany",
                "Australia",
                "Ispany",
                "India",
                4
            )
        questionList.add(question7)

        val question8 =
            Question(
                8, "What country does this flag belong to?",
                R.drawable.ic_flag_of_kuwait,
                "Germany",
                "Kuwait",
                "Ispany",
                "Italy",
                2
            )
        questionList.add(question8)

        val question9 =
            Question(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_new_zealand,
                "Germany",
                "New Zealand",
                "Ispany",
                "Italy",
                2
            )
        questionList.add(question9)

        val question10 =
            Question(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_fiji,
                "Germany",
                "Australia",
                "Fiji",
                "Italy",
                3
            )
        questionList.add(question10)
        return questionList
    }
}