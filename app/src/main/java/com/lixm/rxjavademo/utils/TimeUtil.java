package com.lixm.rxjavademo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describe:时间转换类
 * <p>
 * Author: zhuxuanmuyu
 * Date: 2018/6/24
 * Email: lxm20819@sina.com
 */

public class TimeUtil {
    public static String getNowStrTime(){
        long time=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        return sdf.format(new Date(time));
    }
}
