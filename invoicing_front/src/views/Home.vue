<template>
  <div class="home pa-10">
    <h1>Lets get started!</h1>
    <p>
      Welcome to Invoicing page!<br>
      To start using Invoicing, please <v-btn @click="logIn()" >LOG IN</v-btn><br>
    </p><br><br>
    <p> Don't have an account yet? <br> Register <v-btn @click="registerHere()">HERE</v-btn> </p>
  </div>
</template>

<script>

export default {
  data: function () {
    return {
      logIn: {},
      registerHere: {}
    }
  },
  methods: {

  }
}

</script>
