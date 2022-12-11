<template>
  <div class="Main">
    <div class="header">
      <el-button type="primary" @click="componentName='Daily'">按天统计</el-button>
      <el-button type="primary" @click="componentName='Type'">按房型统计</el-button>
    </div>
    <div class="box">
      <component :is="componentName"></component>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import Daily from './DailyAnalysis.vue'
import Type from './TypeAnalysis.vue'

export default {
  name: 'Analysis',
  data () {
    return {
      componentName: 'Daily'
    }
  },
  components: {
    Daily,
    Type
  }
}
</script>

<style scoped>
.header {
  margin-top: 20px;
}
.box {
  height: 600px;
  width: 100%;
}
</style>
