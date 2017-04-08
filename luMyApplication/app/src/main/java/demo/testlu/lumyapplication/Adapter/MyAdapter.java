package demo.testlu.lumyapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.testlu.lumyapplication.R;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Integer> datas;

    /**
     * item的点击事件的长按事件接口
     */
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemlongClickListener;
    /**
     * 瀑布流时的item随机高度
     */
    private List<Integer> heights = new ArrayList<>();

    /**
     * 不同的类型设置item不同的高度
     *
     * @param type
     */
    private int type = 0;

    public MyAdapter(Context context, List<Integer> datas) {
        this.context = context;
        this.datas = datas;
        for (int i : datas) {
            int height = (int) (Math.random() * 100 + 300);
            heights.add(height);
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 设置点击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemlongClickListener(OnItemLongClickListener onItemlongClickListener) {
        this.onItemlongClickListener = onItemlongClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(contentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        RecyclerView.LayoutParams layoutParams;
        if (type == 0) {
            layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else if (type == 1) {
            layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        } else {
            layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heights.get(position));
            layoutParams.setMargins(2, 2, 2, 2);
        }
        holder.itemView.setLayoutParams(layoutParams);
        holder.imageView.setImageResource(datas.get(position));
        holder.tv.setText("分类" + position);
        /**设置item点击监听**/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(position, datas.get(position));
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                if (onItemlongClickListener!=null){}
                onItemlongClickListener.onItemLongClick(position, datas.get(position));
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    /**
     * 用于缓存的ViewHolder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    /**
     * 设置item监听的接口
     */
    public interface OnItemClickListener {
        void onItemClickListener(int position, Integer data);

    }
    /**
     * 设置item监听的接口
     */
    public interface OnItemLongClickListener {


        void onItemLongClick(int position, Integer integer);
    }



}
