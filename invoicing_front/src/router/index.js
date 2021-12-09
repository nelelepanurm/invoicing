import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Clients from '../views/Clients'
import MyProfile from '../views/MyProfile'
import Home2 from '../views/Home2'
import Invoices from '../views/Invoices'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/clients',
    name: 'Clients',
    component: Clients
  },
  {
    path: '/myProfile',
    name: 'MyProfile',
    component: MyProfile
  },
  {
    path: '/home2',
    name: 'Home2',
    component: Home2
  },
  {
    path: '/invoices',
    name: 'Invoices',
    component: Invoices
  },

]

const router = new VueRouter({
  routes
})

export default router
