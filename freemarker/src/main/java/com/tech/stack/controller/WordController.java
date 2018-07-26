package com.tech.stack.controller;

import com.tech.stack.entity.RoadPqi;
import com.tech.stack.entity.Word;
import com.tech.stack.service.WordService;
import com.tech.stack.util.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @ResponseBody
    @RequestMapping("exportWord2")
    public void exportWord2(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> paramMap = new HashMap<>();
        List<RoadPqi> roadPqiList = new ArrayList<>();
        RoadPqi roadPqi = new RoadPqi();
        roadPqi.setEvaluator("路面损坏PCI");
        roadPqi.setPjz("pp-1");
        roadPqi.setYll("yy-1");
        roadPqi.setCcl("cc-1");
        roadPqi.setYou("you-1");
        roadPqi.setLiang("ll-1");
        roadPqi.setZhong("zz-1");
        roadPqi.setCi("ci-1");
        roadPqi.setCha("cha-1");
        roadPqiList.add(roadPqi);

        roadPqi.setEvaluator("抗滑SRI");
        roadPqi.setPjz("pp2");
        roadPqi.setYll("yy2");
        roadPqi.setCcl("cc2");
        roadPqi.setYou("you2");
        roadPqi.setLiang("ll2");
        roadPqi.setZhong("zz2");
        roadPqi.setCi("ci2");
        roadPqi.setCha("cha2");
        roadPqiList.add(roadPqi);

        paramMap.put("roadPqiList", roadPqiList);
        paramMap.put("province", "zhangwei2018");
        try {
            WordUtils.exportMillCertificateWord(request, response, paramMap, "方案2",
                    "test_table.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("exportWord3")
    public void exportWord3(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> paramMap = new HashMap<>();
        String roadPqiList="";
        paramMap.put("roadPqiList", roadPqiList);
        paramMap.put("province", "zhangwei2018");
        try {
            WordUtils.exportMillCertificateWord(request, response, paramMap, "方案2",
                    "test_table.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
