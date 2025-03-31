package com.example.soccer_week_11;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapter extends FragmentStateAdapter {

        private final List<Fragment> cachedFragments = new ArrayList<>();
        private final List<List<? extends SoccerEntity>> entityTabs = new ArrayList<>();

        public FragmentPagerAdapter(@NonNull FragmentActivity fa) {
            super(fa);
        }

        public <T extends SoccerEntity & Serializable> void addTab(List<T> data) {
            entityTabs.add(new ArrayList<>(data));
            cachedFragments.add(EntityFragment.newInstance(data)); // 预创建Fragment
            notifyItemInserted(entityTabs.size() - 1); // 即时更新视图
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // 复用已创建的Fragment实例
            return cachedFragments.get(position);
        }

        @Override
        public int getItemCount() {
            return entityTabs.size();
        }

        @Override
        public long getItemId(int position) {
            // 通过数据哈希值标识唯一性
            return entityTabs.get(position).hashCode();
        }

        @Override
        public boolean containsItem(long itemId) {
            // 优化缓存查找逻辑
            return cachedFragments.stream()
                    .anyMatch(f -> f.hashCode() == itemId);
        }
    }