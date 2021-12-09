<template>
  <div class="pageView">
    <h1>My Profile</h1>

    <table>
      <tr>
        <th>
          USER PROFILE
        </th>
      </tr>
      <tr>
        <td>Login name</td>
        <td class="mytdStyle"> rida 1 tulp2</td>
      </tr>
      <tr>
        <td>Password</td>
        <td class="mytdStyle">rida 1 tulp2</td>
      </tr>
      <tr>
        <td>Password again</td>
        <td>rida 1 tulp2</td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>GENERAL DETAILS</th>
      </tr>
      <tr>
        <td>Company name</td>
        <td>rida 1 tulp4</td>
      </tr>
      <tr>
        <td>Register no.</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>VAT no.</td>
        <td>tere</td>
        <td>Tick box if no VAT<input type="checkbox"></td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>CONTACT DETAILS</th>
      </tr>
      <tr>
        <td>Address</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Country</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Post code</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>E-mail</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Phone</td>
        <td>tere</td>
      </tr>
      <tr></tr>
      <br>
      <tr>
        <th>BANK ACCOUNTS</th>
      </tr>
      <tr>
        <td>Bank name 1</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 1</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>SWIFT code 1</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Bank name 2</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 2</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>SWIFT code 2</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Bank name 3</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Bank account no.(IBAN) 3</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>SWIFT code 3</td>
        <td>tere</td>
      </tr>
      <br>
      <tr>
        <th>ADDITIONAL DETAILS</th>
      </tr>
      <tr>
        <td>E-mail text by default</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Invoice payment period by default(days):</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Delay penalty % by default</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Measurement unit by default</td>
        <td>tere</td>
      </tr>
      <tr>
        <td>Logo</td>
        <td>tere</td>
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
    <br> <br>
    <button class= "myButtonDiv2" v-on:click="saveChanges">SAVE CHANGES</button>

  </div>
</template>
