package com.example.user.limger;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstructionsForUseFragment extends Fragment {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    public InstructionsForUseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_instructions_for_use, container, false);

        listView = (ExpandableListView)view.findViewById(R.id.lvExpQA);
        initData();
        listAdapter = new ExpandableListAdapter(getContext(),listDataHeader,listHash);
        listView.setAdapter(listAdapter);

        return view;
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("主題版");
        listDataHeader.add("L幣");
        listDataHeader.add("每日簽到");
        listDataHeader.add("創房");
        listDataHeader.add("限時配對");
        listDataHeader.add("私聊");
        listDataHeader.add("多人聊天");

        List<String> Title = new ArrayList<>();
        Title.add("主題版分為：電玩、有趣、美食、動漫等等...."+"\n"+"可依照不同類型選擇參與聊天或創房");

        List<String> Lcoin = new ArrayList<>();
        Lcoin.add("Expandable ListView");
        Lcoin.add("Google Map");
        Lcoin.add("Chat Application");
        Lcoin.add("Firebase ");

        List<String> Signin = new ArrayList<>();
        Signin.add("Xamarin Expandable ListView");
        Signin.add("Xamarin Google Map");
        Signin.add("Xamarin Chat Application");
        Signin.add("Xamarin Firebase ");

        List<String> Createroom = new ArrayList<>();
        Createroom.add("UWP Expandable ListView");
        Createroom.add("UWP Google Map");
        Createroom.add("UWP Chat Application");
        Createroom.add("UWP Firebase ");

        List<String> Addfriend = new ArrayList<>();
        Addfriend.add("UWP Expandable ListView");
        Addfriend.add("UWP Google Map");


        List<String> Privatechat = new ArrayList<>();
        Privatechat.add("與好友進行一對一聊天"+"\n"+"彼此可以更進一步認識對方唷");
        Privatechat.add("UWP Google Map");

        List<String> peoplechat = new ArrayList<>();
        peoplechat.add("UWP Expandable ListView");
        peoplechat.add("UWP Google Map");


        listHash.put(listDataHeader.get(0),Title);
        listHash.put(listDataHeader.get(1),Lcoin);
        listHash.put(listDataHeader.get(2),Signin);
        listHash.put(listDataHeader.get(3),Createroom);
        listHash.put(listDataHeader.get(4),Addfriend);
        listHash.put(listDataHeader.get(5),Privatechat);
        listHash.put(listDataHeader.get(6),peoplechat);
    }


    class ExpandableListAdapter extends BaseExpandableListAdapter {
        private Context context;
        private List<String> listDataHeader;
        private HashMap<String,List<String>> listHashMap;

        public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
            this.context = context;
            this.listDataHeader = listDataHeader;
            this.listHashMap = listHashMap;
        }

        @Override
        public int getGroupCount() {
            return listDataHeader.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return listHashMap.get(listDataHeader.get(i)).size();
        }

        @Override
        public Object getGroup(int i) {
            return listDataHeader.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return listHashMap.get(listDataHeader.get(i)).get(i1); // i = Group Item , i1 = ChildItem
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            String headerTitle = (String)getGroup(i);
            if(view == null)
            {
                LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_group,null);
            }
            TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
            lblListHeader.setTypeface(null, Typeface.BOLD);
            lblListHeader.setText(headerTitle);
            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            final String childText = (String)getChild(i,i1);
            if(view == null)
            {
                LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_item,null);
            }

            TextView txtListChild = (TextView)view.findViewById(R.id.lblListItem);
            txtListChild.setText(childText);
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }
}
