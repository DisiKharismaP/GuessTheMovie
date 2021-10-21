package disiiy.khaper.guessthemovie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import disiiy.khaper.guessthemovie.R
import disiiy.khaper.guessthemovie.databinding.FragmentQuizBinding
import disiiy.khaper.guessthemovie.model.Quiz

class QuizFragment : Fragment() {

    private val questions: MutableList<Quiz> = mutableListOf(
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Lord of the Rings", "Cast Away", "Life of Pi", "Stand by Me")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Tomb Rider", "Jungle Cruise", "Life of Pi", "Mortal Kombat")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Harry Potter", "Fantastic Beasts", "Vampire Academy", "Witcher")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Avatar", "Blue Creature", "Magical Jungle", "Cast Away")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Jurassic World", "Jungle Cruise", "Jurassic Park", "Forest Trainer")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Maze Runner", "Fallen Kingdom", "Boys Runner", "Zig Zag")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Guardians of The Galaxy", "2001 : A Space Odyssey", "Mortal Kombat", "The Avengers")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Alice in Wonderland", "Alice Through The Looking Glass", "The Hobbit", "War of Thunderland")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Back to The Future", "Are We Going Back?", "Went Back to Reality", "Zig Zag World")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("The Conjuring", "The Nun", "MaMa", "Annabelle 2014")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("The Shawshank Redemption", "Cast Away", "The Innocent", "False World")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Spirited Away", "Magical World", "Cast Away", "Ponyo")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Dunkirk", "1917", "Schindler's List", "Apocalypse Now")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("Parasite", "The Guilty", "Train to Busan", "Goblin")
            ),
            Quiz(
                    image = R.drawable.dunkirk,
                    text = "Guess what movie is this?",
                    answers = listOf("IT", "Stand by Me", "Boys Runner", "Loser vs Lover")
            ),
    )

    private var questionIndex = 0
    lateinit var currentQuestion : Quiz
    lateinit var answers: MutableList<String>
    private val numberIndicatorQuestion = Math.min((questions.size + 1)/ 1, 10)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val quizBinding = DataBindingUtil.inflate<FragmentQuizBinding>(
                inflater,
                R.layout.fragment_quiz,
                container,
                false
        )
        randomQuestion()
        quizBinding.quiz = this
        quizBinding.btnSubmitQuiz.setOnClickListener {
            view: View ->
            val checkedId = quizBinding.rgQuiz.checkedRadioButtonId
            if (-1 != checkedId){
                var answerCorrectPosition = 0
                when(checkedId){
                    R.id.rb_option2 -> answerCorrectPosition = 1
                    R.id.rb_option3 -> answerCorrectPosition = 2
                    R.id.rb_option4 -> answerCorrectPosition = 3
                }
                if(answers[answerCorrectPosition] == currentQuestion.answers[0]){
                    questionIndex++
                    if (questionIndex < numberIndicatorQuestion){
                        currentQuestion = questions[questionIndex]
                        setNumberQuestion()
                        quizBinding.invalidateAll()
                    }else{
                        view.findNavController().navigate(R.id.action_quizFragment_to_finishFragment)
                    }
                }else{
                    view.findNavController().navigate(R.id.action_quizFragment_to_tryAgainFragment)
                }
            }
        }
        return quizBinding.root
    }

    private fun randomQuestion() {
        questions.shuffle()
        questionIndex = 0
        setNumberQuestion()
    }

    private fun setNumberQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_guess, questionIndex + 1, numberIndicatorQuestion)
    }

}

