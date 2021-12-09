<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      Invoicing is here to help you create sales invoices to your customers.<br>
      To start using Invoicing, please LOG IN. <br>
      Don't have an account yet? Register HERE.
      <br>
    </p>

    <h3>Interesting Links</h3>
    <ul>
      <li><a href="https://emta.ee/" target="_blank" rel="noopener">Maksu- ja Tolliamet</a></li>
      <li><a href="https://e-resident.gov.ee/start-a-company/" target="_blank" rel="noopener">E-Residency</a></li>
      <li><a href="https://aripaev.ee/" target="_blank" rel="noopener">Latest business news</a></li>
    </ul>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #1A2620FF;
}
</style>
