package co.tsdroiddeveloper.jokerappdev.presentation

import android.graphics.Color
import co.tsdroiddeveloper.jokerappdev.data.CategoryRemoteDataSource
import co.tsdroiddeveloper.jokerappdev.data.ListCategoryCallback
import co.tsdroiddeveloper.jokerappdev.model.Category
import co.tsdroiddeveloper.jokerappdev.view.HomeFragment


class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    //INPUT
    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    // output (SUCESSO | FALHA | COMPLETE)
    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f,
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}