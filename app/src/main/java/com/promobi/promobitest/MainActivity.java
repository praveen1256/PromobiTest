package com.promobi.promobitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.promobi.promobitest.adapter.TopStoryAdapter;
import com.promobi.promobitest.api.ImageDownloader;
import com.promobi.promobitest.api.NyTimesApi;
import com.promobi.promobitest.mvp.ITopStoryPresenter;
import com.promobi.promobitest.mvp.ITopStoryView;
import com.promobi.promobitest.mvp.TopStoryPresenter;
import com.promobi.promobitest.mvp.model.StoryItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ITopStoryView {


    @Bind(R.id.recycler_view)
    RecyclerView recycler_view;

    private TopStoryAdapter topStoryAdapter;
    ITopStoryPresenter iTopStoryPresenter;

    @Inject
    NyTimesApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ProMobiApplication.getComponent().inject(this);
        iTopStoryPresenter = new TopStoryPresenter(this, service);
        iTopStoryPresenter.fetchStories();
    }

    @Inject
    ImageDownloader imageDownloader;

    @Override
    public void load(List<StoryItem> items) {
        topStoryAdapter = new TopStoryAdapter(items,imageDownloader);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(topStoryAdapter);

        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void error(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void error() {

    }
}
