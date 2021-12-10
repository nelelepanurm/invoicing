<template>
  <div class="home pa-10">
    <h1>Invoices</h1><br><br><br>
    <div>
      <div>
        <v-row >
            <v-btn class="pa-3" @click="createNewInvoice()">NEW INVOICE</v-btn>

      <div>
        <v-col
            cols="12"
            md="12">
          <v-text-field
              class="pa-3"
              label="search"
              placeholder="Placeholder"
              solo >
          </v-text-field>
        </v-col>
      </div>
        </v-row>
      </div>

      <button> SEND TO EMAIL button needed when invoice is opened</button>
    </div>
    <br>
    <table border="1">
      <tr>
        <th class="myTableHeader"><a v-on:click="orderBy('client_name')">CLIENT</a></th>
        <th class="myTableHeader" v-on:click="orderBy('invoice_number')">INVOICE NO</th>
        <th class="myTableHeader" v-on:click="orderBy('total_sum')">SUM WITH VAT</th>
        <th class="myTableHeader" v-on:click="orderBy('invoice_date')">INVOICE DATE</th>
        <th class="myTableHeader" v-on:click="orderBy('payment_due_date')">DUE DATE</th>
      </tr>
      <tr v-for="invoice in invoices">
        <td>{{ invoice.cliendId }}</td>
        <td>{{ invoice.invoiceNumber }}</td>
        <td>{{ invoice.totalSum }}</td>
        <td>{{ invoice.invoiceDate }}</td>
        <td>{{ invoice.paymentDueDate }}</td>
      </tr>
    </table>

  </div>
</template>


