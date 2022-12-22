<script>

export default {
  data() {
    return {
      width: 1000,
      height: 500
    }
  },
  props: ['url'],
  mounted() {
    window.addEventListener("resize", this.updateIframeHeight)

    this.updateIframeHeight()
  },
  methods: {
    updateIframeHeight() {
      this.width = window.innerWidth - 140
      this.height = window.innerHeight - 100
    }
  }
}
</script>

<template>
  <iframe
      :width="width"
      :height="height"
      id="grafana-iframe"
      :src="url">
  </iframe>
</template>
