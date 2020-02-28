package com.nhatminh.example.recyclerviewanimation.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhatminh.example.recyclerviewanimation.R;
import com.nhatminh.example.recyclerviewanimation.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    List<Person> personList;


    public PersonAdapter() {
        personList = new ArrayList<>();
    }

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new PersonViewHolder(inflater.inflate(R.layout.rv_item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.bind(personList.get(position));
    }

    public void updateResults(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvAge;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
        }

        public void bind(Person person){
            tvName.setText(person.getName());
            tvAge.setText(String.valueOf(person.getAge()));
        }
    }

}
