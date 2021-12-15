<template>
  <div class="home pa-10">
    <h1>Invoices</h1><br><br><br>


    <div>
      <v-row>
        <v-col sm="6" md="6">
          <v-btn @click="newInvoice()">NEW INVOICE</v-btn>
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

      <button> SEND TO EMAIL button needed when invoice is opened</button>
    </div>
    <br>
    <table border="1">
      <tr>
        <th><a v-on:click="orderBy('client_name')">CLIENT</a></th>
        <th v-on:click="orderBy('invoice_number')">INVOICE NO</th>
        <th v-on:click="orderBy('total_sum')">SUM WITH VAT</th>
        <th v-on:click="orderBy('invoice_date')">INVOICE DATE</th>
        <th v-on:click="orderBy('payment_due_date')">DUE DATE</th>
      </tr>
      <tr v-for="invoice in invoices">
        <td>{{ invoice.cliendId }}</td>
        <td>{{ invoice.invoiceNumber }}</td>
        <td>{{ invoice.totalSum }}</td>
        <td>{{ invoice.invoiceDate }}</td>
        <td>{{ invoice.paymentDueDate }}</td>
        <td>
          <button v-on:click="edit(invoice.id)">Edit</button>
        </td>
        <td>
          <button v-on:click="remove(invoice.id, invoice.invoiceNr)">Remove</button>
        </td>
      </tr>
    </table>

  </div>
</template>
<script>
import router from '../router';

export default {
  data: function () {
    return {
      invoice: {},
      invoices: {}

    }
  },
  methods: {
    getAllInvoices: function () {
      this.$http.get('api/invoicing/')
          .then(response => {
            this.invoices = response.data
          })
    },
    remove: function (id, invoiceNr) {
      if (confirm('Are you sure you want to delete this Invoice?')) {
        this.$http.delete("api/invoicing/deleteinvoice/" + id)
        alert(invoiceNr + ' Deleted');
        this.getAllInvoices()
      } else {
        alert('Invoice not deleted');
      }
    },
    newInvoice: function () {
      router.push({name: 'CreateInvoice'})
    },
  }
}

</script>


