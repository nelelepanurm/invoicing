<template>
  <div className="home pa-10">
    <h1>VAT Codes</h1><br><br><br>

    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn v-on:click="createVat()">New Vat code</v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col sm="6" md="6">
          <v-text-field
              label="search"
              placeholder="Placeholder"
              solo>
          </v-text-field>
        </v-col>
      </v-row>
    </div>
    <table>
      <tr>
        <th v-on:click="orderBy('id')">ID</th>
        <th v-on:click="orderBy('id')">Vat description</th>
        <th v-on:click="orderBy('id')">Vat percent</th>

      </tr>

      <tr v-for="client in clients">
        <td>{{ client.id }}</td>
        <td>{{ client.vatDesc }}</td>
        <td>{{ client.vatPercent }}</td>

        <td>
          <v-btn v-on:click="editVatType(client.id)">Edit</v-btn>
        </td>
        <td>
          <v-btn v-on:click="deleteClient(client.id,client.clientName)">Remove</v-btn>
        </td>
      </tr>
    </table>


  </div>
</template>

<script>
// @ is an alias to /src

import router from "../router";

export default {
  data: function () {
    return {
      clients: {},

    }
  },
  methods: {

    createVat: function () {
      router.push({name: "CreateClient"})
    },

    getVatList: function () {
      this.$http.get('api/client/')
          .then(response => {
            this.clients = response.data;
          })
    },
    editVatType: function (id) {
      console.log(id)
      router.push({name: 'EditClient', params: {id: id}})
    },
    deleteClient: function (id, clientName) {
      if (confirm('Are you sure you want to delete client?')) {
        this.$http.delete("api/client/delete/" + id)
        alert(clientName + ' is now deleted');
        this.getClientList()
      } else {
        alert('Client not deleted');
      }
    }


  },
  mounted() {
    this.getClientList()
  }
}


</script>


