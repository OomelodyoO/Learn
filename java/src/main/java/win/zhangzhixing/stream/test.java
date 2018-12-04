package win.zhangzhixing.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<String> rStrings;
        List<String> strings = Arrays.asList("a", "ab", "ac", "d", "e", "f", "ag");
        System.out.println("stream filter:");
        rStrings = strings.stream().filter(string -> string.contains("a")).collect(Collectors.toList());
        System.out.println(rStrings.toString());
        System.out.println("stream sorted:");
        rStrings = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(rStrings.toString());
        System.out.println("stream map:");
        rStrings = strings.stream().map(string -> string + string).collect(Collectors.toList());
        System.out.println(rStrings.toString());
    }
}
