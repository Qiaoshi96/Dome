package jingou.jo.com.dome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<String> mDemoData;
    private Context mContext;
   private Onitemclick listen;

    public void setListten (Onitemclick listen) {
        this.listen = listen;
    }

    public DemoAdapter(Context context) {
        mContext = context;
        mDemoData = DataModel.getDemoData();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DemoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((DemoViewHolder) holder).mTxtItem.setText(mDemoData.get(position));
//        实现监听事件
        ((DemoViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listen!=null){
                    listen.Itemclick(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDemoData == null ? 0 : mDemoData.size();
    }

    class DemoViewHolder extends RecyclerView.ViewHolder {

        TextView mTxtItem;

        public DemoViewHolder(View itemView) {
            super(itemView);
            mTxtItem = (TextView) itemView.findViewById(R.id.txt_item);
            mTxtItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, Main2Activity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
//    定义接口
    public  interface  Onitemclick{
        void  Itemclick(View v,int p);
    }
}
