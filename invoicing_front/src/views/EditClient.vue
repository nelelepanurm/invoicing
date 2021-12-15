<template>
  <div class="home pa-10">

    Name:  <input v-model="clientName" placeholder = "clientName"> <br>
    Register no.:  <input v-model="regNr" placeholder = "regNr"> <br>
    VAT no.:  <input v-model="vatNr" placeholder = "vatNr"> <br>
    Address:  <input v-model="address" placeholder = "address"> <br>
    Country:  <input v-model="country" placeholder = "country"> <br>
    Postcode:  <input v-model="postCode" placeholder = "postCode"> <br>
    E-mail:  <input v-model="eMail" placeholder = "eMail"> <br>
    Phone number:  <input v-model="phoneNr" placeholder = "phoneNr"> <br>
    Contact person:  <input v-model="contactPerson" placeholder = "contactPerson"> <br>
    <br>
    <br>

    <v-btn v-on:click="changeClient()">CHANGE CLIENT</v-btn>


  </div>
</template>

<script>
// @ is an alias to /src

import router from "../router";

export default {
  data: function () {
    return {


      client: [],
      clientName: "",
      regNr: "",
      vatNr: "",
      address: "",
      country: "",
      postCode : "",
      eMail: "",
      phoneNr: "",
      contactPerson: "",
      id: "",




    }
  },
  methods: {
    getClientId: function (id) {
      this.$http.get("api/getclient/" + id)
          .then(response => {
            this.clientName = response.data.clientName
            this.regNr = response.data.regNr
            this.vatNr = response.data.vatNr
            this.address = response.data.address
            this.country = response.data.country
            this.postCode = response.data.postCode
            this.eMail = response.data.eMail
            this.phoneNr = response.data.phoneNr
            this.contactPerson = response.data.contactPerson
            this.id = response.data.id
          })
    },
    changeClient: function () {
      let client = {}
      client.clientName = this.clientName
      client.regNr = this.regNr
      client.vatNr = this.vatNr
      client.address = this.address
      client.country = this.country
      client.postCode = this.postCode
      client.eMail = this.eMail
      client.phoneNr = this.phoneNr
      client.contactPerson = this.contactPerson
      this.$http.put("api/client/change/" + this.id, client)
      alert("Client profile updated!")
      router.push({name: 'Clients'})
    },

    },mounted(){
    let client = this.getClientId(this.$route.params.id)
    console.log(client);

  }

}


</script>

<style>
table {
  margin-left: auto;
  margin-right: auto;

}
</style>