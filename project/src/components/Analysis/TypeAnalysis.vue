<template>
  <div class="Type" id="type" style="display: flex">
    <div class="Order" id="order"></div>
    <div class="Turnover" id="turnover"></div>
  </div>
</template>

<script>
export default {
  name: 'TypeAnalysis',
  mounted () {
    this.setOrder()
    this.setTurnover()
  },
  methods: {
    getData () {
      alert('hello')
    },
    setOrder () {
      let order = this.$echarts.init(document.getElementById('order'))
      // prettier-ignore
      let dataAxis = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放']
      // prettier-ignore
      let data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220]
      let yMax = 500
      let dataShadow = []
      for (let i = 0; i < data.length; i++) {
        dataShadow.push(yMax)
      }
      let option = {
        title: {
          text: '特性示例：渐变色 阴影 点击缩放',
          subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
        },
        xAxis: {
          data: dataAxis,
          axisLabel: {
            inside: true,
            color: '#fff'
          },
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          z: 10
        },
        yAxis: {
          axisLine: {
            show: false
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            color: '#999'
          }
        },
        dataZoom: [
          {
            type: 'inside'
          }
        ],
        series: [
          {
            type: 'bar',
            showBackground: true,
            itemStyle: {
              color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {offset: 0, color: '#83bff6'},
                {offset: 0.5, color: '#188df0'},
                {offset: 1, color: '#188df0'}
              ])
            },
            emphasis: {
              itemStyle: {
                color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {offset: 0, color: '#2378f7'},
                  {offset: 0.7, color: '#2378f7'},
                  {offset: 1, color: '#83bff6'}
                ])
              }
            },
            data: data
          }
        ]
      }
      // Enable data zoom when user click bar.
      const zoomSize = 6
      order.on('click', function (params) {
        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)])
        order.dispatchAction({
          type: 'dataZoom',
          startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
          endValue:
            dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
        })
      })
      // option.xAxis.data = []
      // option.series[0].data = []
      order.setOption(option)
    },
    setTurnover () {
      let turnover = this.$echarts.init(document.getElementById('turnover'))
      let option = {
        title: {
          text: 'Stacked Line'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Email']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Email',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210]
          }
        ]
      }
      // option.xAxis[0].data = []
      // option.series[0].data = []
      turnover.setOption(option)
    }
  }
}
</script>

<style scoped>
.Type {
  height: 100%;
  width: 100%;
}

.Order {
  height: 100%;
  width: 100%;
}

.Turnover {
  height: 100%;
  width: 100%;
}
</style>
