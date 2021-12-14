<template>
  <v-container>
    <v-row class="mt-10">
      <v-col cols="12" sm="6">
        <h4>
          Company Name
        </h4>
        <p>
          Address <br />
          Postcode <br />
          Country<br />
          Phone<br />
          E-mail Address<br />
        </p>
        <h6 class="grey py-1 mt-9 pl-2 mr-10">BILL TO</h6>
        <p>
        Company/Customer Name: <input v-model:placeholder="customername" placeholder="name"><br />
        Address: <input v-model:placeholder="address" placeholder="address"><br />
          Postcode: <input v-model:placeholder="postcode" placeholder="postcode"><br />
          Country: <input v-model:placeholder="country" placeholder="country"><br />
          Phone: <input v-model:placeholder="phone" placeholder="phone"><br />
          E-mail Address: <input v-model:placeholder="email" placeholder="e-mail address"><br />
        </p>



      </v-col>
      <v-col cols="12" sm="6">
        <h2>
          Invoice
        </h2>
        <h6 class="mt-5">
            <v-layout row wrap>
              <v-flex xs5 class="grey py-1">
                <span>INVOICE NUMBER</span><br />
              </v-flex>
              <v-flex xs5 class="grey py-1">
                <span>INVOICE DATE</span><br />
              </v-flex>
            </v-layout>
          <v-layout row wrap>
            <v-flex xs5>
              <span>001</span>
            </v-flex>
            <v-flex xs5>
              <span><p><input type="date" v-model="invoiceDate"></p></span>
            </v-flex>
          </v-layout>
          <v-layout row wrap class="mt-9">
            <v-flex xs5 class="grey py-1">
              <span>CUSTOMER ID</span><br />
            </v-flex>
            <v-flex xs5 class="grey py-1">
              <span>DUE DATE</span><br />
            </v-flex>
          </v-layout>
          <v-layout row wrap>
            <v-flex xs5>
              <span>C-001</span>
            </v-flex>
            <v-flex xs5>
              <span><p> <input type="date" v-model="invoiceDate"></p></span>
            </v-flex>
          </v-layout>
        </h6>
        </v-col>
    </v-row>

    <div v-for="(itemRows,i) in itemRows" :key="i">
    <v-row align="center">

      <v-col cols="12" sm="5" md="5">
        <v-text-field
          label="Item"
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
                >mdi-delete</v-icon>

      </v-col>

    </v-row>
    </div>
   <v-btn @click="addItem" class="mt-5">+ Items</v-btn>

    <div class ="float-right mt-12">


      <div class="text--primary font-weight-bold">
        <span class="float-left mr-4">Net Total EUR:</span>
        <span class="float-right">1000</span>
        <br />
        <span class="float-left mr-4">VAT Rate:</span>
        <span class="float-right">18%</span>
        <br />
        <span class="float-left mr-4">VAT:</span>
        <span class="float-right">18</span>
        <br />
        <span class="float-left mr-4">Grand Total EUR:</span>
        <span class="float-right">{{ gtotal }}</span>
        <br />
        <br />
      </div>
    </div>

  </v-container>





</template>

<script>

export default{

  data:() => ({
    itemRows: [],
    item:[],
    price:[],
    qty:[],
    total:[],
    vatCode:[],
    vatSum:[],
    gtotal:"",
    unit:"",
  }),

  methods:{
    addItem(){
      this.itemRows.push({
        item:"",
        price:"",
        qty:"",
        total:"",
        vatCode:"",
        vatSum:"",
        unit:"",
      });

    },
    calcTotal(i){
      let price = this.price[i];
      let qty = this.qty[i];
      let total = price * qty;
      this.total[i] =parseInt(total);
      this.gtotal[i] =parseInt(total);
      console.log("Data " + total);

    },
    removeItem(index){
      this.itemRows.splice(index,1);
    },
  },
  created(){
    this.addItem();

  },
};
</script>