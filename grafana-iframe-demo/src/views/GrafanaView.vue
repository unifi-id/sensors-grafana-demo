<script>
import GrafanaEmbed from '../components/GrafanaEmbed.vue'

export default {
  props: ['url'],
  components: {GrafanaEmbed}
}
</script>

<template>
  <main>
    <GrafanaEmbed :url="url"/>
  </main>
</template>
