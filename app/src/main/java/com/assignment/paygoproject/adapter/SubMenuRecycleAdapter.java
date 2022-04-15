package com.assignment.paygoproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.assignment.paygoproject.R;
import com.assignment.paygoproject.object.Data;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SubMenuRecycleAdapter extends RecyclerView.Adapter<SubMenuRecycleAdapter.ViewHolder> {

    private ArrayList<Data> dataArrayList;
    Context context ;
    public interface OnSubMenuClick{
        void onSubMenuClick(int Position);
    }

    private  OnSubMenuClick onSubMenuClick;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView ServiceName;
        private final ImageView Icon;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            ServiceName = (TextView) view.findViewById(R.id.ServiceName);
            Icon = (ImageView) view.findViewById(R.id.Icon);
        }

        public TextView getTextView() {
            return ServiceName;
        }

        public TextView getImageView() {
            return ServiceName;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public SubMenuRecycleAdapter(ArrayList<Data> dataSet, Context context,OnSubMenuClick onSubMenuClick) {
        dataArrayList = dataSet;
        this.context =context;
        this.onSubMenuClick = onSubMenuClick;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sub_menu_recycle_view, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(dataArrayList.get(position).getServiceName());

        Glide.with(context)
                .load(dataArrayList.get(position).getIconName())
                .into(viewHolder.Icon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubMenuClick.onSubMenuClick(position);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }
}

