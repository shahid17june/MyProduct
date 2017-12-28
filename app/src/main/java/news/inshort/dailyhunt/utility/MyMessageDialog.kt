package news.inshort.dailyhunt.utility

import android.app.Activity
import android.support.v7.app.AlertDialog

/**
 * @Created by shahid on 12/28/2017.
 */

abstract class MyMessageDialog constructor(activity :Activity,title: String , message: String,  setPosButton: String){

    init {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(false)

        builder.setPositiveButton(setPosButton) { dialog, _ ->
            dialogPositiveClicked()
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()
    }

    abstract fun dialogPositiveClicked()


}
