package news.inshort.dailyhunt.screen

import android.view.View
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import news.inshort.dailyhunt.application.MyApplication
import news.inshort.dailyhunt.base.BasePresenter
import javax.inject.Inject

/**
 * @Created by shahid on 12/28/2017.
 */
class CommonPresenter @Inject constructor() : BasePresenter<CommonView>(), Observer<List<String>> {

    fun loadData() {
        mView.loader(View.VISIBLE)

        // subscribe the api call
        subscribe(MyApplication.applicationComponent.getRetrofitApiService().getListOfStrings(), this)
    }

    override fun onNext(value: List<String>) {
        mView.loadCategories(value)
    }

    override fun onSubscribe(d: Disposable?) {

    }

    override fun onComplete() {
        // hide progressbar
        mView.loader(View.GONE)
    }

    override fun onError(e: Throwable?) {
// handel error if any
    }

}