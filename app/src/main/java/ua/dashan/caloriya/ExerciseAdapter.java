package ua.dashan.caloriya;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder> {
    private List<Exercise> eList;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;
    public ExerciseAdapter(Context c,List<Exercise>l){
        eList=l;
        layoutInflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }





    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v =layoutInflater.inflate(R.layout.item_card2,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.name.setText(eList.get(position).getName());
    holder.description.setText(eList.get(position).getDescription());
        holder.image.setImageResource(eList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return eList.size();
    }
    //метод для добавления элементов
  /*  public void addListItem(Exercise e ,int pos){
        eList.add(e);
        notifyItemInserted(pos);
    }*/
public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r){
    recyclerViewOnClickListener=r;
}
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;
        public TextView name;
        public TextView description;
      public MyViewHolder(View itemView) {
          super(itemView);
          image=(ImageView)itemView.findViewById(R.id.iv_exercise);
          name=(TextView)itemView.findViewById(R.id.tv_name);
          description=(TextView)itemView.findViewById(R.id.tv_description);
          itemView.setOnClickListener(this);
      }

        @Override
        public void onClick(View v) {
  if(recyclerViewOnClickListener !=null){
      recyclerViewOnClickListener.OnclickListener(v,getPosition());
  }
        }
    }
}