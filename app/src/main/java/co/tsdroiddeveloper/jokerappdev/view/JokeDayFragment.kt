package co.tsdroiddeveloper.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.tsdroiddeveloper.jokerappdev.R
import co.tsdroiddeveloper.jokerappdev.model.Joke
import co.tsdroiddeveloper.jokerappdev.presentation.JokeDayPresenter
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    private lateinit var presenter: JokeDayPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokeDayPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)
        textView = view.findViewById(R.id.txt_joke)
        imageView = view.findViewById(R.id.img_joke)

        presenter.findRandom()
    }

    fun showJokeDay(joke: Joke) {
        textView.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imageView)
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }
}