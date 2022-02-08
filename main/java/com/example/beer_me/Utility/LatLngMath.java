package com.example.beer_me.Utility;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LatLngMath {

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            DecimalFormat df2 = new DecimalFormat("#.##");
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            df2.setRoundingMode(RoundingMode.UP);
            return Double.valueOf(df2.format(dist));
        }
    }
}

