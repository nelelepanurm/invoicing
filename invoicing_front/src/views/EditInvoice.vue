<template>
  <v-container>
    <v-row class="mt-10">
      <v-col cols="12" sm="6">
        <h2>
          Seller
        </h2>
        <p>
          <input disabled v-model:placeholder="company.companyName"><br>
          <input disabled v-model:placeholder="company.address"><br>
          <input disabled v-model:placeholder="company.postalCode"><br>
          <input disabled v-model:placeholder="company.country"><br>
          <input disabled v-model:placeholder="company.phoneNr"><br>
          <input disabled v-model:placeholder="company.eMail"><br>
        </p>
        <h2 class="grey py-1 mt-9 pl-2 mr-10">BILL TO</h2>
        <p>
          <v-col
              class="d-flex"
              cols="12"
              sm="6"
          >
            <v-select
                :items="clientList"
                item-text="clientName"
                label="search client"
                dense
                outlined
            ></v-select>
            <v-btn @click="newClient()">NEW CLIENT</v-btn>
          </v-col>
          <input disabled v-model:placeholder="clientList.clientName"><br>
          <input disabled v-model:placeholder="clientList.address"><br>
          <input disabled v-model:placeholder="clientList.postCode"><br>
          <input disabled v-model:placeholder="clientList.country"><br>
          <input disabled v-model:placeholder="clientList.phoneNr"><br>
          <input disabled v-model:placeholder="clientList.eMail"><br>
        </p>
      </v-col>

      <v-col cols="12" sm="6">
        <h2 class="grey py-1 mt-9 pl-2 mr-10">
          Invoice No
          <input v-model="invoice.invoiceNr" placeholder="invoice number here">
        </h2>
        <v-flex class="py-6 my-3 ">
          <table>
            <tr>
              <td> Invoice Date:</td>
              <td><input type="date" v-model="invoiceDate"></td>
              <br>
            </tr>
            <tr>
              <td>Payment due:</td>
              <td><input type="date" v-model="invoiceDueDate"></td>
            </tr>
          </table>
        </v-flex>
      </v-col>

    </v-row>

    <div v-for="(itemRows,i) in itemRows" :key="i">
      <v-row align="center">

        <v-col cols="12" sm="5" md="5">
          <v-text-field
              label="Description"
              v-model="item[i]"
              placeholder="Item"

              dense
          ></v-text-field>

        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Price"
              v-model="price[i]"
              placeholder="Price"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="VAT Code"
              v-model="vatCode[i]"
              placeholder="VAT Code"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="VAT Sum"
              v-model="vatSum[i]"
              placeholder="VAT Sum"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Unit"
              v-model="unit[i]"
              placeholder="Unit"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Qty"
              v-model="qty[i]"
              placeholder="Qty"
              @change="calcTotal(i)"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Total"
              v-model="total[i]"
              placeholder="Total"
              dense
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="1" md="1">
          <v-icon medium color="grey darken-1" @click="removeItem(i)"
          >mdi-delete
          </v-icon>

        </v-col>

      </v-row>
    </div>
    <v-btn @click="addItem" class="mt-5">+ Rows</v-btn>
    <div class="float-end mt-12">

      <div class="text--primary font-weight-bold">
        <span class="float-left mr-4">Net Total EUR:</span>
        <span class="float-right">1000</span>
        <br/>
        <span class="float-left mr-4">VAT Rate:</span>
        <span class="float-right">18%</span>
        <br/>
        <span class="float-left mr-4">VAT:</span>
        <span class="float-right">18</span>
        <br/>
        <span class="float-left mr-4">Grand Total EUR:</span>
        <span class="float-right">{{ gtotal }}</span>
        <br/>
        <br/>
      </div>
    </div>
    <br><br><br><br><br><br>
    <div class="float-mt-left">
      <v-btn @click="saveInvoice()" class="mt-5">SAVE</v-btn>

    </div>

  </v-container>


</template>

<script>

export default {

  data: () => ({
    itemRows: [],
    item: [],
    price: [],
    qty: [],
    total: [],
    vatCode: [],
    vatSum: [],
    gtotal: "",
    unit: "",
    clientList: [],
    invoiceNr: {},
    companyName: {},
    address: "",
    postCode: "",
    country: "",
    phoneNr: "",
    eMail: "",
    invoiceDate: "",
    invoiceDueDate: "",
    clientName: {},
    invoice: {},
    company: {},
    client: {},

  }),

  methods: {
    addItem() {
      this.itemRows.push({
        item: "",
        price: "",
        qty: "",
        total: "",
        vatCode: "",
        vatSum: "",
        unit: "",
        theCompany: []
      });
    },
    calcTotal(i) {
      let price = this.price[i];
      let qty = this.qty[i];
      let total = price * qty;
      this.total[i] = parseInt(total);
      this.gtotal[i] = parseInt(total);
      console.log("Data " + total);

    },
    removeItem(index) {
      this.itemRows.splice(index, 1);
    },
    getCompany: function () {
      this.$http.get('api/getcompany')
          .then(response => {
            this.company = response.data
          })
    },
    saveInvoice: function () {
      this.$http.post("api/invoicing/saveinvoice", this.invoice)
    },
    // newClient: function () {
    // router.push({name: 'CreateClient'})
    // }
    getClientList: function () {
      this.$http.get('api/client/')
          .then(response => {
            this.clientList = response.data;
          })
    }



  },
  mounted() {
    this.addItem()
    let theCompany = this.getCompany()
    console.log(theCompany)
    this.getClientList()
  }
}
</script>