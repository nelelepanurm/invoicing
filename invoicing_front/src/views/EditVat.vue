<template>
  <div class="home pa-10">

    VAT description: <input v-model="vatDesc" placeholder="clientName"> <br>
    VAT percent: <input v-model="vatPercent" placeholder="regNr"> <br>
    <br>
    <br>
    <v-btn v-on:click="changeVat()">SAVE</v-btn>
  </div>
</template>

<script>
// @ is an alias to /src

import router from "../router";

export default {
  data: function () {
    return {
      vat: [],
      vatDesc: "",
      vatPercent: "",
      id: "",
    }
  },
  methods: {
    getVatByID: function (id) {
      this.$http.get("api/getvat/" + id)
          .then(response => {
            this.vatDesc = response.data.vatDesc
            this.vatPercent = response.data.vatPercent
            this.id = response.data.id
          })
    },
    changeVat: function () {
      let vat = {}
      vat.vatDesc = this.vatDesc
      vat.vatPercent = this.vatPercent
      vat.id = this.id
      this.$http.post("api/invoicing/changevat", vat)
      alert("VAT data updated!")
      router.push({name: 'Vat'})
    },

  }, mounted() {
    let vat = this.getVatByID(this.$route.params.id)
    console.log(vat);

  }

}


</script>

<style>
table {
  margin-left: auto;
  margin-right: auto;

}
</style>