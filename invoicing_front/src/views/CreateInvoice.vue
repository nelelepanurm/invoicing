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
                item-value="id"
                label="search client"
                dense
                outlined
                @change="refreshClientData($event)"
            ></v-select>
          </v-col>
          <input disabled v-model:placeholder="client.clientName"><br>
          <input disabled v-model:placeholder="client.address"><br>
          <input disabled v-model:placeholder="client.postCode"><br>
          <input disabled v-model:placeholder="client.country"><br>
          <input disabled v-model:placeholder="client.phoneNr"><br>
          <input disabled v-model:placeholder="client.eMail"><br>
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
              <td><input type="date" v-model="invoice.invoiceDate"></td>
              <br>
            </tr>
            <tr>
              <td>Payment due:</td>
              <td><input type="date" v-model="invoice.invoiceDueDate"></td>
            </tr>
          </table>
        </v-flex>
      </v-col>
    </v-row>

    <div v-for="(itemRow, i) in invoice.itemRows" :key="i">
      <v-row align="center">
        <v-col cols="12" sm="5" md="5">
          <v-text-field
              label="Description"
              v-model="itemRow.description"
              placeholder="Item"
              dense
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Unit"
              v-model="itemRow.unit"
              placeholder="Unit"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Qty"
              v-model.number="itemRow.quantity"
              placeholder="Qty"
              @change="calculateRowAmounts(itemRow)"
              dense
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Price"
              v-model.number="itemRow.unitPrice"
              @change="calculateRowAmounts(itemRow)"
              placeholder="Price"
              dense
          ></v-text-field>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-select
              :items="vatList"
              v-model="itemRow.vatValue"
              item-text="vatPercent"
              item-value="vatPercent"
              label="vat"
              dense
              outlined
              @change="calculateRowAmounts(itemRow)"
          ></v-select>
        </v-col>

        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="VAT Sum"
              v-model="itemRow.vatSum"
              disabled
              dense
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="1" md="1">
          <v-text-field
              label="Total"
              v-model="itemRow.total"
              disabled
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
        <span class="float-right">{{ invoice.totalNetSum }}</span>
        <br/>
        <span class="float-left mr-4">VAT:</span>
        <span class="float-right">{{ invoice.totalVatSum }}</span>
        <br/>
        <span class="float-left mr-4">Grand Total EUR:</span>
        <span class="float-right">{{ invoice.totalSum }}</span>
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

import router from "@/router";

export default {

  data: () => ({
    item: [],
    unit: [],
    quantity: [],
    vatCode: [],
    vatSum: [],
    clientList: [],
    companyProfileId: {},
    address: "",
    postCode: "",
    country: "",
    phoneNr: "",
    eMail: "",
    invoice: {
      itemRows: []
    },
    company: {},
    vatList: [],
    vatValue: [],
    totalNetSum: 0,
    totalVatSum: 0,
    client: {}


  }),

  methods: {
    addItem() {
      this.invoice.itemRows.push({});
    },
    calcTotal() {
        this.invoice.totalSum = 0;
        this.invoice.totalVatSum = 0;
        this.invoice.totalNetSum = 0;

      for (let i = 0; i < this.invoice.itemRows.length; i++) {
        let invoiceRow = this.invoice.itemRows[i];
        this.invoice.totalNetSum = invoiceRow.quantity * invoiceRow.unitPrice;
        this.invoice.totalSum = this.invoice.totalSum + invoiceRow.total;
        this.invoice.totalVatSum = this.invoice.totalVatSum + invoiceRow.vatSum;
      }
    },

    removeItem(index) {
      this.invoice.itemRows.splice(index, 1);
      this.calcTotal();
    },
    getCompany: function () {
      this.$http.get('api/getcompany')
          .then(response => {
            this.company = response.data
            this.invoice.companyProfileId = this.company.id
          })
    },
    saveInvoice: function () {
      this.$http.post("api/invoicing/saveinvoice", this.invoice)
      .then(response => {
        alert ("saved")
      })
    },
    getClientList: function () {
      this.$http.get('api/client/getallclients')
          .then(response => {
            this.clientList = response.data;
          })
    },
    refreshClientData: function (event) {
      console.log(event)
      this.$http.get('api/getclient/' + event)
          .then(response => {
            this.invoice.clientId = response.data.id
            this.client = response.data
          })
    },
    getVatList: function () {
      this.$http.get('api/vatlist')
          .then(response => {
            this.vatList = response.data;
          })
    },
    calculateRowAmounts: function (invoiceRow) {
      console.log(JSON.stringify(invoiceRow))
      let price = invoiceRow.unitPrice != undefined ? invoiceRow.unitPrice : 0;
      let vat = invoiceRow.vatValue != undefined ? invoiceRow.vatValue : 0;
      let qty = invoiceRow.quantity != undefined ? invoiceRow.quantity : 0;
      console.log(vat)
      invoiceRow.vatSum = (price * qty * vat/100.0);
      invoiceRow.total = (price * qty + invoiceRow.vatSum);
      this.calcTotal();

    }
  },
  mounted() {
    this.addItem()
    let theCompany = this.getCompany()
    console.log(theCompany)
    this.getClientList()
    this.getVatList()
  }
}
</script>