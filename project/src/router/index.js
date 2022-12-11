import Vue from 'vue'
import Router from 'vue-router'
import MainPage from '../components/MainPage'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import MainPageLogin from '../components/MainPageLogin.vue'
import Reservation from '../components/Reservation'
import Chat from '../components/Chat.vue'
import Analysis from '../components/Analysis/Analysis.vue'
import RoomView from '../components/RoomView.vue'

Vue.use(Router)

const router = new Router(
  {
    routes: [
      {
        path: '/',
        redirect: '/home'
      },
      {
        path: '/home',
        name: '主页',
        component: MainPage
      },
      {
        path: '/login',
        name: '登录界面',
        component: Login
      },
      {
        path: '/register',
        name: '注册用户',
        component: Register
      },
      {
        path: '/mainPageLogin',
        name: '登录成功',
        component: MainPageLogin
      },
      {
        path: '/reservation',
        name: 'reservation',
        component: Reservation
      },
      {
        path: '/chat',
        component: Chat
      },
      {
        path: '/analysis',
        component: Analysis
      },
      {
        path: '/room',
        name: 'room',
        component: RoomView
      }
    ]
  }
)

export default router
