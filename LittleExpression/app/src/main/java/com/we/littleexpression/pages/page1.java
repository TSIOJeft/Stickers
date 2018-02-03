package com.we.littleexpression.pages;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.we.littleexpression.R;
import com.we.littleexpression.adapter.RecyclerviewAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Fan on 2018/2/1.
 */

public class page1 extends Fragment {
    private ArrayList<BitmapDrawable>data=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.expression,container,false);
        final RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        RecyclerviewAdapter adapter=new RecyclerviewAdapter(getContext(),data);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),5);
        recyclerView.setLayoutManager(layoutManager);
        new Thread() {
            @Override
            public void run() {
                getAssetsImage();
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        DiffUtil.calculateDiff(new DiffUtil.Callback() {
                            @Override
                            public int getOldListSize() {
                                return data.size();
                            }

                            @Override
                            public int getNewListSize() {
                                return data.size();
                            }

                            @Override
                            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                                return false;
                            }

                            @Override
                            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                                return false;
                            }
                        }).dispatchUpdatesTo(recyclerView.getAdapter());
                    }
                });
            }
        }.start();
        adapter.setOnRecyclerViewClickListener(new RecyclerviewAdapter.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(View view, int p) {
new MaterialDialog(getActivity())
        .setBackground(data.get(p))
        .setNegativeButton("share", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        })
        .show();
            }

            @Override
            public void OnItemLongClick(View v, int p) {

            }
        });
        return view;
    }
    private boolean getAssetsImage() {
        Context context = getContext();
        if (context != null&&data.isEmpty()) {
            try {
                AssetManager assets = context.getAssets();
                String[] xhhs = assets.list("xhh");
                for (String xhh : xhhs) {
                    InputStream image = assets.open("xhh/" + xhh);
                    data.add(new BitmapDrawable(context.getResources(), image));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
