package com.demo.ms.utils.commons;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class Util {
    private static SimpleDateFormat formatter;

    public static Date getToday() {
        setFormatter(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
        return new Date();
    }

    public static void setFormatter(SimpleDateFormat formatter) {
        Util.formatter = formatter;
    }
}
