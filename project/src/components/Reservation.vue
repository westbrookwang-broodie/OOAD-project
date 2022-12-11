<template>
  <div class="header">
    <div class="navigation">
      <a class="home" @click="go_home()">首页</a>
      <a class="home">酒店预定</a>
      <a class="home">会员中心</a>
      <a class="home">积分商城</a>
      <a class="home" @click="go_login()">登录</a>
    </div>

    <div class="header_buttom">
      <div class="form-row" style="display: flex; justify-content: center">
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
          <label>日期</label>
          <div>
            <el-date-picker
              type="date"
              v-model="hotelForm.destination"
              :picker-options="datePicker"
              placeholder="select date"></el-date-picker>
          </div>
        </div>
        <div class="control-group cc1-md-3">
          <label>关键词</label>
          <div>
            <el-input v-model="input1" placeholder="请输入内容"></el-input>
          </div>
        </div>
        <div class="control-group cc1-md-3" style="padding-top: 18px">
          <el-button class="search_btn">搜索</el-button>
        </div>
      </div>
      <br>
      <el-row style="font-size: 15px;line-height: 60px">
        <el-col :span=2 offset=6>星级</el-col>
        <el-col :span=2>
          <el-radio-button label="不限"></el-radio-button>
        </el-col>
        <el-col :span=10>
          <el-checkbox v-model="checked3" style="color: white">1</el-checkbox>
          <el-checkbox v-model="checked4" style="color: white">2</el-checkbox>
          <el-checkbox v-model="checked5" style="color: white">3</el-checkbox>
          <el-checkbox v-model="checked6" style="color: white">4</el-checkbox>
          <el-checkbox v-model="checked7" style="color: white">5</el-checkbox>
        </el-col>
      </el-row>
      <br><br>
      <el-row style="font-size: 15px;line-height: 60px">
        <el-col :span=2 offset=6>价格</el-col>
        <el-col :span=2>
          <el-radio-button label="不限"></el-radio-button>
        </el-col>
        <el-col :span=2>
          价格区间
        </el-col>
        <el-col :span=2>
          <el-input v-model="input2" placeholder="请输入内容"></el-input>
        </el-col>
        <el-col span=1 offset=1>——</el-col>
        <el-col :span=2>
          <el-input v-model="input3" placeholder="请输入内容"></el-input>
        </el-col>
      </el-row>
      <br><br>
      <el-row style="line-height: 50px">
        <el-col span=13 offset=5>
          <el-container>
            <el-table :data="this.dataForm" width="800px" height="300px">

              <el-table-column label="酒店名称" width="250" style="justify-content: center">
                <template slot-scope="scope">
                  <div slot="reference" class="name-wrapper" id="app">
                    <p v-for="(item, index) in scope.row" :key="index" @click="jump(item)">
                      {{ item.name}}
                    </p>
                  </div>
                </template>
              </el-table-column>

              <el-table-column prop="location" label="地址" width="400" style="justify-content: center">
                <template slot-scope="scope">
                  <div slot="reference" class="name-wrapper" id="app">
                    <p v-for="(item, index) in scope.row" :key="index">
                      {{ item.location}}
                    </p>
                  </div>
                </template>
              </el-table-column>
              <el-table-column prop="remark" label="详细" width="150" style="justify-content: center">
                <template slot-scope="scope">
                  <div slot="reference" class="name-wrapper" id="app">
                    <p v-for="(item, index) in scope.row" :key="index">
                      {{ item.remark}}
                    </p>
                  </div>
                </template>
              </el-table-column>
            </el-table>
          </el-container>
        </el-col>

      </el-row>
    </div>
  </div>
</template>
<script>

export default {
  name: 'reservation',
  data () {
    return {
      input1: '',
      input2: '',
      input3: '',
      input4: 'input',
      radio: '0',
      checked1: false,
      checked2: false,
      checked3: false,
      checked4: false,
      checked5: false,
      checked6: false,
      checked7: false,
      url: '../assets/img1.jpg',
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
      dataForm: [],
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
    jump (item) {
      console.log(item.id)
      this.$router.push({
        name: 'room',
        params: {
          id: item.id
        }
      })
    }
  },
  created () {
    if (this.$route.params.grade + '' === '1') {
      this.checked3 = true
    }
    if (this.$route.params.grade + '' === '2') {
      this.checked4 = true
    }
    if (this.$route.params.grade + '' === '3') {
      this.checked5 = true
    }
    if (this.$route.params.grade + '' === '4') {
      this.checked6 = true
    }
    if (this.$route.params.grade + '' === '5') {
      this.checked7 = true
    }
    this.hotelForm.destination = this.$route.params.destination
    this.hotelForm.grade = this.$route.params.grade
    let grade = this.hotelForm.grade * 1
    let url = 'http://10.24.3.53:8181/findHotels?grade=' + grade + '&city=' + this.hotelForm.destination[1] + '&district=' + this.hotelForm.destination[2]
    console.log(url)
    let xmlhttp = new XMLHttpRequest()
    xmlhttp.open('POST', url, false)
    xmlhttp.send()
    let dataTemp = []
    dataTemp.push(JSON.parse(xmlhttp.responseText))
    this.dataForm = dataTemp
    console.log(this.dataForm)
  }
}
</script>

<style scoped>
.header {
  /*background: url("../assets/img1.png");*/
  background: #0e4f66;
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
