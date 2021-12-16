<template>
  <div class="home pa-10">
    <h1>My Profile</h1>
<br><br>
    <table style="margin-left: 10px">
      <tr>
        <th>
          <p class="text-md-left" >
            USER PROFILE REGISTER PAGE</p>
        </th>
      </tr>
      <tr>
        <td>Login name*</td>
        <td><input v-model:placeholder="company.userName" placeholder="login name"></td>
      </tr>
      <tr>
        <td>Password*</td>
        <td><input v-model:placeholder="company.password" placeholder="password"></td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left" >
            GENERAL DETAILS</p>
        </th>
      </tr>
      <tr>
        <td>Company name*</td>
        <td><input v-model:placeholder="company.companyName" placeholder="company name"></td>
      </tr>
      <tr>
        <td>Register no.*</td>
        <td><input v-model:placeholder="company.regNr" placeholder="registerNo"></td>
      </tr>
      <tr>
        <td>VAT no.*</td>
        <td><input v-model:placeholder="company.vatCode" placeholder="vatNo"></td>
        <td>Tick box if no VAT<input type="checkbox"></td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left" >
            CONTACT DETAILS</p>
        </th>
      </tr>
      <tr>
        <td>Address*</td>
        <td><input v-model:placeholder="company.address" placeholder="address"></td>
      </tr>
      <tr>
        <td>Country*</td>
        <td><input v-model:placeholder="company.country" placeholder="country"></td>
      </tr>
      <tr>
        <td>Post code*</td>
        <td><input v-model:placeholder="company.postalCode" placeholder="post code"></td>
      </tr>
      <tr>
        <td>E-mail*</td>
        <td><input v-model:placeholder="company.eMail" placeholder="email"></td>
      </tr>
      <tr>
        <td>Phone number</td>
        <td><input v-model:placeholder="company.phoneNr" placeholder="phone number"></td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left" >
            BANK ACCOUNTS</p>
        </th>
      </tr>
      <tr>
        <td>Bank name* </td>
        <td><input v-model="company.bankName1" placeholder="Bank name"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) *</td>
        <td><input v-model="company.iban1" placeholder="IBAN"></td>
      </tr>
      <tr>
        <td>SWIFT code* </td>
        <td><input v-model="company.swift1" placeholder="SWIFT"></td>
      </tr>
      <tr>
        <td>Bank name 2</td>
        <td><input v-model="company.bankName2" placeholder="Bank name 2"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 2</td>
        <td><input v-model="company.iban2" placeholder="IBAN2"></td>
      </tr>
      <tr>
        <td>SWIFT code 2</td>
        <td><input v-model="company.swift2" placeholder="SWIFT2"></td>
      </tr>
      <tr>
        <td>Bank name 3</td>
        <td><input v-model="company.bankName3" placeholder="Bank name 3"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 3</td>
        <td><input v-model="company.iban3" placeholder="IBAN3"></td>
      </tr>
      <tr>
        <td>SWIFT code 3</td>
        <td><input v-model="company.swift3" placeholder="SWIFT3"></td>
      </tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left" >
             ADDITIONAL DETAILS</p>
        </th>
      </tr>
      <tr>
        <td>E-mail text by default</td>
        <td><input v-model="company.emailText" placeholder="email"></td>
      </tr>
      <tr>
        <td>Invoice payment period by default(days):</td>
        <td><input v-model="company.paymentDeadline" placeholder="payment due days"></td>
      </tr>
      <tr>
        <td>Delay penalty % by default</td>
        <td><input v-model="company.delayPenalty" placeholder="delay penalty %"></td>
      </tr>
      <tr>
        <td>Measurement unit by default</td>
        <td><input v-model="company.unit" placeholder="unit"></td>
      </tr>
      <tr>
        <td>Logo</td>
        <td><input v-model:placeholder="company.logoFail" placeholder="logo"></td>
      </tr>

      <tr></tr>

    </table>
    <br><br>
    <v-btn class="pa-3" @click="registerCompany()">SAVE</v-btn>

  </div>
</template>

<script>
import router from "@/router";
import App from "@/App";

export default {
  data: function () {
    return {
      company: {},
      newCompany:{},
    }
  },
  methods: {
    registerCompany: function () {
      this.$http.post("api/public/registercompany/", this.company)
      .then (response => {
        alert ("Company registered")
        location.reload()
      })
    },
  }
}

</script>