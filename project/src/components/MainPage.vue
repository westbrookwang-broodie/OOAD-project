<template>
  <div class="header">
    <div class="navigation">
      <a class="home" @click="go_home()">首页</a>
      <a class="home">酒店预定</a>
      <a class="home" @click="analysis()">数据分析</a>
      <a class="home" @click="chat()">联系我们</a>
      <a class="home" @click="go_login()">登录</a>
    </div>
    <div class="header_buttom">
      <h1>Feel at home When You're Away</h1>
      <div class="form-row" style="display: flex; justify-content: center">

        <div class="control-group cc1-md-3">
          <label>Grade</label>
          <div>
            <el-select v-model="hotelForm.grade" placeholder="Grade">
              <el-option v-for="item in hotelGradeOptions"
                         :key="item.label"
                         :value="item.label"/>
            </el-select>
          </div>
        </div>
        <div class="control-group cc1-md-3">
          <label>Destination</label>
          <div>
            <el-cascader v-model="hotelForm.destination"
                         placeholder="destination"
                         :options="destinations"
                         filterable
            >
            </el-cascader>
          </div>
        </div>
        <div class="control-group cc1-md-3">
          <label>Number</label>
          <div>
            <el-select v-model="hotelForm.number" placeholder="Number of occupancy">
              <el-option v-for="item in numbers"
                         :key="item.label"
                         :value="item.label"/>
            </el-select>
          </div>
        </div>
        <div class="control-group cc1-md-3" style="padding-top: 18px">
          <el-button class="search_btn" @click="search()">Search</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'MainPage',
  data () {
    return {
      url: '../assets/img1.png',
      urlList: [],
      timer: null,
      datePicker: {
        disabledDate (time) {
          return time.getTime() < Date.now()
        }
      },
      activeIndex: '1',
      hotelForm: {
        grade: '',
        destination: '',
        number: ''
      },
      hotelGradeOptions: [
        {label: 1, value: 1},
        {label: 2, value: 2},
        {label: 3, value: 3},
        {label: 4, value: 4},
        {label: 5, value: 5}
      ],
      destinations: [
        {
          label: '广东',
          value: 'guangdong',
          children: [
            {
              label: '深圳',
              value: 'ShenZen',
              children: [
                {label: '南山', value: 'NanShan'},
                {label: '宝安', value: 'BaoAn'},
                {label: '龙岗', value: 'LongGang'},
                {label: '龙华', value: 'LongHua'}
              ]
            },
            {
              label: '广州',
              value: 'GuangZhou',
              children: [
                {label: '天河', value: 'TianHe'},
                {label: '白云', value: 'BaiYun'},
                {label: '海珠', value: 'HaiZhu'},
                {label: '越秀', value: 'YueXiu'}
              ]
            }
          ]
        }
      ],
      numbers: [
        {label: 1, value: 1},
        {label: 2, value: 2},
        {label: 3, value: 3},
        {label: 4, value: 4},
        {label: 5, value: 5}
      ]
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    },
    go_home () {
      this.$router.push('/')
    },
    go_login () {
      this.$router.push('/login')
    },
    search () {
      // this.$router.push('/reservation')
      this.$router.push({
        name: 'reservation',
        params: {
          grade: this.hotelForm.grade,
          destination: this.hotelForm.destination
        }
      })
      // console.log('click search')
      // console.log(this.hotelForm)
      // let grade = this.hotelForm.grade * 1
      // var url = 'http://10.24.3.53:8181/findHotels?grade=' + grade + '&city=' + this.hotelForm.destination[0] + '&district=' + this.hotelForm.destination[1]
      // console.log(url)
      // var xmlhttp = new XMLHttpRequest()
      // xmlhttp.open('POST', url, false)
      // xmlhttp.send()
      // var myData = xmlhttp.responseText
      // console.log(myData)
      // if (myData === true) {
      //   this.$router.push('/home')
      // } else {
      //   alert('用户不存在')
      // }
    },
    chat () {
      this.$router.push('/chat')
    },
    analysis () {
      this.$router.push('/analysis')
    }
  }
}
</script>

<style scoped>
.header {
  background: url("../assets/img2.png");
  width: 100%;
  height: 100%;
  background-position: center;
  background-size: cover;
  position: fixed;
}

.navigation {
  background: #222222;
  padding: 30px;
}

.navigation a {
  font-family: Bahnschrift;
  color: #00CED1;
  font-size: 22px;
  padding: 20px;
}

.header_buttom {
  position: absolute;
  padding: 30px 0 20px 0;
  width: 100%;
  z-index: 999;
  color: #ffffff;
}

.header_buttom h1 {
  color: #ffffff;
  text-align: center;
  margin-bottom: 20px;
}

.header_buttom h2 {
  font-size: 50px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: 10px;
  color: aquamarine;
}

.header_buttom h3 {
  font-size: 35px;
  font-weight: 700;
  letter-spacing: 1px;
  margin-bottom: 10px;
  color: aquamarine;
}

.control-group {
  padding-right: 10px;
  padding-left: 10px;
}

.form-row {
  display: flex;
}

.search_btn {
  background-color: #ffffff;
  border: none;
  margin-left: 20px;
  color: #00CED1;
  border-radius: 30px;
}

.el-button:hover {
  background-color: #00CED1;
  color: #222222;
}
</style>
