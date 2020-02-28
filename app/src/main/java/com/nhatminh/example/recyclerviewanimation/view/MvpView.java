package com.nhatminh.example.recyclerviewanimation.view;

import com.nhatminh.example.recyclerviewanimation.model.Person;

import java.util.List;

public interface MvpView {

    void showData(List<Person> persons);
}
