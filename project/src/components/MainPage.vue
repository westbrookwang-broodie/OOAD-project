<template>
  <div class="header">
    <!--    <div class="logo">-->
    <!--      <a href="MainPage.vue">-->
    <!--        <h1 class="icon-we-go"></h1>-->
    <!--      </a>-->
    <!--    </div>-->
    <div class="navigation">
      <a class="home">首页</a>
      <a class="home">酒店预定</a>
      <a class="home">会员中心</a>
      <a class="home">积分商城</a>
      <a class="home">登录</a>
    </div>
    <div class="container">
      <h1>Feel at home When You're Away</h1>
      <div class="form-row">
        <div class="control-group cc1-md-3">
          <label>Check-In</label>
          <div>
            <el-date-picker
              type="date"
              :picker-options="datePicker"
              placeholder="select date"></el-date-picker>
          </div>
        </div>
        <div class="control-group cc1-md-3">
          <label>Check-Out</label>
          <div>
            <el-date-picker
              type="date"
              :picker-options="datePicker"
              placeholder="select date"></el-date-picker>
          </div>
        </div>
        <div class="control-group cc1-md-3">
          <label>Select-City</label>
          <div>
            <el-select placeholder="City">
              <el-option v-for="item in cities"
                         :key="item.key"
                         :label="item.label"
                         :value="item.label"/>
            </el-select>
          </div>
        </div>
        <div class="control-group cc1-md-3">
          <el-button class="search_btn">Search</el-button>
        </div>
      </div>
    </div>
    <div class="carousel-item active carousel-item-left">
      <img src="@/assets/img1.png">
    </div>
  </div>
</template>
<script>
export default {
  name: 'MainPage',
  data () {
    return {
      datePicker: {
        disabledDate (time) {
          return time.getTime() < Date.now()
        }
      },
      activeIndex: '1',
      cities: [
        {label: '深圳', key: 'ShenZen'},
        {label: '广州', key: 'GuangZhou'},
        {label: '成都', key: 'ChengDu'},
        {label: '长沙', key: 'ChangSha'},
        {label: '厦门', key: 'Xiamen'}
      ]
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
.header {
  background-image: url("../assets/img1.png");
  padding-left: 16px;
  padding-right: 16px;
  position: relative;
  width: 100%;
  min-width: 1200px;
  height: 80px;
  margin: 0px;
  background-color: #222222;
}

.logo h1 {
  float: left;
  margin-left: 10px;
  position: relative;
}

.navigation {
  padding: 30px;
}

.navigation a {
  font-family: Bahnschrift;
  color: #00CED1;
  font-size: 22px;
  padding: 20px;
}
.form-row {
  display: flex;
}
.search_btn {
  background-color: #222222;
  border-color: #ffffff;
  margin-left: 20px;
  color: #00CED1;
  border-radius: 30px;
}
</style>
