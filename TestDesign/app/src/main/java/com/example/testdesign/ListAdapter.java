package com.example.testdesign;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<ListContend> objects;

    ListAdapter(Context context, ArrayList<ListContend> listcontend) {
        ctx = context;
        objects = listcontend;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, parent, false);
        }

        ListContend p = getListContend(position);

        // заполняем View в пункте списка данными: номер, вопрос
        ((TextView) view.findViewById(R.id.Number)).setText(p.number);
        ((TextView) view.findViewById(R.id.question)).setText(p.question);



        return view;
    }

    // данные по позиции
    ListContend getListContend(int position) {
        return ((ListContend) getItem(position));
    }}




