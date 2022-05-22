package com.galih.myself.ui;

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
        musicList.add(new MusicData("Hati-Hati Dijalan", "Tulus"));
        musicList.add(new MusicData("Rumah ke Rumah", "Hindia"));
        musicList.add(new MusicData("Bertaut", "Nadin Amizah"));
        musicList.add(new MusicData("Takut", "Idgitaf"));
        musicList.add(new MusicData("Berita Kepada Kawan", "Ebit G. Ade"));
        musicList.add(new MusicData("Secukupnya", "Hindia"));
        musicList.add(new MusicData("Sesuatu Di Jogja", "Adhitia Sofyan"));
        musicList.add(new MusicData("Fana Merah Jambu", "Fourtwnty"));
        musicList.add(new MusicData("Waktu Yang Salah", "Feby Putri, Fiersa Besari"));
        musicList.add(new MusicData("Realita", "Fourtwnty"));

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
