// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui';
import router from './router'
import axios from 'axios'
import $ from 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import MD5 from './assets/js/md5.js'
import store from './store'

axios.defaults.baseURL = 'http://<ip>:<server-port>/api'  // 此处填写运行的Server-bookstore的URL, <server-port>查看Server-bookstore中,application-dev.yml的server.port配置
Vue.prototype.$http = axios;
Vue.prototype.MD5 = MD5;
Vue.use(ElementUI);

Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title;
  }
  next();
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  template: '<App/>',
  components: { App }
})