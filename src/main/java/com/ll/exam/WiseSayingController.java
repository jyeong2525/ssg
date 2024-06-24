package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void modify(RequestQuery requestQuery) {
        int paramId = requestQuery.getIntParam("id", 0);

        if(paramId == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }

        WiseSaying findWiseSaying = wiseSayingService.findById(paramId);

        if(findWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        System.out.printf("명언(기존) : %s\n", findWiseSaying.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", findWiseSaying.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(paramId, content, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }

    public void list(RequestQuery requestQuery) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (WiseSaying wiseSaying : wiseSayings) {
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.content, wiseSaying.author);
        }
    }

    public void remove(RequestQuery requestQuery) {
        int paramId = requestQuery.getIntParam("id", 0);

        if(paramId == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }

        WiseSaying findWiseSaying = wiseSayingService.findById(paramId);

        if(findWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
        }

        wiseSayingService.remove(paramId);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
}
