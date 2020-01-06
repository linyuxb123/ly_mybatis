package xyz.linyuxb.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: sql转化工具
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:38
 */
public class SQLUtils {
    /**
     * 截取插入sql参数
     *
     * @param sql
     * @return
     */
    public static String[] sqlInsertParameter(String sql) {
        int startIndex = sql.indexOf("values");
        int endIndex = sql.length();
        String substring = sql.substring(startIndex + 6, endIndex)
                .replace("(", "")
                .replace(")", "")
                .replace("#{", "")
                .replace("}", "");
        String[] split = substring.split(",");
        return split;
    }

    /**
     * 截取查询sql参数
     *
     * @param sql
     * @return
     */
    public static List<String> sqlSelectParameter(String sql) {
        int startIndex = sql.indexOf("where");
        int endIndex = sql.length();
        String substring = sql.substring(startIndex + 5, endIndex);
        String[] split = substring.split("and");
        List<String> listArr = new ArrayList<>();
        for (String string : split) {
            String[] sp2 = string.split("=");
            String trim = sp2[1].trim();
            trim = trim.replace("#{", "")
                    .replace("}", "");
            listArr.add(trim);
        }
        return listArr;
    }

    /**
     * 将SQL语句的参数替换变为?
     *
     * @param sql
     * @param parameterName
     * @return
     */
    public static String parameQuestion(String sql, String[] parameterName) {
        for (int i = 0; i < parameterName.length; i++) {
            String string = parameterName[i];
            sql = sql.replace("#{" + string + "}", "?");
        }
        return sql;
    }

    /**
     * 将SQL语句的参数替换变为?
     *
     * @param sql
     * @param parameterName
     * @return
     */
    public static String parameQuestion(String sql, List<String> parameterName) {
        for (int i = 0; i < parameterName.size(); i++) {
            String string = parameterName.get(i);
            sql = sql.replace("#{" + string + "}", "?");
        }
        return sql;
    }

}
