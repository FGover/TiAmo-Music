import { Button, Form, Input, message } from 'antd'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Admin from '../../types/admin'
import request from '../../utils/axios'
import Result from '../../types/result'

export default function Login() {
  // 控制按钮的loading状态
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()
  const [messageApi, contextHolder] = message.useMessage()
  const [form] = Form.useForm()

  const handleRegister = async (values: Admin) => {
    const { username, password } = values
    if (!username || !password) {
      messageApi.open({
        type: 'error',
        content: '请输入用户名和密码',
      })
      return
    }
    const res: Result = await request.post('/register', {
      username,
      password,
    })
    if (res.code === 200) {
      messageApi.open({
        type: 'success',
        content: '注册成功',
      })
    } else {
      messageApi.open({
        type: 'error',
        content: res.data.message,
      })
    }
  }

  // 登录表单提交
  const handleLogin = async (values: Admin) => {
    try {
      const { username, password } = values
      if (!username || !password) {
        message.error('请输入用户名和密码')
        return
      }
      setLoading(true)
      // 发请求
      const res: Result = await request.post('/login', {
        username,
        password,
      })
      console.log(res)
      if (res.code === 200) {
        messageApi.open({
          type: 'success',
          content: '登录成功',
        })
        setLoading(false)
        localStorage.setItem('token', res.data.token)
        navigate('/')
      } else {
        messageApi.open({
          type: 'error',
          content: res.message,
        })
      }
    } catch (error) {
      console.log(error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div
      style={{
        maxWidth: '400px',
        height: '360px',
        margin: '180px auto',
        padding: '40px 30px',
        border: '1px solid #ccc',
        borderRadius: '8px',
      }}
    >
      <h2 style={{ textAlign: 'center', marginBottom: '50px' }}>
        TiAmo-Music后台管理系统
      </h2>
      <Form form={form} layout="horizontal">
        <Form.Item
          name="username"
          label="用户名"
          rules={[{ required: true, message: '请输入用户名' }]}
          labelCol={{ span: 5 }} // 标签的宽度
          wrapperCol={{ span: 18 }} // 输入框的宽度
        >
          <Input placeholder="请输入用户名" />
        </Form.Item>

        <Form.Item
          name="password"
          label="密码"
          rules={[{ required: true, message: '请输入密码' }]}
          labelCol={{ span: 5 }} // 标签的宽度
          wrapperCol={{ span: 18 }} // 输入框的宽度
        >
          <Input.Password placeholder="请输入密码" />
        </Form.Item>

        <Form.Item style={{ marginTop: '30px' }}>
          {contextHolder}
          <Button
            type="primary"
            block
            loading={loading} // 登录时按钮变为loading状态
            onClick={() =>
              handleLogin({
                username: form.getFieldValue('username'),
                password: form.getFieldValue('password'),
              })
            }
          >
            登录
          </Button>
        </Form.Item>
        <Form.Item>
          {contextHolder}
          <Button
            type="primary"
            block
            onClick={() =>
              handleRegister({
                username: form.getFieldValue('username'),
                password: form.getFieldValue('password'),
              })
            }
          >
            注册
          </Button>
        </Form.Item>
      </Form>
    </div>
  )
}
