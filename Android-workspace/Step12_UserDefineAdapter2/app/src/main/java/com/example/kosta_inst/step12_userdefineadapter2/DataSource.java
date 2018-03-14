package com.example.kosta_inst.step12_userdefineadapter2;

import java.util.ArrayList;


public class DataSource {
    private ArrayList<FoodVO> list=new ArrayList<FoodVO>();
    public DataSource(){
        list.add(new FoodVO("처음처럼",R.drawable.food1,"현아에서 아이유로~"));
        list.add(new FoodVO("참이슬",R.drawable.food2,"참 이슬 진로.."));
        list.add(new FoodVO("시원",R.drawable.food3,"시원한 소주.."));
        list.add(new FoodVO("잎새주",R.drawable.food4,"광주 소주.."));
        list.add(new FoodVO("화이트",R.drawable.food5,"경남 소주.."));
        list.add(new FoodVO("한라산",R.drawable.food6,"제주 소주.."));
        list.add(new FoodVO("매화수",R.drawable.food7,"노란 소주.."));
        list.add(new FoodVO("청하",R.drawable.food8,"비싼 소주.."));
        list.add(new FoodVO("좋은 데이",R.drawable.food9,"부산 소주"));
    }
    public ArrayList<FoodVO> getList(){
        return list;
    }
}
