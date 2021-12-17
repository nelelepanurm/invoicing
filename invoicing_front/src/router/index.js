import Vue from 'vue'
import VueRouter from 'vue-router'
import App from "@/App";
import Clients from '../views/Clients'
import MyProfile from '../views/MyProfile'
import MyProfile2 from '../views/MyProfile2'
import Home2 from '../views/Home2'
import Invoices from '../views/Invoices'
import CreateInvoice from '../views/CreateInvoice'
import Vat from '../views/Vat'
import CreateClient from '../views/CreateClient'
import EditClient from '../views/EditClient'

Vue.use(VueRouter)

const routes = [
  {
    path: '/app',
    name: 'App',
    component: App
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
    path: '/myProfile2/',
    name: 'MyProfile2',
    component: MyProfile2
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
    path: '/createInvoice',
    name: 'CreateInvoice',
    component: CreateInvoice
  },
  {
    path: '/vat',
    name: 'Vat',
    component: Vat
  },
  {
  path: '/createClient',
    name: 'CreateClient',
    component: CreateClient
},
  {
    path: '/editClient/:id',
    name: 'EditClient',
    component: EditClient
  }
]

const router = new VueRouter({
  routes
})

export default router
