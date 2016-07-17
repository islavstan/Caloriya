package ua.dashan.caloriya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TabFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_2, container, false);
    }
    @Override
    //метод для смены цвета таба, здесь передаём значение 2 в MainActivity, там есть метод который принимает эту двойку
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
        {
            ColorChangeInterface colorChangeInterface = (ColorChangeInterface) getActivity();
            colorChangeInterface.setToolbarAndTabColor(2);
        }
    }
}

