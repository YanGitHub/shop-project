package com.power.saas.common;


import java.util.UUID;

/**
 * Created by Yan on 15-12-4.
 */
public class ID {

    public static String getGuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    //取纳秒
    public static Long getNonaSec(){
        //return System.nanoTime();
        return IdWorker.nextId();
    }
}
