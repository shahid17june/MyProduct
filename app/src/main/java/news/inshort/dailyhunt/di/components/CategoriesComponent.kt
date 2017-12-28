package news.inshort.dailyhunt.di.components

import dagger.Component
import news.inshort.dailyhunt.di.modules.CategoriesModule
import news.inshort.dailyhunt.di.scope.CustomScope
import news.inshort.dailyhunt.screen.CommonFragment

/**
 * @Created by shahid on 12/18/2017.
 */

@CustomScope
@Component(modules = arrayOf(CategoriesModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface CategoriesComponent {
    fun injectCategories(fragment: CommonFragment)
}
