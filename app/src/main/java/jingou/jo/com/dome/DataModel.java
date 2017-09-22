package jingou.jo.com.dome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class DataModel {
    public static List<String> getDemoData() {
        List<String> demoData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            demoData.add("Android -- " + i);
        }
        return demoData;
    }
}
