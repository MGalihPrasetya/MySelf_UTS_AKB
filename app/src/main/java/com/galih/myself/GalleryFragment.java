package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galih.myself.GalleryAdapter;
import com.galih.myself.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private ArrayList<Integer> list;
    RecyclerView recyclerView;
    GalleryAdapter galleryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        list = new ArrayList<Integer>();
        list.add(R.drawable.photo1);
        list.add(R.drawable.photo2);
        list.add(R.drawable.photo3);
        list.add(R.drawable.photo4);
        list.add(R.drawable.photo5);
        list.add(R.drawable.photo6);
        list.add(R.drawable.photo7);
        list.add(R.drawable.photo8);

        recyclerView = view.findViewById(R.id.recycler_gallery);
        galleryAdapter = new GalleryAdapter(getActivity(), list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(galleryAdapter);
        return view;
    }
}
