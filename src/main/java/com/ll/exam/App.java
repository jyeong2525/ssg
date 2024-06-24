package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        List<WiseSaying> wiseSayings = new ArrayList<>();
        Long sequence = 0L;

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();

                    Long contentId = ++sequence;
                    WiseSaying wiseSaying = new WiseSaying(contentId, content, author);

                    System.out.printf("%d번 명언이 등록되었습니다", contentId);
                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-----------------");
                    for (WiseSaying saying : wiseSayings) {
                        System.out.printf("%d / %s / %s\n", saying.id, saying.content, saying.author);
                    }
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
