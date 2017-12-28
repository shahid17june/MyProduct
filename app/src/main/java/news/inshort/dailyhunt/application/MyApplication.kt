package news.inshort.dailyhunt.application

import android.app.Application
import news.inshort.dailyhunt.di.components.ApplicationComponent
import news.inshort.dailyhunt.di.components.DaggerApplicationComponent
import news.inshort.dailyhunt.di.modules.ApplicationModule


/**
 * @Created by shahid on 12/28/2017.
 */
class MyApplication : Application() {

    companion object {
       lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        resolveDependency()

    }

    private fun resolveDependency() {
        applicationComponent =
                DaggerApplicationComponent.builder()
                        .applicationModule(ApplicationModule(this))
                        .build()
    }

}