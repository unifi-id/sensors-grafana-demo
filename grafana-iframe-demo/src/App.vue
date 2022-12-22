<script setup>
import {RouterLink, RouterView} from 'vue-router'
</script>

<template>
  <v-layout>
    <v-app-bar color="grey-lighten-2">
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/fora">Fora</RouterLink>
        <RouterLink to="/groucho">Groucho</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </v-app-bar>

    <v-main>
      <RouterView/>
    </v-main>
  </v-layout>
</template>

<style scoped>
nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

nav {
  text-align: left;
  margin-left: -1rem;
  font-size: 1rem;

  padding: 1rem 0;
  margin-top: 1rem;
}
</style>
