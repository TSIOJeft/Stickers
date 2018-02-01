package com.we.littleexpression.pages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.we.littleexpression.R;
import com.we.littleexpression.adapter.RecyclerviewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fan on 2018/2/1.
 */

public class page1 extends Fragment {
    private ArrayList<Map<String,Object>>data=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.expression,container,false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        RecyclerviewAdapter adapter=new RecyclerviewAdapter(getContext(),data);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        for(int i=0;i<20;i++){
            HashMap<String,Object>item=new HashMap<>();
            item.put("test","test");
            data.add(item);
        }
        return view;
    }
}
