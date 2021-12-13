

<template>

  <div class="home pa-10">
    <h1>VAT Codes</h1><br><br><br>

    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn @click="createClient()">NEW VAT CODE</v-btn>
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

    <v-data-table
      :headers="headers"
      :items="myitems"
      hide-default-header
  >

    <template v-slot:header="{ props: { headers } }">
      <thead>
      <tr>
        <th v-for="h in headers" :class="h.class">
          <span>{{h.text}}</span>
        </th>
      </tr>
      </thead>
    </template>
  </v-data-table>
  </div>
</template>

<script>
export default {
  name: 'MyComponent',

  data () {
    return {
      headers:[
        { text: 'VAT CODE', value: 'first', class: 'my-header-style' },
        { text: 'VALUE', value: 'thing', class: 'my-header-style' },

      ],
      myitems : []
    }
  }
}
</script>



<style scoped>
.some-other-style {
  background: white;

}
.my-header-style {
  color: #808080 !important;
  background-color: darkseagreen;
  padding: 0px;
  padding-left: 2.5%;
  font-color: white;
  font-size: 1000px;
}


</style>

<div class="home pa-10">
<h1>VAT Codes</h1><br><br><br>


<div>
  <v-row>
    <v-col sm="6" md="6">
      <v-btn @click="createVat()">NEW VAT CODE</v-btn>
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
</div>