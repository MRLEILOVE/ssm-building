package com.leigq.www.util;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * 基于java8封装的时间处理工具类
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-11-07 09:21 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public class DateUtil {
    /**
     * 返回一个"yyyy-MM-dd"的时间格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 返回一个"HH:mm:ss"的时间格式
     */
    public static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 返回一个"yyyy-MM-dd HH:mm:ss"的时间格式
     */
    public static final String DATE_TIME_FORMAT = DATE_FORMAT + TIME_FORMAT;

    /**
     * 返回一个"yyyyMMddHHmmss"的时间格式
     */
    public static final String DATETIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * 返回一个"yyyy-MM-dd HH:mm:ss"的时间格式
     */
    public static final DateTimeFormatter FORMAT_DATA_TIME = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    /**
     * 返回一个"yyyyMMddHHmmss"的时间格式
     */
    public static final DateTimeFormatter FORMATDATA_TIME = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

    /**
     * 返回一个"yyyy-MM-dd"的时间格式
     */
    public static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern(DATE_FORMAT);
    /**
     * 返回一个"HH:mm:ss"的时间格式
     */
    public static final DateTimeFormatter FORMAT_TIME = DateTimeFormatter.ofPattern(TIME_FORMAT);

    /**
     * 获取LocalDateTime
     */
    public static LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * 获取LocalTime
     */
    public static LocalTime localTime = LocalTime.now();

    /**
     * 获取LocalDate
     */
    public static LocalDate localDate = LocalDate.now();

    /**
     * 获取秒级时间戳
     */
    public static Long epochSecond = localDateTime.toEpochSecond(ZoneOffset.of("+8"));

    /**
     * 获取毫秒级时间戳
     */
    public static Long epochMilli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

    /**
     * 获取当前详细时间，like 2018-08-27 17:20:06
     */
    public static String dateTime = localDateTime.format(FORMAT_DATA_TIME);

    /**
     * 获取当前详细时间，like 20180827172006
     */
    public static String dateTimeNoSymbol = localDateTime.format(FORMATDATA_TIME);

    /**
     * 获取当前日期，like 2018-08-27
     */
    public static String date = localDate + "";

    /**
     * 获取当前时间，like 17:20:06
     */
    public static String time = localTime.format(FORMAT_TIME);

    /**
     * 获取当前年
     */
    public static int year = localDate.getYear();

    /**
     * 获取当前年的前几年/后几年的日期
     * <p>
     *
     * @param yearsToAddOrSubtract 后几年传正整数，前几年传负数
     * @param formatter            格式
     * @return 当前年的前几年/后几年的日期
     */
    public static String getMinusOrPlusYears(long yearsToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusYears(yearsToAddOrSubtract).format(formatter) :
                localDate.plusYears(yearsToAddOrSubtract) + "";
    }

    /**
     * 获取当前月
     */
    public static int month = localDate.getMonthValue();

    /**
     * 获取当前月的前几月/后几月的日期
     *
     * @param monthsToAddOrSubtract 后几月传正整数，前几月传负数
     * @param formatter             格式
     * @return 当前月的前几月/后几月的日期
     */
    public static String getMinusOrPlusMonths(long monthsToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusMonths(monthsToAddOrSubtract).format(formatter) :
                localDate.plusMonths(monthsToAddOrSubtract) + "";
    }

    /**
     * 获取当前年中的日
     */
    public static int dayOfYear = localDate.getDayOfYear();

    /**
     * 获取当前月中的日
     */
    public static int dayOfMonth = localDate.getDayOfMonth();

    /**
     * 获取当前日的前几日/后几日的日期
     *
     * @param daysToAddOrSubtract 后几日传正整数，前几日传负数
     * @param formatter           格式
     * @return 当前日的前几日/后几日的日期
     */
    public static String getMinusOrPlusDays(long daysToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusDays(daysToAddOrSubtract).format(formatter) :
                localDate.plusDays(daysToAddOrSubtract) + "";
    }

    /**
     * 获取当前星期中的日
     */
    public static int dayOfWeek = localDate.getDayOfWeek().getValue();

    /**
     * 获取当前星期的前几星期/后几星期的日期
     *
     * @param weeksToAddOrSubtract 后几星期传正整数，前几星期传负数
     * @param formatter            格式
     * @return 当前星期的前几星期/后几星期的日期
     */
    public static String getMinusOrPlusWeeks(long weeksToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusWeeks(weeksToAddOrSubtract).format(formatter) :
                localDate.plusWeeks(weeksToAddOrSubtract) + "";
    }

    /**
     * 获取当前小时
     */
    public static int hour = localTime.getHour();

    /**
     * 获取当前小时的前几小时/后几小时的日期
     *
     * @param hoursToAddOrSubtract 后几小时传正整数，前几小时传负数
     * @param formatter            格式
     * @return 当前小时的前几小时/后几小时的日期
     */
    public static String getMinusOrPlusHours(long hoursToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusHours(hoursToAddOrSubtract).format(formatter) :
                localTime.plusHours(hoursToAddOrSubtract).format(formatter);
    }

    /**
     * 获取当前分钟
     */
    public static int minute = localTime.getMinute();

    /**
     * 获取当前分钟的前几分钟/后几分钟的日期
     *
     * @param minutesToAddOrSubtract 后几分钟传正整数，前几分钟传负数
     * @param formatter              格式
     * @return 当前分钟的前几分钟/后几分钟的日期
     */
    public static String getMinusOrPlusMinutes(long minutesToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusMinutes(minutesToAddOrSubtract).format(formatter) :
                localTime.plusMinutes(minutesToAddOrSubtract).format(formatter);
    }

    /**
     * 获取当前秒
     */
    public static int second = localTime.getSecond();

    /**
     * 获取当前秒的前几秒/后几秒的日期
     *
     * @param secondsToAddOrSubtract 后几秒传正整数，前几秒传负数
     * @param formatter              格式
     * @return 当前秒的前几秒/后几秒的日期
     */
    public static String getMinusOrPlusSeconds(long secondsToAddOrSubtract, DateTimeFormatter formatter) {
        assert formatter != null;
        return formatter.equals(FORMAT_DATA_TIME) ? localDateTime.plusSeconds(secondsToAddOrSubtract).format(formatter) :
                localTime.plusSeconds(secondsToAddOrSubtract).format(formatter);
    }

    /**
     * Date类型转LocalDateTime、LocalDate、LocalTime
     * <p>
     *
     * @param date date类型时间
     * @param type 1:LocalDateTime; 2:LocalDate; 3: LocalTime
     * @return LocalDateTime、LocalDate、LocalTime
     */
    public static Object DateToJava8Date(Date date, Integer type) {
        assert date != null;
        assert type == 1 || type == 2 || type == 3;
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
        Object java8Date = null;
        switch (type) {
            case 1:
                java8Date = dateTime;
                break;
            case 2:
                java8Date = dateTime.toLocalDate();
                break;
            case 3:
                java8Date = dateTime.toLocalTime();
                break;
        }
        return java8Date;
    }

    /**
     * LocalDateTime、LocalDate、LocalTime类型转Date
     *
     * @param java8Date LocalDateTime、LocalDate、LocalTime
     * @return 转换后的Date类型日期
     */
    public static Date Java8DateToDate(Object java8Date) {
        assert java8Date != null;
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = null;
        if (java8Date instanceof LocalDateTime) {
            instant = localDateTime.atZone(zone).toInstant();
        }
        if (java8Date instanceof LocalDate) {
            instant = localDate.atStartOfDay().atZone(zone).toInstant();
        }
        if (java8Date instanceof LocalTime) {
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            instant = localDateTime.atZone(zone).toInstant();
        }
        return instant == null ? null : Date.from(instant);
    }

    /**
     * 获取 endDate-startDate 时间间隔天数
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-07 09:55
     * <br>
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间间隔天数
     */
    public static long daysInterval(LocalDate startDate, LocalDate endDate) {
        assert startDate != null;
        assert endDate != null;
        return endDate.toEpochDay() - startDate.toEpochDay();
    }

    /**
     * 获取 endDate-startDate 时间间隔天数
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-07 09:55
     * <br>
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间间隔天数
     */
    public static long daysInterval(String startDate, String endDate) {
        assert StringUtils.isNotBlank(startDate);
        assert StringUtils.isNotBlank(endDate);
        return daysInterval(LocalDateTime.parse(endDate, FORMAT_DATA_TIME).toLocalDate(),
                LocalDateTime.parse(startDate, FORMAT_DATA_TIME).toLocalDate());
    }

    /**
     * 获取 endDate-startDate 时间间隔天数
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-07 09:55
     * <br>
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 时间间隔天数
     */
    public static long daysInterval(LocalDateTime startDate, LocalDateTime endDate) {
        assert startDate != null;
        assert endDate != null;
        return daysInterval(startDate.toLocalDate(), endDate.toLocalDate());
    }
}
