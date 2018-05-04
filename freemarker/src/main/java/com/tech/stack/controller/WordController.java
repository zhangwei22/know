package com.tech.stack.controller;

import com.alibaba.druid.util.StringUtils;
import com.tech.stack.entiry.Word;
import com.tech.stack.service.WordService;
import com.tech.stack.util.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwei on 2018/5/4.
 */
@Controller
@RequestMapping("word")
public class WordController {

    @Autowired
    private WordService wordService;

    @ResponseBody
    @RequestMapping("exportWord")
    public void exportWord(HttpServletRequest request, HttpServletResponse response, Long id) {
        if (id == null) {
            return;
        }
        Word word = wordService.getWordById(id);
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", word.getId());
        paramMap.put("bYear", word.getbYear());
        paramMap.put("lYear", word.getlYear());
        paramMap.put("leader", word.getLeader());
        paramMap.put("phone", word.getPhone());
        paramMap.put("curYear", word.getCurYear());
        paramMap.put("image", word.getImage());
        try {
            WordUtils.exportMillCertificateWord(request, response, paramMap, "方案",
                    "wordTemplate.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
