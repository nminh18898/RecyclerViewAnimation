package com.nhatminh.example.recyclerviewanimation.presenter;

import com.nhatminh.example.recyclerviewanimation.model.Person;
import com.nhatminh.example.recyclerviewanimation.view.MvpView;

import java.util.ArrayList;
import java.util.List;

public class PresenterImpl implements Presenter {

    MvpView mvpView;

    @Override
    public void loadData() {
        List<Person> data = getDataFromServer();

        mvpView.showData(data);
    }

    @Override
    public void attachView(MvpView view) {
        this.mvpView = view;
    }

    @Override
    public void detachView() {
        this.mvpView = null;
    }


    private List<Person> getDataFromServer(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("A", 1));
        personList.add(new Person("B", 2));
        personList.add(new Person("C", 3));
        personList.add(new Person("D", 4));
        personList.add(new Person("E", 5));
        personList.add(new Person("F", 6));
        personList.add(new Person("G", 7));
        personList.add(new Person("H", 8));
        personList.add(new Person("I", 9));

        return personList;
    }
}
