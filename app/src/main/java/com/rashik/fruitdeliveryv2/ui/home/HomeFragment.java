package com.rashik.fruitdeliveryv2.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.rashik.fruitdeliveryv2.R;
import com.rashik.fruitdeliveryv2.databinding.FragmentHomeBinding;
import com.rashik.fruitdeliveryv2.model.FruitShop;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    HomeRecyclerAdapter adapter;
    List<FruitShop> myFruitShop=new ArrayList<>();
    private static final String TAG = "HomeFragment";

    //private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);*/

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView=root.findViewById(R.id.homeRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter=new HomeRecyclerAdapter(myFruitShop);
        recyclerView.setAdapter(adapter);
        GetDataFromFirestore();

        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    private void GetDataFromFirestore() {

        FirebaseFirestore fbdb=FirebaseFirestore.getInstance();
        fbdb.collection("FruitShops").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful())
                {
                    for (DocumentSnapshot documentSnapshot: task.getResult())
                    {
                        FruitShop fruitShop=documentSnapshot.toObject(FruitShop.class);
                        //Toast.makeText(MainActivity.this, fruitShop.getFruitShopName(), Toast.LENGTH_SHORT).show();
                       // Log.e(TAG, "onComplete: "+fruitShop.getFruitShopName() );
                        myFruitShop.add(fruitShop);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}