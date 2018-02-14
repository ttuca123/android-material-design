package com.home.apostasjl.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

import com.home.apostasjl.R;
import com.home.apostasjl.interf.MVP;
import com.home.apostasjl.presenter.ActMainP;

import java.util.HashMap;

import fragments.FrgAposta;
import fragments.FrgConta;
import fragments.FrgContato;
import fragments.FrgHome;
import fragments.FrgRegra;

public class ActMainV extends AppCompatActivity
        implements  MVP.ViewImpl , NavigationView.OnNavigationItemSelectedListener, FrgHome.OnFragmentInteractionListener
        , FrgContato.OnFragmentInteractionListener, FrgConta.OnFragmentInteractionListener
        , FrgRegra.OnFragmentInteractionListener, FrgAposta.OnFragmentInteractionListener{

        FrgHome frgHome;
        FrgAposta frgAposta;
        FrgContato frgContato;
        FrgConta frgConta;
        FrgRegra frgRegra;

        private static MVP.PresenterImpl presenter;

        Toolbar toolbar;

        private TabHost mTabHost;
        private ViewPager mViewPager;
        private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, ActMainV.TabInfo>();
        private PagerAdapter mPagerAdapter;
        private int tabAtual=0;
        private MenuInflater menuInflater;
        private Menu menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);



            if (presenter == null) {

                presenter = new ActMainP();
            }

            presenter.setView(this, savedInstanceState);

            toolbar = (Toolbar) findViewById(R.id.toolbar);

            setSupportActionBar(toolbar);

            inicializarNavigationDrawer();

            inicializarElementos();


    }



    private void inicializarNavigationDrawer(){

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
    }



    private void inicializarElementos(){
        frgHome = new FrgHome(presenter);
        frgContato = new FrgContato();
        frgConta = new FrgConta();
        frgRegra = new FrgRegra();
        frgAposta = new FrgAposta(presenter);

        irParaFragmento(frgHome);

    }

   private void irParaFragmento(Fragment fragmento){

       android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
       android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.frmAcao, fragmento);
       fragmentTransaction.commit();
       fragmentTransaction.attach(fragmento);
   }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_home:
                irParaFragmento(frgHome);
                break;
            case R.id.nav_apostas:

                irParaFragmento(frgAposta);
                break;
            case R.id.nav_regras:

                irParaFragmento(frgRegra);
                break;
            case R.id.nav_contas:

                irParaFragmento(frgConta);
                break;
            case R.id.nav_fale_conosco:

                irParaFragmento(frgContato);
                break;
        }

        fecharDrawer();

        return true;
    }

    private void fecharDrawer(){

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void inicializarViewPage() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String s) {

    }

    public class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }
    }




}
