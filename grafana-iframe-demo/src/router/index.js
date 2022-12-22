import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import GrafanaView from '../views/GrafanaView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/fora',
      component: GrafanaView,
      props: {
        url: 'http://grafana.fora.viewer.unifi-id.click/d/qWb5e65Vz/fora-viewer-dashboard?kiosk=tv',
      }
    },
    {
      path: '/groucho',
      component: GrafanaView,
      props: {
        url: 'http://grafana.groucho.viewer.unifi-id.click/d/mxdOeec4z/groucho-viewer-dashboard?kiosk=tv',
      }
    }
  ]
})

export default router
