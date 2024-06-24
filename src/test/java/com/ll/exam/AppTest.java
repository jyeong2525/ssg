package com.ll.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void Rq_getPath() throws Exception{
        //given
        RequestQuery requestQuery = new RequestQuery("삭제?id=1");

        //when
        String path = requestQuery.getPath();

        //then
        assertEquals("삭제", path);
    }

    @Test
    public void Re_getIntParam() throws Exception{
        //given
        RequestQuery requestQuery = new RequestQuery("삭제?id=1");

        //when
        int id = requestQuery.getIntParam("id", 0);

        //then
        assertEquals(1, id);
    }

    @Test
    public void test() throws Exception{
        int rs = 10 + 20;
        assertEquals(30, rs);
    }

    @Test
    public void 문자열을_스캐너의_입력으로_설정() throws Exception{
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);

    }

    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }
}
