package com.test.apitest_02;
import java.util.Scanner;
/*public String()
 *public String(char[] array) 根据字符数组内容创建对应字符数组
 *public String(byte[] array) 根据字节数组内容创建对应字节数组
 *
 * ==在基本类型比较时，是数值的比较，在引用类型中是地址的比较
 * public boolean equals 区分大小写的内容比较 ，在使用时尽量将常量放在前面，这样在变量为null时，不会出现空指针异常
 * public boolean equalsIgnoreCase不区分大小写的内容比较
 * public int length() 长度
 * public char charAt(int index) 获取指定索引位置的字符
 * public String concat(String str) 拼接字符串
 * public int indexOf(String str) 查找参数字符串在本字符串首次出现的索引，不存在则返回-1
 * public String substring(int index) 截取从参数位置到字符串末尾，返回新字符串
 * public String substring(int begin,int end)从begin开始i，到end结束，返回中间字符串
 * public char[] toCharArray() 将当前字符串拆分成字符数组作为返回值
 * public byte[] getBytes() 获得当前字符串底层字节数组
 * public String replace(CharSequence oldString,CharSequence newString)
 * public String[] split(String regex),根绝参数规则切割字符串,为正则表达式，英文的句点.需要为//.
 * */

public class StringTest {
    public static void main(String[] args) {
        String str1 = new String();
        System.out.println(str1);
        char[] charArray = {'A', 'B', 'C'};
        String str2 = new String(charArray);
        System.out.println(str2);

        byte[] byteArray = {97,98,99,122};
        String str3 = new String(byteArray);
        System.out.println(str3);

        String s1 = "Hello";
        String s2 = "Hello";
        char[]  chararray= {'H','e','l','l','o'};
        String s3=new String(chararray);
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));

        String s4 ="qwertyuiop";
        String s5 = s4.substring(2,5);
        System.out.println(s5+"======="+s4);

        char[] chars = s4.toCharArray();
        System.out.println(chars.length);

        byte[] bytes=s4.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        String s6 = "asdf";
        String s7 = s4.replace("qwe",s6);
        System.out.println(s7);

        String[] s8 = s4.split("[ruo]");
        for (int i = 0; i < s8.length; i++) {
            System.out.println(s8[i]);
        }

        int[] numlist =new int[]{1,2,3};
        System.out.println(clickstring(numlist));

        checkNum();
    }
    
    public static String clickstring(int [] numlist){
        String str = "[";
        for (int i = 0; i < numlist.length; i++) {
            if(i<numlist.length-1){
            str+="word"+numlist[i]+"#";}
            else{
                str+="word"+numlist[i]+"]";
            }

        }
        return str;
    }

    public static void checkNum(){
        Scanner sc = new Scanner(System.in);
        int countUpper =0;
        int countLower = 0;
        int countNumber=0;
        int countother=0;

        String checkstring =sc.next();
        char [] charArray = checkstring.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if('A'<=ch &&'Z'>=ch){
                countUpper++;
            }else if('a'<=ch &&'z'>=ch){
                countLower++;
            }else if('0'<=ch &&'9'>=ch){
                countNumber++;
            }else{
                countother++;
            }
        }
        System.out.println("数字："+countNumber);
        System.out.println("大写字母："+countUpper);
        System.out.println("小写字母："+countLower);
        System.out.println("其他符号："+countother);

    }
}
