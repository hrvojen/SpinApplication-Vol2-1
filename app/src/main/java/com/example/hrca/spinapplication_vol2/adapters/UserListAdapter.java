package com.example.hrca.spinapplication_vol2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hrca.spinapplication_vol2.R;
import com.example.hrca.spinapplication_vol2.model.Food;

import java.util.ArrayList;

/**
 * Created by hrca on 24.10.2016..
 */

public class UserListAdapter extends ArrayAdapter<Food> {

    private final Context mContext;
    private ArrayList<Food> userFoodList = new ArrayList<>();
    private ArrayList<Food> mItems=new ArrayList<>();

    public UserListAdapter(Context mContext, ArrayList<Food> userFoodList) {
        super(mContext, R.layout.user_list_row, userFoodList);
        this.mContext = mContext;
        this.mItems.addAll(userFoodList);
    }

    public void swapItems(ArrayList<Food> foodItems) {
        this.mItems = foodItems;
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.user_list_row, parent, false);


        TextView mFoodName = (TextView) v.findViewById(R.id.user_food_name);
        TextView mBrand = (TextView) v.findViewById(R.id.user_food_brand);
        TextView mFoodDescription = (TextView) v.findViewById(R.id.user_food_description);

        mFoodName.setText(mItems.get(position).getFoodName());
        mFoodDescription.setText(mItems.get(position).getDescription());
        mBrand.setText(mItems.get(position).getBrand());
        return v;


    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    public void AddItem(Food food) {
        if (null != food) {
            userFoodList.add(food);
        }
    }

}
