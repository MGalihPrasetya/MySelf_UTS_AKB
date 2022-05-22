package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WalkthroughActivity extends AppCompatActivity {
    private WalkthroughAdapter walkthroughAdapter;
    private LinearLayout linlayIndicatorWalkthrough;
    private Button btnActionWalkthrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_walkthrough);

        linlayIndicatorWalkthrough = findViewById(R.id.linlay_indicator_walkthrough);
        btnActionWalkthrough = findViewById(R.id.btn_action_walkthrough);

        setupWalkthroughItems();

        final ViewPager2 viewpagerWalkthrough = findViewById(R.id.viewpager_walkthrough);
        viewpagerWalkthrough.setAdapter(walkthroughAdapter);

        setupIndicatorWalkthrough();
        setCurrentIndicatorWalkthrough(0);

        viewpagerWalkthrough.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicatorWalkthrough(position);
            }
        });

        btnActionWalkthrough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewpagerWalkthrough.getCurrentItem() + 1 < walkthroughAdapter.getItemCount()) {
                    viewpagerWalkthrough.setCurrentItem(viewpagerWalkthrough.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupWalkthroughItems() {
        List<WalkthroughData> walkthroughModels = new ArrayList<>();

        WalkthroughData itemWalkthrough1 = new WalkthroughData();
        itemWalkthrough1.setTitle("Hello!");
        itemWalkthrough1.setSubtitle("Welcome to Myself Is Galih");
        itemWalkthrough1.setImage(R.drawable.walkthrough1);

        WalkthroughData itemWalkthrough2 = new WalkthroughData();
        itemWalkthrough2.setTitle("Profile, Activity, Gallery, Music & Video");
        itemWalkthrough2.setSubtitle("You can find my profile, my daily activity, my gallery, my music, and my video of interest here!");
        itemWalkthrough2.setImage(R.drawable.walkthrough2);

        WalkthroughData itemWalkthrough3 = new WalkthroughData();
        itemWalkthrough3.setTitle("Let's Go!");
        itemWalkthrough3.setSubtitle("You also can contact me through all of my social media listed here.");
        itemWalkthrough3.setImage(R.drawable.walkthrough3);

        walkthroughModels.add(itemWalkthrough1);
        walkthroughModels.add(itemWalkthrough2);
        walkthroughModels.add(itemWalkthrough3);

        walkthroughAdapter = new WalkthroughAdapter(walkthroughModels);
    }

    private void setupIndicatorWalkthrough() {
        ImageView[] indicator = new ImageView[walkthroughAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0, 8,0);
        for (int i = 0; i < indicator.length; i++) {
            indicator[i] = new ImageView(getApplicationContext());
            indicator[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.walkthrough_inactive
            ));
            indicator[i].setLayoutParams(layoutParams);
            linlayIndicatorWalkthrough.addView(indicator[i]);
        }
    }

    private void setCurrentIndicatorWalkthrough(int index) {
        int childCount = linlayIndicatorWalkthrough.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView)linlayIndicatorWalkthrough.getChildAt(i);
            if(i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.walkthrough_active)
                );
            }else{
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.walkthrough_inactive)
                );
            }
        }
        if (index == walkthroughAdapter.getItemCount() - 1) {
            btnActionWalkthrough.setText("Enter");
        }else
            btnActionWalkthrough.setText("Next");
    }
}