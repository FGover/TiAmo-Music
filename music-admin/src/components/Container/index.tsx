import { Layout, theme } from 'antd'
import { Outlet } from 'react-router-dom'
import Navbar from '../Navbar'
import Sidebar from '../Sidebar'

const { Content } = Layout

export default function Container() {
  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken()

  return (
    <Layout>
      {/* 侧边栏 */}
      <Sidebar />
      <Layout>
        {/* 头部组件 */}
        <Navbar />
        <Content style={{ margin: '24px 16px 0' }}>
          <div
            style={{
              padding: 24,
              minHeight: 'calc(100vh - 104px)',
              background: colorBgContainer,
              borderRadius: borderRadiusLG,
            }}
          >
            {/* 挂载子组件 */}
            <Outlet />
          </div>
        </Content>
      </Layout>
    </Layout>
  )
}
