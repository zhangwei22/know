package com.tech.stack.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * Created by zhangwei on 2018/5/7.
 */
public class LineChartUtils {

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
        //第一条折线数据 折线名Series 1
        localDefaultCategoryDataset.addValue(21.0D, "Series 1", " 1月 ");
        localDefaultCategoryDataset.addValue(50.0D, "Series 1", " 2月 ");
        localDefaultCategoryDataset.addValue(152.0D, "Series 1", " 3月 ");
        localDefaultCategoryDataset.addValue(184.0D, "Series 1", " 4月 ");
        localDefaultCategoryDataset.addValue(299.0D, "Series 1", " 5月 ");
        //第二条折线数据 折线名Series 2
        localDefaultCategoryDataset.addValue(275.0D, "Series 2", " 1月 ");
        localDefaultCategoryDataset.addValue(121.0D, "Series 2", " 2月 ");
        localDefaultCategoryDataset.addValue(98.0D, "Series 2", " 3月 ");
        localDefaultCategoryDataset.addValue(103.0D, "Series 2", " 4月 ");
        localDefaultCategoryDataset.addValue(210.0D, "Series 2", " 5月 ");
        //第三天折线数据 折线名Series 3
        localDefaultCategoryDataset.addValue(198.0D, "Series 3", " 1月 ");
        localDefaultCategoryDataset.addValue(165.0D, "Series 3", " 2月 ");
        localDefaultCategoryDataset.addValue(55.0D, "Series 3", " 3月 ");
        localDefaultCategoryDataset.addValue(34.0D, "Series 3", " 4月 ");
        localDefaultCategoryDataset.addValue(77.0D, "Series 3", " 5月 ");
        return localDefaultCategoryDataset;
    }

    /**
     * 生成折线图（被调用）
     *
     * @param chartTitle 图的标题
     * @param x          横轴标题
     * @param y          纵轴标题
     * @param dataset    数据集
     * @return
     */
    private static JFreeChart createChart(String chartTitle, String x, String y,
            CategoryDataset dataset) {
        // 构建一个chart
        JFreeChart chart = ChartFactory.createLineChart(chartTitle,//图的标题
                x,  //x轴标题
                y,  //y轴标题
                dataset,//数据点
                PlotOrientation.VERTICAL, true, true, false);
        //字体清晰
        chart.setTextAntiAlias(false);
        // 设置背景颜色
        chart.setBackgroundPaint(Color.WHITE);

        // 设置图标题的字体
        Font font = new Font("隶书", Font.BOLD, 25);
        chart.getTitle().setFont(font);

        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
        // 设置图示的字体
        chart.getLegend().setItemFont(labelFont);

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        // x轴 // 分类轴网格是否可见
        categoryplot.setDomainGridlinesVisible(true);
        // y轴 //数据轴网格是否可见
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setDomainGridlinePaint(Color.WHITE);// 虚线色彩
        categoryplot.setBackgroundPaint(Color.lightGray);// 折线图的背景颜色

        // 设置轴和面板之间的距离
        // categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

        // 横轴 x
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值
        // domainAxis.setLabelPaint(Color.BLUE);//轴标题的颜色
        // domainAxis.setTickLabelPaint(Color.BLUE);//轴数值的颜色

        // 横轴 lable 的位置 横轴上的 Lable 45度倾斜 DOWN_45
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.0);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.0);

        // 纵轴 y
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setLabelFont(labelFont);
        numberaxis.setTickLabelFont(labelFont);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);

        // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
                .getRenderer();
        lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见
        lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见

        // 显示折点数据
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);

        return chart;
    }

    //获取JFreeChart
    public static JFreeChart createDemoPanel() {
        CategoryDataset database = createDataset();
        JFreeChart localJFreeChart = createChart("图的标题", "x标题", "y标题", database);

        return localJFreeChart;
    }

}
