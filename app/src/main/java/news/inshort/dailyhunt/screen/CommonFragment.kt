package news.inshort.dailyhunt.screen

import android.support.v7.app.ActionBar
import news.inshort.dailyhunt.R
import news.inshort.dailyhunt.application.MyApplication
import news.inshort.dailyhunt.base.BaseFragment
import news.inshort.dailyhunt.di.components.DaggerCategoriesComponent
import news.inshort.dailyhunt.di.modules.CategoriesModule
import javax.inject.Inject

/**
 * @Created by shahid on 12/28/2017.
 */
class CommonFragment : BaseFragment(), CommonView {
    @Inject lateinit var commonPresenter: CommonPresenter

    override fun setLayoutResource(): Int = R.layout.common_fragment

    override fun viewIsReady() {

        // when view is ready then call the api
        commonPresenter.loadData()
    }

    override fun setFragmentTitle(actionBar: ActionBar?, text: String?) {
        actionBar?.title = text
    }

    override fun resolveDependency() {
        DaggerCategoriesComponent.builder()
                .applicationComponent(MyApplication.applicationComponent)
                .categoriesModule(CategoriesModule(this))
                .build().injectCategories(this)
    }

    override fun loadCategories(suppose: List<String>) {

    }

    override fun loader(visibility: Int) {
        // show/hide loader
        super.showHideLoader(visibility)
    }


}