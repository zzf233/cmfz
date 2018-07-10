<%--
  Created by IntelliJ IDEA.
  User: zzf_PC
  Date: 2018/7/9
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_main" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持名法州App活跃用户'
        },
        tooltip: {},
        legend: {
            data:['用户数量']
        },
        xAxis: {
            data: ["7天","15天","30天","90天","半年","一年"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: [2,4,6,8,10,12]
        }]
    };

    myChart.setOption(option);

    /*
     Map<String,Object> map = new HashMap<String,Object>();
     map.put("intervals",new String[]{"7天","15天"});
     map.put("counts",new int[]{5,10});'
     return map;

     [{"intervals":["7天","15天"]},{}]


     */
    // 异步加载统计信息
    /*$.post("/statistics/activeUser",function(data){
        console.log(data);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption({
            xAxis: {
                data: data.intervals
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '活跃用户',
                data: data.counts
            }]
        });
    },"json");*/


</script>