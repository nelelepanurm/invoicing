<template>
  <div class="home pa-10">
    <h1>VAT Codes</h1><br><br><br>

    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn v-on:click="createVat()">New Vat code</v-btn>
        </v-col>
      </v-row>
    </div>
    <v-simple-table class="pa-10">
      <template v-slot:default >
      <tr>
        <th class="text-left" v-on:click="orderBy('id')">ID</th>
        <th class="text-left" v-on:click="orderBy('id')">Vat description</th>
        <th class="text-left" v-on:click="orderBy('id')">Vat percent</th>
      </tr>
      <tr v-for="vatType in vatTypes">
        <td>{{ vatType.id }}</td>
        <td>{{ vatType.vatDesc }}</td>
        <td>{{ vatType.vatPercent }}</td>
        <td>
          <v-btn v-on:click="editVatType(vatType.id)">Edit</v-btn>
        </td>
      </tr>
      </template>
    </v-simple-table>
  </div>
</template>

<script>
// @ is an alias to /src

import router from "../router";

export default {
  data: function () {
    return {
      vatTypes: {},

    }
  },
  methods: {

    createVat: function () {
      router.push({name: "CreateVat"})
    },

    getVatList: function () {
      this.$http.get('api/vatlist/')
          .then(response => {
            this.vatTypes = response.data;
          })
    },
    editVatType: function (id) {
      console.log(id)
      router.push({name: 'EditVat', params: {id: id}})
    },



  },
  mounted() {
    this.getVatList()
  }
}


</script>


