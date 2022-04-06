package com.titanio.app.ui.activities.home.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.titanio.app.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListItemAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> groupHeader;
    private HashMap<String, List<String>> groupHeaderItems;
    private List<Drawable> leftDrawable;
    private List<Drawable> leftChildDrawable;

    public ExpandableListItemAdapter(Context context, List<String> groupHeader, HashMap<String, List<String>> groupHeaderItems) {
        this.context = context;
        this.groupHeader = groupHeader;
        this.groupHeaderItems = groupHeaderItems;
    }

    public ExpandableListItemAdapter(Context context, List<String> groupHeader, HashMap<String, List<String>> groupHeaderItems, List<Drawable> leftDrawable,List<Drawable> leftChildDrawable) {
        this.context = context;
        this.groupHeader = groupHeader;
        this.groupHeaderItems = groupHeaderItems;
        this.leftDrawable = leftDrawable;
        this.leftChildDrawable = leftChildDrawable;
    }

    @Override
    public int getGroupCount() {
        return groupHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupHeaderItems.get(groupHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupHeader.get(groupPosition);
    }

    private Drawable getGroupImg(int groupPosition) {
        return leftDrawable.get(groupPosition);
    }

    private Drawable getChildImg(int childPosition) {
        return leftChildDrawable.get(childPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupHeaderItems.get(groupHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitles = (String) getGroup(groupPosition);
        Drawable headerImg = getGroupImg(groupPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_group, null);
        }



        TextView header = convertView.findViewById(R.id.groupHeaderTitles);
        ImageView groupIV = convertView.findViewById(R.id.groupIV);
        header.setText(headerTitles);
        groupIV.setImageDrawable(headerImg);
        ImageView ivExpand = convertView.findViewById(R.id.ivExpand);

        if (groupPosition == 3){
            ivExpand.setVisibility(View.VISIBLE);
        }
        else {
            ivExpand.setVisibility(View.GONE);
        }

        if(isExpanded){
            ivExpand.setImageResource(R.drawable.ic_collapse_menus);
        }
        else {
            ivExpand.setImageResource(R.drawable.ic_expands_menus);
        }


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String items = (String) getChild(groupPosition,childPosition);
        Drawable childImg = getChildImg(childPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_content, null);
        }

        TextView header = convertView.findViewById(R.id.groupHeadercontent);
        ImageView childIV = convertView.findViewById(R.id.childIV);
        header.setText(items);
        childIV.setImageDrawable(childImg);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
