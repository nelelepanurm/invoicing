<template>
  <v-app id="inspire">
    <v-navigation-drawer
        v-model="drawer"
        app

        class="deep-purple accent-4"
        dark
        permanent
    >
      <v-list>
        <v-list-item
            v-for="item in items"
            :key="item.title"
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

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Invoicing</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <!--  -->
    </v-main>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: null,
    items: [
      { title: 'Home', icon: 'mdi-view-dashboard' },
      { title: 'Invoices', icon: 'mdi-account-box' },
      { title: 'Clients', icon: 'mdi-gavel' },
      { title: 'My Profile', icon: 'mdi-gavel' },
    ],
  }),
}
</script>