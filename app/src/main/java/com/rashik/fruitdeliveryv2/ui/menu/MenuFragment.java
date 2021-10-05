package com.rashik.fruitdeliveryv2.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rashik.fruitdeliveryv2.R;
import com.rashik.fruitdeliveryv2.model.DataController;
import com.rashik.fruitdeliveryv2.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    View root;
    RecyclerView recyclerView;
    MenuAdapter adapter;
    List<MenuItem> myMenu=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        root=inflater.inflate(R.layout.fragment_menu,container,false);
        recyclerView=root.findViewById(R.id.menuRecycler);

        myMenu= DataController.instance.getCurrentMenuItemList();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter=new MenuAdapter(myMenu);
        recyclerView.setAdapter(adapter);

        return root;
    }
}
