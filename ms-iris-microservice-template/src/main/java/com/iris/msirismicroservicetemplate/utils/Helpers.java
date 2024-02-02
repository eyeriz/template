package com.iris.msirismicroservicetemplate.utils;


import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Helpers {
    public String maskMsisdn(String string){
        try {
            Pattern pattern = Pattern.compile("\\b254\\w{4}");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                String orig = string.substring(matcher.start(), matcher.end());
                string = string.replaceAll(orig, "254****");
                matcher = pattern.matcher(string);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return string;
    }

    public static String date(){
        String pattern = "yyyyMMddHHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return  simpleDateFormat.format(new java.util.Date());
    }


    public static void printSQLException(SQLException ex) {
        Logging logger = new Logging();
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                logger.writeInfoLog(e.getMessage(),"Exception","01", "Exception processor ","printSQLException", "SQL exception class");

                Throwable t = ex.getCause();
                while (t != null) {
                    logger.writeInfoLog(t.getMessage(),"Exception","01", "Exception processor ","printSQLException", "SQL exception class");
                }
            }
        }
    }


}
