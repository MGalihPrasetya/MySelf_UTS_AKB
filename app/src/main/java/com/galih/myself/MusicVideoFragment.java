package com.galih.myself;

/*21 Mei 2022*/
/*10119175*/
/*Mochamad Galih Prasetya*/
/*IF-5*/

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.galih.myself.MusicData;
import com.galih.myself.MusicVideoAdapter;
import com.galih.myself.R;

import java.util.ArrayList;
import java.util.List;


public class MusicVideoFragment extends Fragment {
    RecyclerView recyclerMusic;
    MusicVideoAdapter musicVideoAdapter;

    List<MusicData> musicList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_music, container, false);

        musicList = new ArrayList<MusicData>();
        musicList.add(new MusicData("Cancer", "My Chemical Romance"));
        musicList.add(new MusicData("Lay All Your Love", "ABBA"));
        musicList.add(new MusicData("In A Rush", "BlackStreet"));
        musicList.add(new MusicData("Mama", "Clean Bandit"));
        musicList.add(new MusicData("Creep", "Radio Head"));
        musicList.add(new MusicData("Angel Baby", "Troye Sian"));
        musicList.add(new MusicData("Little Dark Age", "MGMT"));
        musicList.add(new MusicData("RIP Love", "Faouzia"));
        musicList.add(new MusicData("Nuestra Cancion", "Monsieur Perine"));
        musicList.add(new MusicData("Cinta Sampai Mati", "Raffa Affar"));

        recyclerMusic = (RecyclerView) view.findViewById(R.id.recycler_music);
        musicVideoAdapter = new MusicVideoAdapter(musicList);

        // video
        VideoView vvVideo = view.findViewById(R.id.vv_video);
        String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        vvVideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(getContext());
        vvVideo.setMediaController(mediaController);
        mediaController.setAnchorView(vvVideo);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        recyclerMusic.setLayoutManager(layoutManager2);
        recyclerMusic.setAdapter(musicVideoAdapter);

        return view;
    }
}
