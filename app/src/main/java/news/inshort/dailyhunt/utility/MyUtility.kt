package news.inshort.dailyhunt.utility

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import news.inshort.dailyhunt.R

/**
 * @Created by shahid on 12/28/2017.
 */
class MyUtility{

    companion object {
        fun navigateTo(activity: FragmentActivity, mFragment: Fragment, TAG: String, isBackStack: Boolean) {
            val fragmentManager = activity.supportFragmentManager.beginTransaction()
            //enter, exit, pop-enter, pop-exit
            //fragmentManager.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
            fragmentManager.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

            if (isBackStack)
                fragmentManager.addToBackStack(null)

            fragmentManager.replace(R.id.content, mFragment, TAG).commit()
        }


        fun setUpActionBar(activity: Activity?): ActionBar? {
            var actionBar: ActionBar? = null
            if (activity != null) {
                actionBar = (activity as AppCompatActivity).supportActionBar
            }
            return actionBar
        }

        fun hideSoftKeyBoard(activity: FragmentActivity?) {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            if (imm.isAcceptingText && activity.currentFocus != null) { // verify if the soft keyboard is open
                imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
            }
        }

    }
}