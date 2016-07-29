package ua.dashan.caloriya;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class ExerciseFragment extends Fragment implements RecyclerViewOnClickListener {
    private RecyclerView recyclerView;
    private List<Exercise> eList;
    Snackbar s;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_exercise,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.rv_list);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
                                                   @Override
                                                   public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                                       super.onScrollStateChanged(recyclerView, newState);
                                                   }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                 //если список заканчивается тогда добавляются новые элементы при прокручивании
               /* LinearLayoutManager llm = (LinearLayoutManager)recyclerView.getLayoutManager();
                ExerciseAdapter adapter = (ExerciseAdapter)recyclerView.getAdapter();
                if(eList.size()==llm.findLastCompletelyVisibleItemPosition()+1){
                    List<Exercise> exerciseList =((DetailMan)getActivity()).getSetExerciseList(10);
                    for(int i = 0;i<exerciseList.size();i++){
                        adapter.addListItem(exerciseList.get(i),eList.size());
                    }
                }
*/


                                                   }
                                               });
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

            eList = ((DetailMan)getActivity()).getSetExerciseList();
        ExerciseAdapter adapter =new ExerciseAdapter(getActivity(),eList);
        recyclerView.setAdapter(adapter);
        adapter.setRecyclerViewOnClickListener(this);

        return v;
    }

    @Override
    //обработка нажатия
    public void OnclickListener(View view, int position) {
       /* s.make(view, "Вы выбрали "+ position , Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();*/
        Intent intent=new Intent(getActivity(),DetailExercise.class);
        intent.putExtra("position",position);
        getActivity().startActivity(intent);
    }
}
