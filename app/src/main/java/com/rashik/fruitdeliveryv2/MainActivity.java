package com.rashik.fruitdeliveryv2;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.rashik.fruitdeliveryv2.databinding.ActivityMainBinding;
import com.rashik.fruitdeliveryv2.model.DataController;
import com.rashik.fruitdeliveryv2.model.FruitShop;
import com.rashik.fruitdeliveryv2.model.FruitShopInterface;
import com.rashik.fruitdeliveryv2.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FruitShopInterface {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    FruitShopInterface fruitShopInterface;
    DataController dataController;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        fruitShopInterface=this;
        dataController=DataController.getInstance();
        dataController.setFruitShopInterface(fruitShopInterface);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //SendDataToFirestore();

        //GetDataFromFirestore();
    }

    @Override
    public void onFruitShopClick(FruitShop fruitShop) {

        dataController.setCurrentMenuItemList(fruitShop.getFruitShopMenuList());
        navController.navigate(R.id.action_navigation_home_to_navigation_menu2);

    }



    private void SendDataToFirestore() {

        FirebaseFirestore fbdb=FirebaseFirestore.getInstance();
        CollectionReference reference= fbdb.collection("FruitShops");

        FruitShop myFruitshop=new FruitShop();
        myFruitshop.setFruitShopName("Sabbirs FruitStore");
        myFruitshop.setFruitShopDescription("The Biggest FruitShop in Dhaka");
        myFruitshop.setFruitShopLocation("Dhanmondi, Dhaka");
        myFruitshop.setFruitShopImageUrl("https://images.all-free-download.com/images/graphiclarge/fruits_orange_citrus_fruits_215459.jpg");

        List<MenuItem> myMenu=new ArrayList<>();
        for(int i=1;i<15;i++)
        {
            myMenu.add(new MenuItem("Apple","Ïmported fron Indonesia",499));
        }
        myFruitshop.setFruitShopMenuList(myMenu);

        reference.add(myFruitshop).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Store Uploaded", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Sorry,Not Uploaded", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}