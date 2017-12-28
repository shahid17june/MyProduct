package news.inshort.dailyhunt.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @Created by shahid on 12/28/2017.
 */

open class BasePresenter <V : BaseView> {

   @Inject open lateinit var mView : V

    protected fun <T> subscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}