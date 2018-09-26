package com.zsctc.remote.touch.bytes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class TimeUtil {

    private TimeUtil() {
    }

    /**
     * 获取一小时的第一秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getFirstSecondInHour(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一小时的最后一秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getLastSecondInHour(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND,
                calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一天的第一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getFirstSecondInDay(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一天的最后一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getLastSecondInDay(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一星期的第一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getFirstSecondInWeek(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一星期的最后一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getLastSecondInWeek(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一星期的第一毫秒
     *
     * @param timeInMillis
     * @param dayOfWeek    周的第一天。若为负数，则不设置,参照Calendar
     * @return
     */
    public static long getFirstSecondInWeek(long timeInMillis, int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(dayOfWeek);
            calendar.setTimeInMillis(timeInMillis);
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
            calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
            calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
            return calendar.getTimeInMillis();
        } else {
            return getFirstSecondInWeek(timeInMillis);
        }
    }

    /**
     * 获取一星期的最后一毫秒
     *
     * @param timeInMillis
     * @param dayOfWeek    周的第一天。若为负数，则不设置，参照Calendar
     * @return
     */
    public static long getLastSecondInWeek(long timeInMillis, int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            // 从第一天开始计算，返回加7天之后的最后一秒
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(dayOfWeek);
            calendar.setTimeInMillis(timeInMillis);
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
            calendar.add(Calendar.DAY_OF_WEEK, 6);
            calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
            calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
            return calendar.getTimeInMillis();
        } else {
            // 无效参数以及dayOfWeek == Sunday时，返回星期六最后一毫秒
            // Sunday == 1
            return getLastSecondInWeek(timeInMillis);
        }
    }

    /**
     * 获取一个月的第一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getFirstSecondInMonth(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一个月的最后一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getLastSecondInMonth(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一年的第一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getFirstSecondInYear(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    /**
     * 获取一年的最后一毫秒
     *
     * @param timeInMillis
     * @return
     */
    public static long getLastSecondInYear(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    public static int getDayBetween(long day1, long day2) {
        return (int) Math.abs((TimeUtil.getFirstSecondInDay(day1) - getFirstSecondInDay(day2)) / (1000 * 3600 * 24));
    }

    public static int getMinBetween(long t1, long t2) {
        return Math.abs((Long.valueOf(((t1 - t2) / (1000 * 60)))).intValue());
    }

    public static int getMonthBetween(long t1, long t2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(t1);
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(t2);
        return Math.abs((c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12
                + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH));
    }

    /**
     * 根据用户生日计算年龄
     */
    public static int getAgeByBirthday(long birthday) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTimeInMillis(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    public static long getSpecifyTime(long timeInMillis, int hour, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTimeInMillis();
    }

    public static long addDay(long timeInMillis, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTimeInMillis();
    }

    /**
     * @return milliseconds since 1.1.1970 for today 0:00:00
     */
    public static long getToday() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    public static String getFormatTime(long time){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
        String dateString = formatter.format(time);
        return dateString;
    }

    public static String getFormatTime(int time){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format((long)time * 1000);
        return dateString;
    }

    public static String getFormatTimeForRunTime(long time){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format((long)time * 1000);
        return dateString;
    }

    public static int getHour(long time){
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String dateString = formatter.format(time);
        int result = 0;
        try{
            result = Integer.parseInt(dateString);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static int getMin(long time){
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        String dateString = formatter.format(time);
        int result = 0;
        try{
            result = Integer.parseInt(dateString) + getHour(time)*60;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String getFormatTimeAll(long time){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YY-MM-dd");
        String dateString = formatter.format(time);
        return dateString;
    }

    /**
     * 日期转星期
     */
    public static int dateToWeek(long milliseconds) {
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        cal.setTimeInMillis(milliseconds);
        int w = cal.get(Calendar.DAY_OF_WEEK); // 指示一个星期中的某天。
        return w;
    }

    public static int getCurrentDay(){
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_MONTH);
    }
}
