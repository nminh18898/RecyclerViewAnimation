package com.nhatminh.example.recyclerviewanimation.presenter;

import com.nhatminh.example.recyclerviewanimation.model.Person;
import com.nhatminh.example.recyclerviewanimation.view.MvpView;

import java.util.List;

public interface Presenter {

    void loadData();

    void attachView(MvpView view);
    void detachView();

}
