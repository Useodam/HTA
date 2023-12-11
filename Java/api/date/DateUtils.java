package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static final SimpleDateFormat basicFormat
            = new SimpleDateFormat("yyyy.M.d");
    static final SimpleDateFormat detailFormat
            = new SimpleDateFormat("yyyy.M.d HH:MM:ss");

    
    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        return basicFormat.format(date);
    }

    /**
     * 날짜를 전달받아서 문자열로 변환 후 반환한다
     *
     * @param date 날짜
     * @return 날짜와 시간정보가 모두 포함된 문자열
     */
    public static String dateToDetailString(Date date) {
        if (date == null) {
            return "";
        }
        return detailFormat.format(date);
    }


}