<template>
  <div class="Daily" id="daily" style="display: flex">
    <div class="Order" id="order"></div>
    <div class="Turnover" id="turnover"></div>
  </div>

</template>

<script>
export default {
  name: 'DailyAnalysis',
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
      let option = {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            smooth: true
          }
        ]
      }
      // option.xAxis.data = []
      // option.series[0].data = []
      order.setOption(option)
    },
    setTurnover () {
      let turnover = this.$echarts.init(document.getElementById('turnover'))
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            axisTick: {
              alignWithLabel: true
            }
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: 'Direct',
            type: 'bar',
            barWidth: '60%',
            data: [10, 52, 200, 334, 390, 330, 220]
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
.Daily {
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
