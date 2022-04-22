package co.tsdroiddeveloper.jokerappdev.presentation

import co.tsdroiddeveloper.jokerappdev.data.JokeRemoteDataSource
import co.tsdroiddeveloper.jokerappdev.data.JokeCallback
import co.tsdroiddeveloper.jokerappdev.model.Joke
import co.tsdroiddeveloper.jokerappdev.view.JokeFragment


class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}