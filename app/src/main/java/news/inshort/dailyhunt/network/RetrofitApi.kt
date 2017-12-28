package news.inshort.dailyhunt.network

import retrofit2.http.GET
import io.reactivex.Observable

/**
 * @Created by shahid on 12/28/2017.
 */
interface RetrofitApi {

    @GET("")
    fun getListOfStrings() : Observable<List<String>>
}