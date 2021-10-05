package com.rashik.fruitdeliveryv2.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rashik.fruitdeliveryv2.R;
import com.rashik.fruitdeliveryv2.databinding.FragmentDashboardBinding;
import com.squareup.picasso.Picasso;

public class DashboardFragment extends Fragment {


    FirebaseUser user;
    ImageView userImageView;
    TextView userName,userEmail;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        userImageView=root.findViewById(R.id.userImageView);
        userName=root.findViewById(R.id.userNameTextView);
        userEmail=root.findViewById(R.id.userEmailTextView);



        user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            //userImageView.setImageURI(user.getPhotoUrl());
            Picasso.get().load(user.getPhotoUrl()).fit().into(userImageView);
            userName.setText("Name: "+user.getDisplayName());
            userEmail.setText("Email: "+user.getEmail());
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}