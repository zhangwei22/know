package com.tech.stack.controller;

import com.tech.stack.util.LineChartUtils;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangwei on 2018/5/7.
 */
@Controller
@RequestMapping("jFreeChart")
public class JFreeChartController {

    @RequestMapping("getJFreeCharts")
    public ModelAndView getJFreeCharts(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //保存图片 返回图片文件名
        String filename = ServletUtilities
                .saveChartAsPNG(LineChartUtils.createDemoPanel(), 600, 400, null);
        //获取图片路径（内存中）
        String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
        //拼接<img src="" />
        String image =
                "<img src='" + graphURL + "' width=600 height=400 border=0 usemap='#" + filename
                        + "'/>";
        request.setAttribute("image", image);
        return new ModelAndView("jFreeChart");
    }
}
