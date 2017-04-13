package demo.testlu.lumyapplication.View;


import java.util.List;

import demo.testlu.lumyapplication.activity.BaseLazyFragment;
import demo.testlu.lumyapplication.utils.NavigationEntity;

public interface HomeView {

    void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList);

}
