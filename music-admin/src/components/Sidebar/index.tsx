import { useState } from 'react'
import { Layout, Menu } from 'antd'
import { useNavigate } from 'react-router-dom'
import items from './menuItems'
import MenuItem from '../../types/menuItem'
import './index.css'

const { Sider } = Layout

export default function Sidebar() {
  const navigate = useNavigate()
  // 从localStorage中获取当前菜单
  const activePath = localStorage.getItem('activePath')
  const [selectedKey, setSelectedKey] = useState(activePath || '/dashboard')

  // 菜单点击事件
  const handleMenuClick = (key: string) => {
    setSelectedKey(key)
    navigate(key) // 路由跳转
    localStorage.setItem('activePath', key) // 存储当前菜单
  }

  const sideList: MenuItem[] = items.map((item) => {
    return {
      key: item.key,
      icon: item.icon,
      label: item.label,
      onClick: () => {
        handleMenuClick(item.key)
      },
    }
  })

  return (
    <Sider
      breakpoint="lg"
      collapsedWidth="0"
      width={260}
      onBreakpoint={(broken) => {
        console.log(broken)
      }}
      onCollapse={(collapsed, type) => {
        console.log(collapsed, type)
      }}
    >
      <div className="demo-logo-vertical" />
      <Menu
        theme="dark"
        mode="inline"
        selectedKeys={[selectedKey]}
        items={sideList}
        style={{ height: '100%', paddingTop: '50px' }} // 设置 Menu 的高度
      />
    </Sider>
  )
}
