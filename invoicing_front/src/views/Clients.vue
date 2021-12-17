<template>
  <div class="home pa-10">
    <h1>Clients</h1><br><br><br>

    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn v-on:click="createClient()">NEW CLIENT</v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col sm="6" md="6">
          <v-text-field
              label="search"
              placeholder="Placeholder"
              solo
              @keyup="search = $event.target.value; getClientList()"
          >
          </v-text-field>
        </v-col>
      </v-row>
    </div>
    <table>
      <tr>
        <th v-on:click="orderBy('id')">ID</th>
        <th v-on:click="orderBy('client_name')">NAME</th>
        <th v-on:click="orderBy('reg_nr')">REG NO.</th>
        <th v-on:click="orderBy('vat_nr')">VAT NO.</th>
        <th v-on:click="orderBy('address')">ADDRESS</th>
        <th v-on:click="orderBy('country')">COUNTRY</th>
        <th v-on:click="orderBy('postal_code')">POST CODE</th>
        <th v-on:click="orderBy('e_mail')">E-MAIL</th>
        <th v-on:click="orderBy('phone_nr')">PHONE</th>
        <th v-on:click="orderBy('contact_person')">CONTACT PERSON</th>
      </tr>

      <tr v-for="client in clients">
        <td>{{ client.id }}</td>
        <td>{{ client.clientName }}</td>
        <td>{{ client.regNr }}</td>
        <td>{{ client.vatNr }}</td>
        <td>{{ client.address }}</td>
        <td>{{ client.country }}</td>
        <td>{{ client.postCode }}</td>
        <td>{{ client.eMail }}</td>
        <td>{{ client.phoneNr }}</td>
        <td>{{ client.contactPerson }}</td>

        <td>
          <v-btn v-on:click="changeClient(client.id)">Edit</v-btn>
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
      search:"",


    }
  },
  methods: {

    createClient: function () {
      router.push({name: "CreateClient"})
    },

    getClientList: function () {

      this.$http.get('api/client/getclient', {
        params: {
          search: this.search
        }
      })
          .then(response => {
            this.clients = response.data;
          })
    },

    changeClient: function (id) {
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


