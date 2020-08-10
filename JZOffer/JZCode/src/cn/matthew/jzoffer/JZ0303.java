package cn.matthew.jzoffer;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数组中重复的数字
 * @date: 8/6/2020
 * @author: 大帅
 * @version: 1.0
 */

/*
JZ0301的加强：需要统计出数组中所有的重复的数字以及重复的次数
思路：可以用Map，key表示出现重复的数字，value表示重复数字出现的次数

循环数组，判断map中是否含有这个数，如果这个数不存在，那么就把这个数加到map中；
如果这个已经存在，那么就把这个数的value++；
 */
public class JZ0303 {
    public static void main(String[] args) throws Exception {
        int[] origin = {2, 3, 2, 1, 4, 5, 4, 4, 0};
        Map<Integer,Integer> res = findRepeatNum(origin);
        //打印结果
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() > 1){
                System.out.println(entry.getKey() + "重复了->" + entry.getValue() + "次");
            }
        }
    }

    private static Map<Integer, Integer> findRepeatNum(int[] origin) throws Exception {
        //数组不合法抛出异常
        if (origin == null || origin.length <=0) throw new Exception("数组不合法！");
        //数组合法.遍历数组，对数组中出现的数字及次数做记录
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 0; i < origin.length; i++) {
            Integer val = result.get(origin[i]);
            result.put(origin[i],(val == null)?1:val+1 );
        }
        return result;
    }
}
