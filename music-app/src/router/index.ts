import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      redirect: '/home', // 默认跳转
      path: '/',
      name: 'Container',
      component: () => import('../views/Container/index.vue'),
      children: [
        {
          path: '/home',
          name: 'Home',
          component: () => import('../views/Home/index.vue'),
        },
        {
          path: '/song',
          name: 'Song',
          component: () => import('../views/Song/index.vue'),
        },
        {
          path: '/songdetail',
          name: 'SongDetail',
          component: () => import('../views/Song/SongDetail.vue'),
        },
        {
          path: '/singer',
          name: 'Singer',
          component: () => import('../views/Singer/index.vue'),
        },
        {
          path: '/singerdetail',
          name: 'SingerDetail',
          component: () => import('../views/Singer/SingerDetail.vue'),
        },
        {
          path: '/mv',
          name: 'Mv',
          component: () => import('../views/Mv/index.vue'),
        },
        {
          path: '/mvdetail',
          name: 'MvDetail',
          component: () => import('../views/Mv/MvDetail.vue'),
        },
        {
          path: '/user',
          name: 'User',
          component: () => import('../views/User/index.vue'),
        },
      ],
    },
  ],
})

export default router
