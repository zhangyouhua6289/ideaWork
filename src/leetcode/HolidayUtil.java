package leetcode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangyouhua
 * @date 2020/8/28 11:29
 */
/**
 * 调用API接口判断日期是否是工作日 周末还是节假日 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
 */
public class HolidayUtil {

    public static int request(String httpArg) {
        String httpUrl = "http://api.goseek.cn/Tools/holiday";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?date=" + httpArg;

        int d = 0;// 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            JSONObject ob = JSON.parseObject(result);
            if (ob != null) {
                d = Integer.parseInt(ob.getString("data"));
            }

        } catch (Exception e) {
        }
        return d;
    }

    public static void main(String[] args) {
        // 判断今天是否是工作日 周末 还是节假日

        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");

        String httpArg = "20201002";// f.format(new Date());
        System.out.println(httpArg);
        int n = request(httpArg);
        System.out.println(n);
        // 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2

    }
}
