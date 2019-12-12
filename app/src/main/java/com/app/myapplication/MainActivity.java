package com.app.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.myapplication.adapter.ListAdapter;
import com.app.myapplication.network.ApiCallBack;
import com.app.myapplication.network.ApiClient;
import com.app.myapplication.network.responsemodel.ClsGetListResponse;
import com.app.myapplication.recyclerview.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnItemClickListener
{
    private ClsGetListResponse clsListAPINewsResponse = null;
    private ListAdapter cultureListAdapter;
    ArrayList<ClsGetListResponse.HitsBean> hitsBeans = new ArrayList<>();
    private RecyclerView recycleViewList;
    private LinearLayoutManager linearlayoutManager;
    public RelativeLayout relLoadMore;
    private int offsetBrands = 1;
    private SwipeRefreshLayout swipeLayout = null;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleViewList = findViewById(R.id.recycleViewList);
        swipeLayout = findViewById(R.id.swipeLayout);
        txtTitle = findViewById(R.id.txtTitle);
        setCount();

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                swipeLayout.setRefreshing(false);
                offsetBrands = 1;
                if (hitsBeans != null && hitsBeans.size() > 0)
                    hitsBeans.clear();
                setCount();
                callGetListWS();
            }
        });
        relLoadMore = (RelativeLayout) findViewById(R.id.relLoadMore);
        removeFooterView();

        callGetListWS();
    }

    public void setCount()
    {
        if (txtTitle != null)
        {
            if (hitsBeans != null && hitsBeans.size() > 0)
            {
                int count = 0;
                for (ClsGetListResponse.HitsBean hitsBean : hitsBeans)
                {
                    if (hitsBean.getSelected())
                        count++;
                }
                txtTitle.setText("Selected : " + count);
            }
            else
            {
                txtTitle.setText("Selected : 0");
            }
        }
    }

    public static void setFooterVisibility(RelativeLayout relLoadMore, int visibility)
    {
        if (relLoadMore != null)
            relLoadMore.setVisibility(visibility);
    }

    private void callGetListWS()
    {
        if (offsetBrands > 1)
        {
            setFooterVisibility(relLoadMore, View.VISIBLE);
        }
        else
        {
            Utility.showProgress(this, false);
        }

        Call<ClsGetListResponse> call = ApiClient.getRestApiMethods().getList(offsetBrands);
        call.enqueue(new ApiCallBack<ClsGetListResponse>()
        {
            @Override
            public void onRefresh()
            {

            }

            @Override
            public void onResponse(Call<ClsGetListResponse> call, Response<ClsGetListResponse> response)
            {
                clsListAPINewsResponse = response.body();
                Utility.cancelProgress();
                removeFooterView();
                setAdapter();
            }

            @Override
            public void onFailure(Call<ClsGetListResponse> call, Throwable t)
            {
                Utility.cancelProgress();
                removeFooterView();
            }
        });

    }

    private LinearLayoutManager getLinearLayoutManager()
    {
        if (linearlayoutManager == null)
            linearlayoutManager = new LinearLayoutManager(this);
        return linearlayoutManager;
    }

    private void setAdapter()
    {
        if (clsListAPINewsResponse != null && clsListAPINewsResponse.getHits() != null &&
                clsListAPINewsResponse.getHits().size() > 0)
        {
            offsetBrands++;
            hitsBeans.addAll(clsListAPINewsResponse.getHits());
            if (cultureListAdapter == null)
            {
                recycleViewList.setLayoutManager(getLinearLayoutManager());
                cultureListAdapter = new ListAdapter(this, hitsBeans);
                recycleViewList.setAdapter(cultureListAdapter);
                recycleViewList.addItemDecoration(new DividerItemDecoration(recycleViewList.getContext(), DividerItemDecoration.VERTICAL));
                cultureListAdapter.SetOnItemClickListener(this);
                recycleViewList.addOnScrollListener(endlessRecyclerViewScrollListener);
            }
            else
            {
                cultureListAdapter.setLists(hitsBeans);
                cultureListAdapter.notifyDataSetChanged();
            }
        }
        else
        {
            offsetBrands = 0;
        }
    }


    @Override
    public void onItemClick(View view, int position, List<ClsGetListResponse.HitsBean> filteredList)
    {
        ClsGetListResponse.HitsBean hitsBean = filteredList.get(position);
        Utility.log("Hits : " + hitsBean.getTitle());
    }

    public void setLoadingFlag()
    {
        if (endlessRecyclerViewScrollListener != null)
            endlessRecyclerViewScrollListener.setLoading(false);
    }

    public void removeFooterView()
    {
        if (relLoadMore != null)
            setFooterVisibility(relLoadMore, View.GONE);
    }

    EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(getLinearLayoutManager(), this)
    {
        @Override
        public void onLoadMore(int page, int totalItemsCount)
        {
            Utility.log("Total item count : " + totalItemsCount);
            if (offsetBrands == 0)
            {
                removeFooterView();
            }
            else
            {
                if (Utility.isNetworkAvailable(MainActivity.this))
                    callGetListWS();
                else
                    Toast.makeText(MainActivity.this, "Internet connection is not available.", Toast.LENGTH_SHORT).show();
            }
        }
    };

}
