<template>
  <div class="home pa-10">
    <h1>My Profile</h1>
    <br><br>
    <table>
      <tr>
        <th>
          <p class="text-md-left">
            USER PROFILE</p>
        </th>
      </tr>
      <tr>
        <td>Login name*</td>
        <td>{{ userName }}</td>
      </tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left">
            GENERAL DETAILS</p>
        </th>
      </tr>
      <tr>
        <td>Company name*</td>
        <td><input v-model:placeholder="myProfile.companyName"></td>
      </tr>
      <tr>
        <td>Register no.*</td>
        <td><input v-model:placeholder="myProfile.regNr"></td>
      </tr>
      <tr>
        <td>VAT no.*</td>
        <td><input v-model:placeholder="myProfile.vatCode"></td>
        <td>Tick box if no VAT<input type="checkbox"></td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left">
            CONTACT DETAILS</p>
        </th>
      </tr>
      <tr>
        <td>Address*</td>
        <td><input v-model:placeholder="myProfile.address"></td>
      </tr>
      <tr>
        <td>Country*</td>
        <td><input v-model:placeholder="myProfile.country"></td>
      </tr>
      <tr>
        <td>Post code</td>
        <td><input v-model:placeholder="myProfile.postalCode"></td>
      </tr>
      <tr>
        <td>E-mail*</td>
        <td><input v-model:placeholder="myProfile.eMail"></td>
      </tr>
      <tr>
        <td>Phone number</td>
        <td><input v-model:placeholder="myProfile.phoneNr"></td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left">
            BANK ACCOUNTS</p>
        </th>
      </tr>
      <tr>
        <td>Bank name*</td>
        <td><input v-model:placeholder="myProfile.bankName1"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN)*</td>
        <td><input v-model:placeholder="myProfile.iban1"></td>
      </tr>
      <tr>
        <td>SWIFT code*</td>
        <td><input v-model:placeholder="myProfile.swift1"></td>
      </tr>
      <tr>
        <td>Bank name 2</td>
        <td><input v-model:placeholder="myProfile.bankName2"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 2</td>
        <td><input v-model:placeholder="myProfile.iban2"></td>
      </tr>
      <tr>
        <td>SWIFT code 2</td>
        <td><input v-model:placeholder="myProfile.swift2"></td>
      </tr>
      <tr>
        <td>Bank name 3</td>
        <td><input v-model:placeholder="myProfile.bankName3"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 3</td>
        <td><input v-model:placeholder="myProfile.iban3"></td>
      </tr>
      <tr>
        <td>SWIFT code 3</td>
        <td><input v-model:placeholder="myProfile.swift3"></td>
      </tr>
      <br>
      <tr>
        <th>
          <p class="text-md-left">
            ADDITIONAL DETAILS</p>
        </th>
      </tr>
      <tr>
        <td>E-mail text by default</td>
        <td><input v-model:placeholder="myProfile.eMail"></td>
      </tr>
      <tr>
        <td>Invoice payment period by default(days):</td>
        <td><input v-model:placeholder="myProfile.paymentDeadline"></td>
      </tr>
      <tr>
        <td>Delay penalty % by default</td>
        <td><input v-model:placeholder="myProfile.delayPenalty"></td>
      </tr>
      <tr>
        <td>Measurement unit by default</td>
        <td><input v-model:placeholder="myProfile.unit"></td>
      </tr>
      <tr>
        <td>Logo</td>
        <td><input v-model:placeholder="myProfile.logoFail"></td>
      </tr>

      <tr></tr>


    </table>
    <br><br>

    <v-btn v-on:click="changeCompany()">SAVE CHANGES</v-btn>

  </div>
</template>

<script>

export default {
  data: function () {
    return {
      userName: {},
      //newuser: [],
      //password: {},
      //eMail: {},
      //phoneNr: {},
      //address: {},
      //postalCode: {},
      //country: {},
      //regNr: {},
      //vatCode: {},
      //bankName1: {},
      //bankName2: {},
      //bankName3: {},
      //iban1: {},
      //iban2: {},
      //iban3: {},
      //swift1: {},
      //swift2: {},
      //swift3: {},
      //emailText: {},
      //paymentDeadline: {},
      //delayPenalty: {},
      //unit: {},
      //logoFail: {},
      //companyName: {},
      //profile: {},
     myProfile: {},
      companyProfile: {}

    }
  },
  methods: {
    getLoggedInUser: function () {
      this.$http.get("api/userlogin")
          .then(response => {
            console.log(response.data.userName)
            this.userName = response.data.userName
          })
    },
    getCompany: function () {
      this.$http.get("api/getcompany")
          .then(response => {
            this.myProfile = response.data


          })
    },
    changeCompany: function () {
      this.$http.put("api/company/change/", this.myProfile)
          .then(() => alert("Company profile updated!"))

    }


  },
  mounted() {
    let newuser = this.getLoggedInUser(this.$route.params.userName)
    console.log(newuser);
    this.getCompany();
  }
}


</script>

//companyProfile2.eMail = this.eMail
//companyProfile2.phoneNr = this.phoneNr
//companyProfile2.address=this.address
//companyProfile2.postalCode=this.postalCode
//companyProfile2.country=this.country
//companyProfile2.regNr=this.regNr
//companyProfile2.vatCode=this.vatCode
//companyProfile2.bankName1=this.bankName1
//companyProfile2.iban1=this.iban1
//companyProfile2.swift1=this.swift1
//companyProfile2.bankName2=this.bankName2
//companyProfile2.iban2=this.iban2
// companyProfile2.swift2=this.swift2
//companyProfile2.bankName3=this.bankName3
//companyProfile2.iban3=this.iban3
//companyProfile2.swift3=this.swift3
//companyProfile2.emailText=this.emailText
//companyProfile2.paymentDeadline=this.paymentDeadline
//companyProfile2.delayPenalty=this.delayPenalty
// companyProfile2.unit=this.unit
//companyProfile2.logoFail=this.logoFail
//companyProfile2.companyName=this.companyName
//companyProfile2.myProfile = this.myProfile
//this.$http.put("api/company/change/"+  this.id, companyProfile2)
//alert("Company profile updated!")

