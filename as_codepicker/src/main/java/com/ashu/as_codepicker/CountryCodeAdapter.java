package com.ashu.as_codepicker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.widget.Filter;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.List;

public  class CountryCodeAdapter extends RecyclerView.Adapter<CountryCodeAdapter.MyViewHolder>
implements Filterable{

    List<ModelCountyCode>list;
    List<ModelCountyCode>listFilter;
    Context activity;
    RvClick rvClick;

    public CountryCodeAdapter(List<ModelCountyCode> list, Context activity,RvClick rvClick) {
        this.list = list;
        this.listFilter= list;
        this.activity = activity;
        this.rvClick= rvClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.code_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.title.setText(listFilter.get(position).getName());
        holder.code.setText("+"+listFilter.get(position).getCountryCode());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvClick.onClick(listFilter.get(position).getName(),
                        listFilter.get(position).getCountryCode());
            }
        });

    }


    @Override
    public int getItemCount() {
        return listFilter.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    listFilter = list;

                } else {
                    List<ModelCountyCode> filteredList = new ArrayList<>();
                    for (ModelCountyCode row : list) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getCountryCode().contains(charSequence)) {
                            filteredList.add(row);

                        }
                    }

                    listFilter= filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listFilter= (ArrayList<ModelCountyCode>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, code;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvName);
            code= (TextView) view.findViewById(R.id.tvCode);

        }
    }
}
