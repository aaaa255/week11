package com.example.soccer_week_11;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EntityFragment<T extends SoccerEntity> extends Fragment {

    private static final String ARG_DATA = "entity_list";

    private List<T> originalList;
    private GenericAdapter<T> adapter;

    @SuppressWarnings("unchecked")
    public static EntityFragment<?> newInstance(List<? extends SoccerEntity> data) {
        EntityFragment<?> fragment = new EntityFragment<>();
        Bundle args = new Bundle();
        ArrayList<Serializable> serializableList = new ArrayList<>();
        for (SoccerEntity item : data) {
            serializableList.add((Serializable) item);
        }
        args.putSerializable(ARG_DATA, serializableList);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressWarnings("unchecked")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entity, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        EditText searchBar = view.findViewById(R.id.search_bar);

        // Safely cast the serialized list
        originalList = (List<T>) getArguments().getSerializable(ARG_DATA);

        adapter = new GenericAdapter<>(originalList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Sort list alphabetically
        originalList.sort(Comparator.comparing(SoccerEntity::getDisplayName));

        // Lambda search
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase();
                List<T> filtered = originalList.stream()
                        .filter(e -> e.getDisplayName().toLowerCase().contains(query))
                        .collect(Collectors.toList());
                adapter.updateList(filtered);
            }
            @Override public void afterTextChanged(Editable s) {}
        });

        return view;
    }
}