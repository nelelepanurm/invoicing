<template>
  <v-app id="inspire">
    <v-navigation-drawer
        v-model="drawer"
        app
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

      <template v-slot:append>
        <div class="pa-2">
          <v-btn block>
            Logout
          </v-btn>
        </div>
      </template>
    </v-navigation-drawer>

    <v-app-bar
        app
        color="#A5D6A7"
        dark
    >
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Invoicing</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <div v-if="token">
        <router-view/>
        <v-btn v-on:click="logOut">Log out</v-btn>
      </div>
      <div v-if="!token">
        <v-container>
          Kasutajanimi: <input v-model="userTable.userName">
          Parool: <input v-model="userTable.password">
          <v-btn v-on:click="login">Login</v-btn>
          <v-btn v-on:click="getData">Get data</v-btn>
        </v-container>
      </div>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: null,
    items: [
      {title: 'Home', icon: 'mdi-home', to: '/'},
      {title: 'Invoices', icon: 'mdi-file-document-edit-outline', to: '/Invoices'},
      {title: 'Clients', icon: 'mdi-account-group', to: '/Clients'},
      {title: 'My Profile', icon: 'mdi-account-cog-outline', to: '/MyProfile'},
    ],
    token: ''
  }),
  methods: {
    login() {
      this.$http.post('api/protect/login', this.user)
          .then(result => {
            this.token = result.data
            localStorage.setItem('user-token', this.token)
            this.$http.defaults.headers.common['Authorization'] = "Bearer " + this.token
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
    }
  }
}
</script>