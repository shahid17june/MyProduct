package news.inshort.dailyhunt.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.progressbar.*
import news.inshort.dailyhunt.utility.Constants
import news.inshort.dailyhunt.utility.MyUtility

/**
 * @Created by shahid on 12/28/2017.
 */
abstract class BaseFragment : Fragment() {
    private var my_view: View? = null
    private var actionBar: ActionBar? = null
    private var myActivity: Activity? = null
    private var isFragmentExists: Boolean = false
    private var text: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myActivity = activity
        actionBar = MyUtility.setUpActionBar(myActivity)
        isFragmentExists = true

        val bundle = arguments
        text = bundle?.getString(Constants.COMING_FROM)
        setHasOptionsMenu(true)

        resolveDependency()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (my_view == null) {
            my_view = inflater.inflate(setLayoutResource(), container, false)
        }
        return my_view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isFragmentExists) {
            viewIsReady()
        }
    }

    override fun onResume() {
        super.onResume()
        setFragmentTitle(actionBar, text)
    }

    protected fun showHideLoader(visibilty : Int){
       avi?.visibility = visibilty
    }


    protected abstract fun setLayoutResource(): Int
    protected abstract fun viewIsReady()
    protected abstract fun setFragmentTitle(actionBar: ActionBar?, text : String?)
    protected abstract fun resolveDependency()

}