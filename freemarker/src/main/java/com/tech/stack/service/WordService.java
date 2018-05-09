package com.tech.stack.service;

import com.tech.stack.entity.Word;
import org.springframework.stereotype.Service;

/**
 * Created by zhangwei on 2018/5/4.
 */
@Service
public class WordService {

    public Word getWordById(Long id) {
        Word word = new Word();
        word.setId(id);
        word.setbYear("2017");
        word.setlYear("2019");
        word.setLeader("王思聪");
        word.setPhone("18801016758");
        word.setCurYear("2018");
        word.setImage("http://image.baidu.com/search/detail");
        return word;
    }
}
