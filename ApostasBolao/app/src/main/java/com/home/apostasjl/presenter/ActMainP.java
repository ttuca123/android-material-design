package com.home.apostasjl.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TabHost;

import com.home.apostasjl.interf.MVP;
import com.home.apostasjl.model.ActMainM;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import fragments.FrgHome;

/**
 * Created by Artur on 09/01/2018.
 */

public class ActMainP implements MVP.PresenterImpl {


    private TabHost mTabHost;
    private MVP.ModelImpl model;
    private MVP.ViewImpl view;
    private Bundle savedInstance;


    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, ActMainP.TabInfo>();
    private PagerAdapter mPagerAdapter;
    private int tabAtual=0;

    // Informação da Tab
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

    // Um simples factory que retorna View para o TabHost
    class TabFactory implements TabHost.TabContentFactory {

        private final Context mContext;

        public TabFactory(Context context) {
            mContext = context;
        }

        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }

    public ActMainP( ){
        model = new ActMainM(this);
    }


    @Override
    public Context getContext() {
        return (Context) view;
    }



    @Override
    public void setView(MVP.ViewImpl view, Bundle savedInstance) {
        this.view = view;



    }



    @Override
    public List<Fragment> getFragmentos() {

        List<Fragment> fragments = new Vector<Fragment>();

        fragments.add(Fragment.instantiate(getContext(), FrgHome.class.getName()));
        fragments.add(Fragment.instantiate(getContext(), FrgHome.class.getName()));

        return fragments;
    }

    @Override
    public void carregarDados() {

    }

    @Override
    public void irParaActivitySobre() {

    }



}
