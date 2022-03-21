package com.nowcoder.community;

import java.io.IOException;

public class wkTest {
    public static void main(String[] args) {
        String cmd="D:\\wkhtmltopdf\\bin\\wkhtmltoimage --quality 75 https://www.baidu.com D:\\wkhtmltopdf\\wk-images\\3.png";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
