package com.home.apostasjl.model;

import com.home.apostasjl.interf.MVP;

/**
 * Created by Artur on 09/01/2018.
 */

public class ActMainM implements MVP.ModelImpl{


    private MVP.PresenterImpl presenter;


    public ActMainM (MVP.PresenterImpl presenter){
        this.presenter = presenter;
    }

}
