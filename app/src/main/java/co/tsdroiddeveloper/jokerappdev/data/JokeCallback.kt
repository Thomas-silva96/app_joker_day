package co.tsdroiddeveloper.jokerappdev.data

import co.tsdroiddeveloper.jokerappdev.model.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()
}