package org.pedalhub.pedalhubbackend;

import java.util.ArrayList;
import java.util.List;

public class Sandbox {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(Integer.valueOf("5"));
        for(int i : list){
            System.out.println(i);
        }
    }
}
