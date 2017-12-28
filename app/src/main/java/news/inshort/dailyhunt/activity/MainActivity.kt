package news.inshort.dailyhunt.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import news.inshort.dailyhunt.R
import news.inshort.dailyhunt.utility.MyUtility

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        val navigationView = nav_view as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        val menu = navigationView.menu

        //Make click on first navigation option
        menu?.findItem(R.id.nav_camera)?.isChecked = true
        onNavigationItemSelected(menu?.findItem(R.id.nav_camera)!!)
        //val v = navigationView.getHeaderView(0)


        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount > 0) {

                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                toolbar.setNavigationOnClickListener { _ ->
                    MyUtility.hideSoftKeyBoard(this)
                    onBackPressed()
                }
            } else {
                //show hamburger
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                toggle.syncState()
                toolbar.setNavigationOnClickListener { _ ->
                   MyUtility.hideSoftKeyBoard(this)
                    drawer_layout.openDrawer(GravityCompat.START)
                }
            }
        }



    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
               // MyUtility.navigateTo(this, ListFragment(), "TEXT", false)
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
