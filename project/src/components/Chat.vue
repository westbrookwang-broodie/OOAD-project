<template>
  <div class="chat">

    <div class="head">
      <span style="font-size: 20px; display: flex; padding-left: 50px">在线客服</span>
    </div>

    <div class="messageBody" v-loading="loading">
      <div>信息</div>
    </div>
    <div class="bottom">
      <el-input v-model="form.msg" type="textarea" placeholder="输入信息" :rows="4"></el-input>
      <div class="btn">
        <el-button type="info" @click="clear()">清空</el-button>
        <el-button type="primary" @click="send()">发送</el-button>
      </div>

    </div>

  </div>
</template>

<script>
export default {
  name: 'Chat',
  data () {
    return {
      loading: false,
      form: {
        content: '',
        msg: ''
      }
    }
  },

  methods: {
    clear () {
      this.form.msg = ''
    },
    send () {
      if (this.form.msg === '') {
        this.$message({
          message: '不能发送空内容',
          type: 'error'
        })
      } else {
        this.$message({
          message: '点击了发送',
          type: 'success'
        })
      }
    }
  }
}
</script>

<style scoped>
.head {
  padding-top: 20px;
  padding-bottom: 30px;
  padding-left: 23%;
}

.messageBody {
  margin-left: 25%;
  background-color: #F8F8F6;
  height: 450px;
  width: 50%;
}

.bottom {
  margin-top: 20px;
  margin-left: 25%;
  width: 50%;
}

.btn {
  margin-top: 10px;
  padding-left: 70%;
}
</style>
