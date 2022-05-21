package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.galih.myself.DailyAdapter;
import com.galih.myself.DailyData;
import com.galih.myself.FriendAdapter;
import com.galih.myself.R;

import java.util.ArrayList;
import java.util.List;

public class DailyFragment extends Fragment {

    RecyclerView recyclerFriend;
    FriendAdapter friendAdapter;

    RecyclerView recyclerDaily;
    DailyAdapter dailyAdapter;

    List<Integer> imageList;
    List<String> nameList;

    List<DailyData> dailyList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.friend_1);
        imageList.add(R.drawable.friend_2);
        imageList.add(R.drawable.friend_3);
        imageList.add(R.drawable.friend_4);
        imageList.add(R.drawable.friend_5);
        imageList.add(R.drawable.friend_6);
        imageList.add(R.drawable.friend_7);

        nameList = new ArrayList<String>();
        nameList.add("Galih");
        nameList.add("Jafar");
        nameList.add("Riswan");
        nameList.add("Rahman");
        nameList.add("Ilman");
        nameList.add("Yolanda");
        nameList.add("Andi");

        dailyList = new ArrayList<DailyData>();
        dailyList.add(new DailyData(R.drawable.ic_baseline_school_24, "Kuliah", "Berkuliah secara daring dan luring"));
        dailyList.add(new DailyData(R.drawable.ic_baseline_code_24, "Ngoding", "Ngulik berbagai hal tentang mobile apps dan mengerjakan proyek unikom"));
        dailyList.add(new DailyData(R.drawable.ic_baseline_local_movies_24, "Nonton", "Nonton movie, youtube dan drama"));
        dailyList.add(new DailyData(R.drawable.ic_baseline_queue_music_24, "Dengerin Musik", "Mendengarkan musik random"));
        dailyList.add(new DailyData(R.drawable.ic_baseline_article_24, "Baca Artikel", "Baca berita kompas, dan forum tanya jawab quora"));

        recyclerFriend = (RecyclerView) view.findViewById(R.id.recycler_friend);
        friendAdapter = new FriendAdapter(getActivity(), nameList, imageList);

        recyclerDaily = (RecyclerView) view.findViewById(R.id.recycler_daily);
        dailyAdapter = new DailyAdapter(dailyList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerFriend.setLayoutManager(layoutManager);
        recyclerFriend.setAdapter(friendAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        recyclerDaily.setLayoutManager(layoutManager2);
        recyclerDaily.setAdapter(dailyAdapter);

        return view;
    }
}
