<html>
<div style="background-color:#AABBCD">
    <table style="border:0px">
        <tr style="border:0px" align="center">
            <td colspan="4">以下是今天的主要新闻</td>
        </tr>
        <tr align="center">
            <td>编号</td>
            <td>标题</td>
            <td>发布时间</td>
            <td>操作</td>
        </tr>
    <#if newslist?exists >
        <#list newslist as news>
            <tr align="center">
                <td>${news.id}</td>
                <td align="left">${news.name}</td>
                <td>${news.age}</td>
                <td><a href="${news.sex}">查看详情</a></td>
            </tr>
        </#list></#if>
    </table>
</div>
</html>
