package co.tsdroiddeveloper.jokerappdev.data

interface ListCategoryCallback {

    fun onSuccess(response: List<String>)

    fun onError(response: String)

    fun onComplete()
}