package com.jerryyin.recyclerviewdomo;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Yin on 2016/4/6.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CusViewHolder> {

    private Context mContext;
    private List<String> mDataList;
//    private String[]
    BigDecimal bd ;
    double aa;


    public RecyclerAdapter(Context mContext, List<String> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }



    @Override
    public CusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        CusViewHolder viewHolder = new CusViewHolder(view, new CustomEditTextListener());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CusViewHolder holder, int position) {
        String data = mDataList.get(position);
        int p = position+1;
        holder.tv1.setText(String.valueOf(p));
//        holder.tv2.setText(data);
        holder.et1.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * 更新位置
     */
    private class CustomEditTextListener implements TextWatcher{

        private int position;

        private void updatePosition(int p){
            this.position = p;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String data = mDataList.get(position);
            mDataList.get(position).replace(data, s);   //更新List里面的数据
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    class CusViewHolder extends RecyclerView.ViewHolder{

        private TextView tv1, tv2;
        private EditText et1, et2;

        private CustomEditTextListener editTextListener;

        public CusViewHolder(View itemView, CustomEditTextListener editTextListener) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            et1 = (EditText) itemView.findViewById(R.id.et_txt1);
            et2 = (EditText) itemView.findViewById(R.id.et_txt2);
            this.editTextListener = editTextListener;
            et1.addTextChangedListener(editTextListener);
        }
    }
}
