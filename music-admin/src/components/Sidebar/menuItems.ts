import React from 'react'
import {
  ClockCircleOutlined,
  CustomerServiceOutlined,
  UserOutlined,
  VideoCameraOutlined,
  AudioOutlined,
  FileTextOutlined,
} from '@ant-design/icons'
import MenuItem from '../../types/menuItem'

const items: MenuItem[] = [
  { key: '/dashboard', icon: React.createElement(ClockCircleOutlined), label: '数据统计' },
  { key: '/user', icon: React.createElement(UserOutlined), label: '用户管理' },
  { key: '/song', icon: React.createElement(CustomerServiceOutlined), label: '歌曲管理' },
  { key: '/songlist', icon: React.createElement(FileTextOutlined), label: '歌单管理' },
  { key: '/singer', icon: React.createElement(AudioOutlined), label: '歌手管理' },
  { key: '/mv', icon: React.createElement(VideoCameraOutlined), label: '视频管理' },
];

export default items;