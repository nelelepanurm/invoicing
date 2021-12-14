import Vue from 'vue'
import VueRouter from 'vue-router'
import Clients from '../views/Clients'
import MyProfile from '../views/MyProfile'
import Home2 from '../views/Home2'
import Invoices from '../views/Invoices'
import CreateInvoice from '../views/CreateInvoice'
import Vat from '../views/Vat'

Vue.use(VueRouter)

const routes = [

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
  {
    path: '/CreateInvoice',
    name: 'CreateInvoice',
    component: CreateInvoice
  },
  {
    path: '/Vat',
    name: 'Vat',
    component: Vat
  },
]

const router = new VueRouter({
  routes
})

export default router
