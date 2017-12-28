package news.inshort.dailyhunt.di.components

import com.google.gson.Gson
import dagger.Component
import news.inshort.dailyhunt.application.MyApplication
import news.inshort.dailyhunt.di.modules.ApplicationModule
import news.inshort.dailyhunt.network.RetrofitApi
import javax.inject.Singleton

/**
 * @Created by shahid on 12/28/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent{

    fun getContext() : MyApplication

    fun getRetrofitApiService() : RetrofitApi

    fun getGsonObject() :Gson

}