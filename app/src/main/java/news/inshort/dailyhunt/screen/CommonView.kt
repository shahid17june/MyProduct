package news.inshort.dailyhunt.screen

import news.inshort.dailyhunt.base.BaseView

/**
 * @Created by shahid on 12/28/2017.
 */
interface CommonView : BaseView{
    fun loadCategories(suppose : List<String>)
    fun loader(visibility : Int)
}