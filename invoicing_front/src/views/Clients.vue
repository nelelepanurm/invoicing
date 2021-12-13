<template>
  <div class="home pa-10">
    <h1>Clients</h1><br><br><br>

    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn @click="createClient()">NEW CLIENT</v-btn>
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


    <table border="1">
      <tr>
        <th class="myTableHeader"><a v-on:click="orderBy('client_name')">NAME</a></th>
        <th class="myTableHeader" v-on:click="orderBy('reg_nr')">REG NO.</th>
        <th class="myTableHeader" v-on:click="orderBy('vat_nr')">VAT NO.</th>
        <th class="myTableHeader" v-on:click="orderBy('address')">ADDRESS</th>
        <th class="myTableHeader" v-on:click="orderBy('country')">COUNTRY</th>
        <th class="myTableHeader" v-on:click="orderBy('postal_code')">POST CODE</th>
        <th class="myTableHeader" v-on:click="orderBy('e_mail')">E-MAIL</th>
        <th class="myTableHeader" v-on:click="orderBy('phone_nr')">PHONE</th>
        <th class="myTableHeader" v-on:click="orderBy('contact_person')">CONTACT PERSON</th>


      </tr>
      <tr v-for="client in clients">
        <td>{{ client.clientName }}</td>
        <td>{{ client.regNr }}</td>
        <td>{{ client.vatNr }}</td>
        <td>{{ client.address }}</td>
        <td>{{ client.country }}</td>
        <td>{{ client.postCode }}</td>
        <td>{{ client.eMail }}</td>
        <td>{{ client.phoneNr }}</td>
        <td>{{ client.contactPerson }}</td>

      </tr>
    </table>


  </div>
</template>
