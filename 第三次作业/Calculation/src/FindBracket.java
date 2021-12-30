import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sk
 * @version 1.0
 */

public class FindBracket { // 找到括号里的表达式
    public String findExpressionInBracket(String expresstion){
        Matcher mat = Pattern.compile("(?<=\\（)(\\S+)(?=\\）)").matcher(expresstion);//此处是中文输入的（）
        System.out.println(mat.group());
        return mat.group();

    }
}
