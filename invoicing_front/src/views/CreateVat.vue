<template>
  <div class="home pa-10">
    <h1>Create new VAT type</h1><br><br><br>
    VAT Description:  <input v-model="vat.vatDesc"> <br>
    VAT Percent:  <input v-model="vat.vatPercent"> <br>
    <br>
    <br>
    <v-btn v-on:click="createVatType()">SAVE NEW VAT TYPE</v-btn>
  </div>
</template>

<script>
// @ is an alias to /src

import router from "../router";

export default {
  data: function () {
    return {
      vat: {},
      newVat:{},
    }
  },
  methods: {
    createVatType: function () {
      this.$http.post("api/invoicing/vat", this.vat)
          .then(response => {
            this.newVat = response.data
            alert("New VAT type is created!");
            router.push({name:"Vat"})
          })
      }
  }

}


</script>

<style>
table {
  margin-left: auto;
  margin-right: auto;

}
</style>