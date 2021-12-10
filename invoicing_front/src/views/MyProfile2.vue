<template>
  <div class="home pa-10">
    <h1>My Profile</h1>
<br><br>
    <table>
      <tr>
        <th>
          <p class="text-md-left" >
            USER PROFILE</p>
        </th>
      </tr>
      <tr>
        <td>Login name</td>
        <td><input v-model:placeholder="loginName" placeholder="login name"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td class="mytdStyle">rida 1 tulp2</td>
      </tr>
      <tr>
        <td>Password again</td>
        <td><input v-model:placeholder="password" placeholder="password"></td>
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
        <td>Company name</td>
        <td><input v-model:placeholder="companyName" placeholder="company name"></td>
      </tr>
      <tr>
        <td>Register no.</td>
        <td><input v-model:placeholder="registerNo" placeholder="registerNo"></td>
      </tr>
      <tr>
        <td>VAT no.</td>
        <td><input v-model:placeholder="vatNo" placeholder="vatNo"></td>
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
        <td>Address</td>
        <td><input v-model:placeholder="address" placeholder="address"></td>
      </tr>
      <tr>
        <td>Country</td>
        <td><input v-model:placeholder="country" placeholder="country"></td>
      </tr>
      <tr>
        <td>Post code</td>
        <td><input v-model:placeholder="postCode" placeholder="post code"></td>
      </tr>
      <tr>
        <td>E-mail</td>
        <td><input v-model:placeholder="email" placeholder="email"></td>
      </tr>
      <tr>
        <td>Phone number</td>
        <td><input v-model:placeholder="phoneNumber" placeholder="phone number"></td>
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
        <td>Bank name </td>
        <td><input v-model:placeholder="bankName" placeholder="Bank name"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) </td>
        <td><input v-model:placeholder="IBAN" placeholder="IBAN"></td>
      </tr>
      <tr>
        <td>SWIFT code </td>
        <td><input v-model:placeholder="SWIFT" placeholder="SWIFT"></td>
      </tr>
      <tr>
        <td>Bank name 2</td>
        <td><input v-model:placeholder="bankName2" placeholder="Bank name 2"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 2</td>
        <td><input v-model:placeholder="IBAN2" placeholder="IBAN2"></td>
      </tr>
      <tr>
        <td>SWIFT code 2</td>
        <td><input v-model:placeholder="SWIFT2" placeholder="SWIFT2"></td>
      </tr>
      <tr>
        <td>Bank name 3</td>
        <td><input v-model:placeholder="bankName3" placeholder="Bank name 3"></td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 3</td>
        <td><input v-model:placeholder="IBAN3" placeholder="IBAN3"></td>
      </tr>
      <tr>
        <td>SWIFT code 3</td>
        <td><input v-model:placeholder="SWIFT3" placeholder="SWIFT3"></td>
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
        <td><input v-model:placeholder="email" placeholder="email"></td>
      </tr>
      <tr>
        <td>Invoice payment period by default(days):</td>
        <td><input v-model:placeholder="paymendDueDay" placeholder="payment due days"></td>
      </tr>
      <tr>
        <td>Delay penalty % by default</td>
        <td><input v-model:placeholder="delayPenalty" placeholder="delay penalty %"></td>
      </tr>
      <tr>
        <td>Measurement unit by default</td>
        <td><input v-model:placeholder="unit" placeholder="unit"></td>
      </tr>
      <tr>
        <td>Logo</td>
        <td><input v-model:placeholder="logo" placeholder="logo"></td>
      </tr>

      <tr></tr>


      <tr v-for="profile in profiles">
        <td>{{ profile.loginName }}</td>
        <td>{{ profile.password }}</td>
        <td>{{ profile.passwordAgain }}</td>
        <td>{{ profile.companyName }}</td>
        <td>{{ profile.Registerno }}</td>
        <td>{{ profile.VATno }}</td>
        <td>{{ profile.Address }}</td>
        <td>{{ profile.country }}</td>
        <td>{{ profile.postCode }}</td>
        <td>{{ profile.eMail }}</td>
        <td>{{ profile.phone }}</td>
        <td>{{ profile.bankName1 }}</td>
        <td>{{ profile.account1 }}</td>
        <td>{{ profile.swift1 }}</td>
        <td>{{ profile.bankName2 }}</td>
        <td>{{ profile.account2 }}</td>
        <td>{{ profile.swift2 }}</td>
        <td>{{ profile.bankName3 }}</td>
        <td>{{ profile.account3 }}</td>
        <td>{{ profile.swift3 }}</td>
        <td>{{ profile.emailText }}</td>
        <td>{{ profile.payment }}</td>
        <td>{{ profile.delay }}</td>
        <td>{{ profile.unit }}</td>
        <td>{{ profile.logo }}</td>


      </tr>


    </table>
    <br><br>
    <v-btn class="pa-3" @click="saveChanges()">SAVE CHANGES</v-btn>

  </div>
</template>
