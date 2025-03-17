import { Layout, Avatar, Dropdown } from 'antd'
import type { MenuProps } from 'antd'
import { useNavigate } from 'react-router-dom'

const { Header } = Layout

export default function Navbar() {
  const navigate = useNavigate()
  const items: MenuProps['items'] = [
    {
      key: '1',
      label: '退出登录',
      onClick: () => {
        // 退出登录
        localStorage.clear()
        navigate('/login')
      },
    },
  ]
  return (
    <Header
      style={{
        padding: '0 40px',
        background: '#fff',
        height: '80px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
      }}
    >
      <h2 style={{ margin: 0 }}>TiAmo-Music Admin</h2>
      <div className="avatar">
        <Dropdown menu={{ items }} placement="bottom">
          <Avatar size={40} />
        </Dropdown>
        <span style={{ marginLeft: '15px' }}>Admin</span>
      </div>
    </Header>
  )
}
