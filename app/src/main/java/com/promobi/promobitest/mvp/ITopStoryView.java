package com.promobi.promobitest.mvp;



import com.promobi.promobitest.mvp.model.StoryItem;

import java.util.List;

public interface ITopStoryView {

    void load(List<StoryItem> items);

    void error(Throwable e);

    void error();

}
