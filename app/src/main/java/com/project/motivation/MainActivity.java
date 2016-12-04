package com.project.motivation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.project.motivation.Favorite.FavotiteFragment;
import com.project.motivation.Motivation.MotivationFragment;
import com.project.motivation.Settings.SettingsFragment;
import com.project.motivation.mvp.common.MvpAppCompatActivity;


import static com.ashokvarma.bottomnavigation.BottomNavigationBar.OnTabSelectedListener;

public class MainActivity extends MvpAppCompatActivity implements OnTabSelectedListener {
    private static final String STATE_CURRENT_TAB_ID = "current_tab_id";
    private static final int MAIN_TAB_ID = 0;
    private BottomNavigationBar bottomNavBar;
    private Fragment curFragment;
    private int curTabId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpBottomNavBar();
        if (savedInstanceState == null) {
            bottomNavBar.selectTab(MAIN_TAB_ID, false);
            showFragment(rootTabFragment(MAIN_TAB_ID));
        }
    }
    private void setUpBottomNavBar() {
        bottomNavBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation);
        bottomNavBar
                .addItem(new BottomNavigationItem(R.drawable.ic_timeline_green_600_24dp, R.string.country))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_green_600_24dp, R.string.favorites))
                .addItem(new BottomNavigationItem(R.drawable.ic_settings_green_600_24dp, R.string.settings))
                .initialise();
        bottomNavBar.setTabSelectedListener(this);
    }
    @NonNull
    private Fragment rootTabFragment(int tabId) {
        switch (tabId) {
            case 0:
                return new MotivationFragment();
            case 1:
                return new FavotiteFragment();
            case 2:
                return new SettingsFragment();
            default:
                throw new IllegalArgumentException();
        }
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        curFragment = getFragmentManager().findFragmentById(R.id.content);
        curTabId = savedInstanceState.getInt(STATE_CURRENT_TAB_ID);
        bottomNavBar.selectTab(curTabId, false);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_CURRENT_TAB_ID, curTabId);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onBackPressed() {
        Pair<Integer, Fragment> pair = popFragmentFromBackStack();
        if (pair != null) {
            backTo(pair.first, pair.second);
        } else {
            super.onBackPressed();
        }
    }

    public void showFragment(@NonNull Fragment fragment, boolean addToBackStack) {
        if (curFragment != null && addToBackStack) {
            pushFragmentToBackStack(curTabId, curFragment);
        }
        replaceFragment(fragment);
    }

    private void backTo(int tabId, @NonNull Fragment fragment) {
        if (tabId != curTabId) {
            curTabId = tabId;
            bottomNavBar.selectTab(curTabId, false);
        }
        replaceFragment(fragment);
        getSupportFragmentManager().executePendingTransactions();
    }

    private void backToRoot() {
        if (isRootTabFragment(curFragment, curTabId)) {
            return;
        }
        resetBackStackToRoot(curTabId);
        Fragment rootFragment = popFragmentFromBackStack(curTabId);
        assert rootFragment != null;
        backTo(curTabId, rootFragment);
    }

    private boolean isRootTabFragment(@NonNull Fragment fragment, int tabId) {
        return fragment.getClass() == rootTabFragment(tabId).getClass();
    }

    private void replaceFragment(@NonNull Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.replace(R.id.content, fragment);
        tr.commitAllowingStateLoss();
        curFragment = fragment;
    }

    @Override
    public void onTabSelected(int position) {
        if (curFragment != null) {
            pushFragmentToBackStack(curTabId, curFragment);
        }
        curTabId = position;
        Fragment fragment = popFragmentFromBackStack(curTabId);
        if (fragment == null) {
            fragment = rootTabFragment(curTabId);
        }
        replaceFragment(fragment);
    }

    @Override
    public void onTabUnselected(int position) {


    }

    @Override
    public void onTabReselected(int position) {
        backToRoot();
    }
    public void showFragment( @NonNull Fragment fragment) {
        showFragment(fragment, true);
    }
}
