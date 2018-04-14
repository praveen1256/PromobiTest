package com.promobi.promobitest.mvp;

import com.promobi.promobitest.api.NyTimesApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Praveen on 12-04-2018.
 */

public class TopStoryPresenter implements ITopStoryPresenter {
    protected CompositeDisposable compositeDisposable;
    private NyTimesApi nyTimesApi;
    private ITopStoryView view;

    public TopStoryPresenter(ITopStoryView view, NyTimesApi nyTimesApi) {
        compositeDisposable = new CompositeDisposable();
        this.nyTimesApi = nyTimesApi;
        this.view = view;
    }

    public void fetchStories() {
        compositeDisposable.add(nyTimesApi.getStories()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(storyResponse -> view.load(storyResponse.results()),
                        throwable -> view.error(throwable)));
    }

    public void clearSubscriptions() {
        compositeDisposable.clear();
    }
}