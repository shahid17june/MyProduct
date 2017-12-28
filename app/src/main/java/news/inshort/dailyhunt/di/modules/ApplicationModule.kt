package news.inshort.dailyhunt.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import news.inshort.dailyhunt.application.MyApplication
import news.inshort.dailyhunt.network.RetrofitApi
import news.inshort.dailyhunt.utility.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Created by shahid on 12/28/2017.
 */

@Module
class ApplicationModule(val mContext : MyApplication) {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create(getGsonInstance())

    @Provides
    @Singleton
    fun getGsonInstance(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(converterFactory: GsonConverterFactory, adapterFactory: RxJava2CallAdapterFactory): Retrofit =
         Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): RetrofitApi = retrofit.create(RetrofitApi::class.java)

    @Provides
    @Singleton
    fun provideContext(): MyApplication = mContext

}