package cn.liasoux.pojo;



import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class wuzi extends HashMap<String,Integer> {

    public static wuzi add(String materila,int quantity){
        ArrayList<String> strings = new ArrayList<>();
        wuzi wuzi = new wuzi();
        wuzi.put(materila,quantity);
        return wuzi;
    }

}
