package br.com.grsoft.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //TODO Fazer esse jogo para se jogar online

    var userChoise = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imRock.setOnClickListener { it ->
            resultChoise(it)
        }

        imPaper.setOnClickListener { it ->
            resultChoise(it)
        }

        imScissor.setOnClickListener { it ->
            resultChoise(it)
        }
    }

    private fun resultChoise(it: View) {
        val appChoice = appChoice()
        when (it.id) {
            R.id.imRock -> {
                userChoise = UserChoise.ROCK.value
            }
            R.id.imPaper -> {
                userChoise = UserChoise.PAPER.value
            }
            R.id.imScissor -> {
                userChoise = UserChoise.SCISSOR.value
            }
        }

        if (userChoise - appChoice == 0) {
            tvResult.text = resources.getString(R.string.draw)
        } else if(userChoise - appChoice == -1 || userChoise - appChoice == 2){
            tvResult.text = resources.getString(R.string.lost)
        } else {
            tvResult.text = resources.getString(R.string.win)
        }
    }

    private fun appChoice(): Int {
        val result = Random.nextInt(3)

        when (result) {
            0 -> {
                imAppChoice.setImageResource(R.drawable.pedra)
            }
            1-> {
                imAppChoice.setImageResource(R.drawable.papel)
            }
            2 -> {
                imAppChoice.setImageResource(R.drawable.tesoura)
            }
        }

        return result
    }
}
