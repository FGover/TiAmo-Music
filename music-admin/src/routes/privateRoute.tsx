import React, { JSX } from 'react'
import { Navigate } from 'react-router-dom'

// 判断是否登录
const isLogin = () => {
  return localStorage.getItem('token') ? true : false
}

const PrivateRoute: React.FC<{ element: JSX.Element }> = ({ element }) => {
  return isLogin() ? element : <Navigate to="/login" />
}

export default PrivateRoute
