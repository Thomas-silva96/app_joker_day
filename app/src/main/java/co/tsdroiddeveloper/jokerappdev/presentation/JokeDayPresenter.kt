package co.tsdroiddeveloper.jokerappdev.presentation

import co.tsdroiddeveloper.jokerappdev.data.JokeCallback
import co.tsdroiddeveloper.jokerappdev.data.JokeDayRemoteDataSource
import co.tsdroiddeveloper.jokerappdev.model.Joke
import co.tsdroiddeveloper.jokerappdev.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback {

    fun findRandom() {
        view.showProgress()
        dataSource.findRandom(this)
    }

    override fun onSuccess(response: Joke) {
        view.showJokeDay(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}