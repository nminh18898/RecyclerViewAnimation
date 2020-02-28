package com.nhatminh.example.recyclerviewanimation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nhatminh.example.recyclerviewanimation.R;
import com.nhatminh.example.recyclerviewanimation.model.Person;
import com.nhatminh.example.recyclerviewanimation.presenter.Presenter;
import com.nhatminh.example.recyclerviewanimation.presenter.PresenterImpl;
import com.nhatminh.example.recyclerviewanimation.view.recyclerview.PersonAdapter;
import com.nhatminh.example.recyclerviewanimation.view.recyclerview.SwipeController;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MvpView {

    PersonAdapter adapter;
    RecyclerView rvPerson;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerViewAndAdapter();

        initPresenter();
    }

    private void initRecyclerViewAndAdapter(){
        rvPerson = findViewById(R.id.rvPerson);
        adapter = new PersonAdapter();
        rvPerson.setLayoutManager(new LinearLayoutManager(this));
        rvPerson.setAdapter(adapter);

        SwipeController swipeController = new SwipeController();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(rvPerson);
    }

    private void initPresenter(){
        presenter = new PresenterImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void showData(List<Person> persons) {
        adapter.updateResults(persons);
    }
}
