package com.lettalk.gy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.newim.bean.BmobIMConversation;

/**
 * @author :smile
 * @project:ConversationAdapter
 * @date :2016-01-22-14:18
 */
public class ConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BmobIMConversation> conversations = new ArrayList<>();
    private int TYPE_CONTACTS = 0;

    public ContactsItemHolder getItemHolder() {
        return itemHolder;
    }

    public void setItemHolder(ContactsItemHolder itemHolder) {
        this.itemHolder = itemHolder;
    }

    private ContactsItemHolder itemHolder;


    public ConversationAdapter() {
    }


    /**
     * @param list
     */
    public void bindDatas(List<BmobIMConversation> list) {
        conversations.clear();
        if (null != list) {
            conversations.addAll(list);
        }
    }

    /**
     * 移除会话
     *
     * @param position
     */
    public void remove(int position) {
        conversations.remove(position - 1);
    }

    /**
     * 获取会话
     *
     * @param position
     * @return
     */
    public BmobIMConversation getItem(int position) {
        return conversations.get(position - 1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *
         */
        if (viewType == TYPE_CONTACTS) {
            if (itemHolder == null) {
                itemHolder = new ContactsItemHolder(parent.getContext(), parent, onRecyclerViewListener);
            }
            return itemHolder;

        } else {
            return new ConversationHolder(parent.getContext(), parent, onRecyclerViewListener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ConversationHolder) {
            ((BaseViewHolder) holder).bindData(conversations.get(position - 1));

        } else if (holder instanceof ContactsItemHolder) {
            ((BaseViewHolder) holder).bindData(null);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_CONTACTS;
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return conversations.size() + 1;
    }


    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

}
