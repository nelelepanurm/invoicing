<template>
  <div class="mainTABLine" id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/home2">Home2</router-link> |
      <router-link to="/invoices">Invoices</router-link> |
      <router-link to="/clients">Clients</router-link> |
      <router-link to="/companyProfile">Company Profile</router-link> |
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #171617FF;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.pageView {
  float: left;
  text-align: left;
  padding-left: 50px;
}

.myTableHeader {
  padding: 10px;
  background-color: darkgrey;
}

.myButtonDiv {
  background-color: #2E7A58FF;
  color: aliceblue;
  width: 200px;
  height: 40px;
  text-align: center;
  font-size: x-large;
}

.myButtonA {
  text-decoration: none;
  color: white;
  font-weight: bold;
}

.mySearchDiv {
  width: 200px;
  height: 40px;
  text-align: center;
  font-size: x-large;
}

.mainTABLine {
  background-color: darkgray;
  margin-top: 30px;

}

</style>
