package com.cc.wydk.utils;

/**
 * All rights Reserved, Designed By www.hebeiwanteng.com
 *
 * @author 苏海
 * Package com.hebeiwanteng.ipc_shopping_server.response.advert
 * ClassName:AdvertPlanPageEntityResponse
 * Description:
 * Date 下午3:36 2020/7/13
 * Modify By :
 * Copyright: 2018 www.hebeiwanteng.com Inc. All rights reserved.
 * 注意：本内容仅限于河北万腾科技有限公司内部传阅，禁止外泄以及用于其他的商业目的.
 */
public class LatLonUtil {
    private static double PI = 3.14159265;
    private static double EARTH_RADIUS = 6378137;
    private static double RAD = Math.PI / 180.0;

    public static double[] GetAround(double lat, double lon, int raidus) {

        Double latitude = lat;
        Double longitude = lon;

        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = raidus;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;
        Double mpdLng = degree * Math.cos(latitude * (PI / 180));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        return new double[]{minLat, minLng, maxLat, maxLng};
    }


    public static double GetDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = lat1 * RAD;
        double radLat2 = lat2 * RAD;
        double a = radLat1 - radLat2;
        double b = (lng1 - lng2) * RAD;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
}
