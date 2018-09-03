package com.zakharchenko.oksana.getplaces.utils;

public class Constants {
    public static final String BASE_URL="http://sms.servio.support:32892";
    public static final String GET_PLACES_URL="/GetPlaces";
    public static final String REQUEST="-H &quot;accept: application/json&quot;\n" +
            "-H &quot;content-type: application/json";
    public static final String QUERY="query";


    public enum Type{BILL, PLACE,  SCHEMA, GROUP, UNION}
}
