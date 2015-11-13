package com.rfsoftlab.jakir.swipe_to_refresh_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jakir Hossain
 * @version 1.3.0
 * @desc description of the class
 * @link n/a
 * @created on 13-Nov-15
 * @updated on
 * @modified by
 * @updated on
 * @since 1.0
 */
public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.Holder> {

    private Context mContext;
    List<String> mPersonsName;

    public PersonsAdapter(Context mContext) {
        this.mContext = mContext;
        randomizeNames();
    }

    private void randomizeNames() {
        mPersonsName= Arrays.asList(getPersonNames());
        Collections.shuffle(mPersonsName);
    }

    private String[] getPersonNames() {
        return mContext.getResources().getStringArray(R.array.person_names);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflateView= LayoutInflater.from(mContext).inflate(R.layout.person_name,viewGroup,false);
        return new Holder(inflateView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int i) {
        String name=getItem(i);
        holder.tvName.setText(name);

    }

    private String getItem(int i) {
        return mPersonsName.get(i);
    }

    @Override
    public int getItemCount() {
        return mPersonsName.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView tvName;

        public Holder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
