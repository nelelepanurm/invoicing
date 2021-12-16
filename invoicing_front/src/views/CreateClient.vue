<template>
  <div class="home pa-10">
    Name*:  <input v-model="client.clientName"> <br>
    Register no.*:  <input v-model="client.regNr"> <br>
    VAT no.:  <input v-model="client.vatNr"> <br>
    Address*:  <input v-model="client.address"> <br>
    Country*:  <input v-model="client.country"> <br>
    Postcode:  <input v-model="client.postCode"> <br>
    E-mail*:  <input v-model="client.eMail"> <br>
    Phone number:  <input v-model="client.phoneNr"> <br>
    Contact person:  <input v-model="client.contactPerson"> <br>
    <br>
    <br>

    <v-btn v-on:click="createClient()">SAVE CLIENT</v-btn>


  </div>
</template>

<script>
// @ is an alias to /src

import router from "../router";

export default {
  data: function () {
    return {


      client: {},
      newClient:{},




    }
  },
  methods: {
    createClient: function () {
      this.$http.post("api/client/createclient/", this.client)
          .then(response => {
            this.newClient = response.data
            alert("New client created!");
            router.push({name:"Clients"})
          }).catch(function(error){
            console.log(error.response.data.message2);
            alert(error.response.data.message2);

      })
      //alert("New client created!");
      //router.push({name:"Clients"})

    },
  }

}


</script>

<style>
table {
  margin-left: auto;
  margin-right: auto;

}
</style>