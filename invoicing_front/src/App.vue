<template>
  <v-app id="inspire">
    <v-navigation-drawer
        v-model="drawer"
        app
        v-if="token"
    >
      <v-list>
        <v-list-item
            v-for="item in items"
            :key="item.title"
            :to="item.to"
            link
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar
        app
        color=#84ab85
        dark
    >
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Invoicing</v-toolbar-title>
      <v-spacer></v-spacer>
      <div v-if="token">
        <v-btn v-on:click="logOut">Log out</v-btn>
      </div>
    </v-app-bar>
    <v-main>
      <v-container>
        <div v-if="!token && firstPage" class="home pa-10">
          <h1>Lets get started!</h1>
          <p class="font-weight-bold">
            Welcome to Invoicing page!<br>
            To start using Invoicing, please log in here: <br><br>
          <div>
            Kasutajanimi: <input v-model="newuser.userName" placeholder="kasutaja nimi"><br><br>
            Parool: <input v-model="newuser.password" type="password" placeholder="parool"><br><br>
            <v-btn v-on:click="login">LOGIN</v-btn>
            <br><br>
            <v-btn v-on:click="getData">Get data</v-btn>
          </div>
          <br><br>
          <p class="font-weight-bold"> Don't have an account yet? <br> Register
            <v-btn v-on:click="registerHere()">HERE</v-btn>
          </p>
        </div>
      </v-container>
      <div v-if="!token && !firstPage">
        <router-view/>
      </div>
      <div v-if="!token">
      </div>
    </v-main>
  </v-app>
</template>


<script>
import router from "./router";

export default {
  data: () => ({
    drawer: null,
    items: [
      {title: 'Home', icon: 'mdi-home', to: '/Home2'},
      {title: 'Invoices', icon: 'mdi-receipt', to: '/Invoices'},
      {title: 'Clients', icon: 'mdi-account-group', to: '/Clients'},
      {title: 'VAT Codes', icon: 'mdi-format-list-group', to: '/Vat'},
      {title: 'My Profile2', icon: 'mdi-account-cog-outline', to: '/myProfile2'},
    ],
    token: '',
    firstPage: true,
    newuser: {}

  }),
  methods: {
    login() {
      this.$http.post('api/public/password', this.newuser)
          .then(result => {
            this.token = result.data
            localStorage.setItem('user-token', this.token)
            this.$http.defaults.headers.common['Authorization'] = "Bearer " + this.token
            router.push({name: 'Home2'})
          });

    },
    getData() {
      this.$http.get('api/protected')
          .then(result => {
            alert('päring õnnestus' + result.data)
          })
          .catch(result => {
            alert('juhtus viga')
          })
    },
    logOut() {
      this.token = ''
      localStorage.removeItem('user-token')
      alert("you have been logged out")
      location.reload()
    },
    registerHere: function () {
      this.firstPage = false
      router.push({name: 'MyProfile'})
    }
  },
  mounted() {
    this.token = localStorage.getItem("user-token")
  }
}
</script>