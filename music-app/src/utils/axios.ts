import axios from 'axios'

const request = axios.create({
  baseURL: 'http://localhost:8080/music',
  timeout: 5000, // 超时时间
  withCredentials: true, // 允许携带 Cookie
})

// 请求拦截器
request.interceptors.request.use(
  (config) => {
    // 如果有token，则添加到请求头中
    const token = localStorage.getItem('token')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  (error) => Promise.reject(error),
)

// 响应拦截器
request.interceptors.response.use(
  (response) => response.data,
  (error) => {
    console.log('请求错误', error.response)
    return Promise.reject(error)
  },
)

export default request
