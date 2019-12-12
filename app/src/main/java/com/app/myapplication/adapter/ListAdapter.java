package com.app.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.app.myapplication.MainActivity;
import com.app.myapplication.R;
import com.app.myapplication.network.responsemodel.ClsGetListResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter implements View.OnClickListener
{
    private List<ClsGetListResponse.HitsBean> list = new ArrayList<>();
    private Context mContext;
    OnItemClickListener mItemClickListener;

    /***
     * @param list = list of product list
     * @param mContext = activity context
     */
    public ListAdapter(Context mContext, List<ClsGetListResponse.HitsBean> list)
    {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType)
    {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_list, parent, false);

        vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public int getItemCount()
    {
        return getLists().size();
    }

    @Override
    public void onClick(View v)
    {
        int position = (int) v.getTag();
        ClsGetListResponse.HitsBean hitsBean = list.get(position);
    }


    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView txtAccountName;
        private TextView txtCreatedDate;
        private Switch aSwitch;

        public ViewHolder(View v)
        {
            super(v);
            txtAccountName = (TextView) v.findViewById(R.id.txtAccountName);
            txtCreatedDate = (TextView) v.findViewById(R.id.txtCreatedDate);
            aSwitch = (Switch) v.findViewById(R.id.switchToggle);
//            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if (mItemClickListener != null)
            {
                mItemClickListener.onItemClick(v, getLayoutPosition(), getLists());
            }
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position)
    {
        final ClsGetListResponse.HitsBean hitsBean = getLists().get(position);
        ((ViewHolder) holder).txtAccountName.setText(hitsBean.getTitle());
        String date = getDate(hitsBean);
        ((ViewHolder) holder).txtCreatedDate.setText(date);
        ((ViewHolder) holder).aSwitch.setChecked(hitsBean.getSelected());
        ((ViewHolder) holder).aSwitch.setTag(position);
        ((ViewHolder) holder).aSwitch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int pos = (int) view.getTag();
                ClsGetListResponse.HitsBean hitsBean = getLists().get(pos);
                hitsBean.setSelected(!hitsBean.getSelected());
                getLists().set(pos, hitsBean);
                MainActivity mainActivity = (MainActivity) mContext;
                if(mainActivity != null)
                    mainActivity.setCount();
            }
        });
    }

    private String getDate(ClsGetListResponse.HitsBean hitsBean)
    {
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date newDate = null;
        try
        {
            newDate = spf.parse(hitsBean.getCreatedAt());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        spf = new SimpleDateFormat("dd MMM yyyy - hh:mm a");
        return spf.format(newDate);
    }

    public interface OnItemClickListener
    {
        public void onItemClick(View view, int position, List<ClsGetListResponse.HitsBean> filteredUserList);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener)
    {
        this.mItemClickListener = mItemClickListener;
    }

    public List<ClsGetListResponse.HitsBean> getLists()
    {
        return this.list;
    }

    public void setLists(List<ClsGetListResponse.HitsBean> keywordLists)
    {
        this.list = keywordLists;
    }
}