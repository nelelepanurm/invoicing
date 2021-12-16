<template>
  <div class="home pa-10">
    <h1>VAT Codes</h1><br><br><br>
    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn @click="createVAT()">NEW VAT CODE</v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col sm="6" md="6">
          <v-text-field
              label="search"
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
      <tr>
        <th v-for="v in vatdata"
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
        { text: 'VAT ID', value: 'first', class: 'my-header-style' },
        { text: 'VAT Name', value: 'thing', class: 'my-header-style' },
        { text: 'VAT AMOUNT', value: 'thing', class: 'my-header-style' },
      ],
      myitems : []
    }
  },
  methods: {
    getVatList: function () {
      this.$http.get('api/vatlist/')
      .then (response => {
        this.myitems = response.data
      })
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

