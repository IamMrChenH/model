/**
 * 进制转换测试
 *
 * @author yaowk
 * @date 2019-06-27
 */
public class DemoTest {
    public static void main(String[] args) {
        String s = Long.toHexString(4394721002366599576L);
        System.out.println(s);

        String message = "123 ; content:\n111111";
        String split = "; content:\n";
        int index = message.indexOf(split);
        String body = message.substring(index + split.length(), message.length());
        System.out.println(body);
    }
}
