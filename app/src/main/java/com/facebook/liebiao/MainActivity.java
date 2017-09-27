package com.facebook.liebiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.liebiao.bean.TestBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView rv;
    private ArrayList<TestBean> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rv = (RecyclerView) findViewById(R.id.rv);
        mStrings = new ArrayList<>();
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(manager);
        rv.setAdapter(new MyAdepter());
        initdate();
    }

    private void initdate() {

        for (int i = 0; i < 49; i++) {
            TestBean bean = new TestBean("xx--xx" + i, false);
            mStrings.add(bean);
        }

    }

    public class MyAdepter extends RecyclerView.Adapter {

        private ViewHolder mMyHolder;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            mMyHolder = new ViewHolder(view);
            return mMyHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            mMyHolder = (ViewHolder) holder;
            mMyHolder.tv.setText(mStrings.get(position).getName().toString());
            mMyHolder.tv.setSelected(mStrings.get(position).isSelected());
            mMyHolder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //获取现在的选中状态
                    boolean selected = mStrings.get(position).isSelected();
                        for (TestBean bean : mStrings) {
                            bean.setSelected(false);
                        }
                        mStrings.get(position).setSelected(!selected);
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mStrings.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv)
            TextView tv;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }


}
