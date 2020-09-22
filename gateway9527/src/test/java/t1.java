import java.time.ZonedDateTime;

public class t1 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();    //默认时区
        System.out.println(now);
        //2020-06-24T12:50:05.134+08:00[Asia/Shanghai]
    }
}
