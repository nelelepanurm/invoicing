<template>
  <div class="pageView">
    <h1>Invoices</h1>
    <div>
    <div class ="myButtonDiv"><a class="myButtonA" href="javascript: createNewInvoice()" >New Invoice</a> </div>
    <div class ="mySearchDiv" > <input placeholder="search"></div>

      <button> SEND TO EMAIL </button>
    </div>
    <br><br>
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


