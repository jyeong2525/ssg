package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private List<WiseSaying> wiseSayings;
    private Long wiseSayingLastId;

    public WiseSayingService() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0L;
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }

        return null;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying write(String content, String author) {
        Long id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public void remove(int paramId) {
        WiseSaying findWiseSaying = findById(paramId);
        wiseSayings.remove(findWiseSaying);
    }

    public void modify(int paramId, String content, String author) {
        WiseSaying findWiseSaying = findById(paramId);
        findWiseSaying.content = content;
        findWiseSaying.author = author;
    }
}
