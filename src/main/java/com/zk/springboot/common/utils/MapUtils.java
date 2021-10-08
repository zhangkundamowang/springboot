package com.zk.springboot.common.utils;

/**
 * 地图工具类
 */
public class MapUtils {

    /**
     * 默认地球半径 单位km
     * 平均半径;6371.393   赤道半径;6378.137
     */
    //private static double EARTH_RADIUS = 6378.137;
    private static double EARTH_RADIUS = 6371.393;

    /**
     * 转化为弧度
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }


    /**
     * 返回单位m lng:经度 lat:纬度
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }


}