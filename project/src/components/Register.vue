<template>
  <el-container>
    <el-header>
      <span style="margin-top: 13px">Register User</span>
    </el-header>
    <el-main>
      <el-form :model="userForm"
               :rules="rules"
               ref="userForm"
               label-position="right"
               label-width="115px"
               style="width: 500px; margin-left: 480px; margin-top: 50px; height: 400px">

        <el-form-item label="User Name" placeholder="用户名" prop="username">
          <el-input :rows="1" v-model="userForm.username"></el-input>
        </el-form-item>

        <el-form-item label="Password" placeholder="密码" prop="password">
          <el-input :rows="1" v-model="userForm.password"></el-input>
        </el-form-item>

        <el-form-item label="Name" placeholder="真实姓名" prop="name">
          <el-input :rows="1" v-model="userForm.name"></el-input>
        </el-form-item>

        <el-form-item label="Gender" prop="gender">
          <el-radio-group v-model="userForm.gender" style="margin-right: 12px;">
            <el-radio v-for="(radio, index) in genderList" :key="index" :label="radio">{{ radio.label }}</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="Phone" placeholder="手机号码" prop="phone">
          <el-input :rows="1" v-model="userForm.phone"></el-input>
        </el-form-item>

        <el-form-item label="Email" placeholder="邮箱" prop="email">
          <el-input :rows="1" v-model="userForm.email"></el-input>
        </el-form-item>

        <el-form-item label="Address" placeholder="地址" prop="address">
          <el-input :rows="1" v-model="userForm.address"></el-input>
        </el-form-item>

        <el-form-item label="Grant" prop="grant">
          <el-radio-group v-model="userForm.grant" style="margin-right: 12px;">
            <el-radio v-for="(radio, index) in grantList" :key="index" :label="radio">{{ radio.label }}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <el-button @click="submit" type="primary" style="margin-left: -550px; margin-top: 100px">Submit</el-button>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'register',
  data () {
    return {
      userForm: {
        username: '',
        password: '',
        name: '',
        gender: '',
        phone: '',
        email: '',
        address: '',
        grant: ''
      },
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {
            validator: function (rule, value, callback) {
              if (value === '' || value === null) {
                callback(new Error('请输入课程名称'))
              } else {
                callback()
              }
            },
            trigger: 'blur'
          }
        ],
        password: [{required: true, message: '请设置密码', trigger: 'blur'},
          {
            validator: function (rule, value, callback) {
              if (value === '' || value === null) {
                callback(new Error('请设置密码'))
              } else {
                callback()
              }
            },
            trigger: 'blur'
          }
        ],
        name: [{required: true, message: '请输入真实姓名', trigger: 'blur'},
          {
            validator: function (rule, value, callback) {
              if (value === '' || value === null) {
                callback(new Error('请输入真实姓名'))
              } else {
                callback()
              }
            },
            trigger: 'blur'
          }
        ],
        gender: [{required: true, message: '请选择性别', trigger: 'change'},
          {
            validator: function (rule, value, callback) {
              if (value === '' || value === null) {
                callback(new Error('请选择性别'))
              } else {
                callback()
              }
            },
            trigger: 'blur'
          }
        ],
        phone:
          [{required: true, message: '请输入手机号码', trigger: 'blur'},
            {
              validator: function (rule, value, callback) {
                if (value === '' || value === null) {
                  callback(new Error('请输入手机号码'))
                } else {
                  if (/^1[3-9]\d{9}$/.test(value)) {
                    callback()
                  } else {
                    callback(new Error('请输入正确的手机号码'))
                  }
                }
              },
              trigger: 'blur'
            }
          ],
        email:
          [{required: true, message: '请输入邮箱', trigger: 'blur'},
            {type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur'},
            {
              validator: function (rule, value, callback) {
                if (value === '' || value === null) {
                  callback(new Error('请输入邮箱'))
                } else {
                  callback()
                }
              },
              trigger: 'blur'
            }
          ],
        address:
          [{required: true, message: '请输入地址', trigger: 'blur'},
            {
              validator: function (rule, value, callback) {
                if (value === '' || value === null) {
                  callback(new Error('请输入地址'))
                } else {
                  callback()
                }
              },
              trigger: 'blur'
            }
          ],
        grant:
          [{required: true, message: '请选择用户权限', trigger: 'change'},
            {
              validator: function (rule, value, callback) {
                if (value === '' || value === null) {
                  callback(new Error('请选择用户权限'))
                } else {
                  callback()
                }
              },
              trigger: 'blur'
            }
          ]
      },
      genderList: [{label: 'Male', key: 1}, {label: 'Female', key: 2}],
      grantList: [{label: 'User', key: 1}, {label: 'Administrator', key: 2}]
    }
  },
  methods: {
    submit () {
      // console.log(this.userForm)
      var url = 'http://10.24.3.53:8181/register?username=' + this.userForm.username + '&password=' + this.userForm.password + '&name=' + this.userForm.name + '&gender=' + this.userForm.gender.key + '&phone=' + this.userForm.phone + '&email=' + this.userForm.email + '&address=' + this.userForm.address + '&grant=' + this.userForm.grant.key
      var xmlhttp = new XMLHttpRequest()
      xmlhttp.open('POST', url, false)
      xmlhttp.send()
      var myData = xmlhttp.responseText
      console.log(myData)
      // if (myData === true) {
      //   this.$router.push('/mainPage')
      // } else {
      //   alert('注册失败')
      // }
    }
  }
}
</script>

<style scoped>
.el-header {
  background-color: coral;
  display: flex;
  justify-content: center;
  font-size: 30px;
}
</style>
<!--http://localhost:8181/register?
username=1&
password=2&
name=wwe&
gender=1&
phone=231&
email=xvds&
address=wq&
grant=1-->
