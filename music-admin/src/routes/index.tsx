import { createBrowserRouter, Navigate, RouterProvider } from 'react-router-dom'
import { lazy, Suspense } from 'react'
import PrivateRoute from './privateRoute'
import Login from '../pages/Login'
import Layout from '../components/Container'
import NotFound from '../pages/404NotFound'

// 懒加载
const Dashboard = lazy(() => import('../pages/Dashboard'))
const Song = lazy(() => import('../pages/Song'))
const Songlist = lazy(() => import('../pages/SongList'))
const Singer = lazy(() => import('../pages/Singer'))
const Mv = lazy(() => import('../pages/Mv'))
const User = lazy(() => import('../pages/User'))

const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      {
        path: '/',
        element: <Navigate to="/dashboard" />, // 重定向
      },
      {
        path: '/dashboard',
        element: (
          <Suspense fallback={<div>加载中...</div>}>
            <PrivateRoute element={<Dashboard />} />
          </Suspense>
        ),
      },
      {
        path: '/song',
        element: (
          <Suspense fallback={<div>加载中...</div>}>
            <PrivateRoute element={<Song />} />
          </Suspense>
        ),
      },
      {
        path: '/songlist',
        element: (
          <Suspense fallback={<div>加载中...</div>}>
            <PrivateRoute element={<Songlist />} />
          </Suspense>
        ),
      },
      {
        path: '/singer',
        element: (
          <Suspense fallback={<div>加载中...</div>}>
            <PrivateRoute element={<Singer />} />
          </Suspense>
        ),
      },
      {
        path: '/mv',
        element: (
          <Suspense fallback={<div>加载中...</div>}>
            <PrivateRoute element={<Mv />} />
          </Suspense>
        ),
      },
      {
        path: '/user',
        element: (
          <Suspense fallback={<div>加载中...</div>}>
            <PrivateRoute element={<User />} />
          </Suspense>
        ),
      },
    ],
  },
  {
    path: '/login',
    element: <Login />,
  },
  {
    path: '*',
    element: <NotFound />,
  },
])

export default function AppRouter() {
  return <RouterProvider router={router} />
}
