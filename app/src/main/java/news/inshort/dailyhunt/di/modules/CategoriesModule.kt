package news.inshort.dailyhunt.di.modules


import dagger.Module
import dagger.Provides
import news.inshort.dailyhunt.di.scope.CustomScope
import news.inshort.dailyhunt.screen.CommonView

/**
 * @Created by shahid on 12/28/2017.
 */
@Module
class CategoriesModule constructor(val mView: CommonView) {

    @Provides
    @CustomScope
    fun provideView(): CommonView = mView

}
