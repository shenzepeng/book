package kxg.library.book.provider.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: mbp
 * @Date: 2019-09-07 14:37
 * @Description: 去除换行符
 */
public class CleanLinefeedUtils {
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
