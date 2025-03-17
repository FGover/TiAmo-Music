<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import Login from '@/views/Login/index.vue'
import { Headset, Search } from '@element-plus/icons-vue'
import userImg from '@/assets/images/user.jpg'

const router = useRouter()

// 控制登录组件显示
let isShow = ref(false)
// 选择高亮（默认首页）
let isActive = ref(1)

// 登录
const select = (index: number) => {
  if (index === 4) {
    isShow.value = true
  } else if (index === 1) {
    router.push('/')
  } else if (index === 2) {
    router.push('/song')
  } else if (index === 3) {
    router.push('/singer')
  } else if (index === 5) {
    router.push('/mv')
  }
  isActive.value = index
}

// 定义一个判断是否登录
let isLogin = ref(false)
const closeLogin = () => {
  isShow.value = false
  const token = localStorage.getItem('token')
  if (token) {
    isLogin.value = true
  }
}

const logout = () => {
  localStorage.removeItem('token')
  isLogin.value = false
  isOpen.value = false
}

let isOpen = ref(false)
const showDropdown = () => {
  isOpen.value = true
}
const hideDropdown = () => {
  isOpen.value = false
}

onMounted(() => {
  const token = localStorage.getItem('token')
  if (token) {
    isLogin.value = true
  }
})
</script>

<template>
  <div class="header">
    <el-icon :size="30"><Headset /></el-icon>
    <span class="name">TiAmo-Music</span>
    <span class="btn1" @click="select(1)" :class="{ active: isActive === 1 }">首页</span>
    <span class="btn2" @click="select(2)" :class="{ active: isActive === 2 }">歌单</span>
    <span class="btn3" @click="select(3)" :class="{ active: isActive === 3 }">歌手</span>
    <span class="btn6" @click="select(5)" :class="{ active: isActive === 5 }">MV</span>
    <el-input class="btn4" placeholder="搜索">
      <template #prefix>
        <el-icon class="el-input__icon"><search /></el-icon>
      </template>
    </el-input>
    <span v-if="!isLogin" class="btn5" @click="select(4)" :class="{ active: isActive === 4 }"
      >登录</span
    >
    <div v-else class="user">
      <img class="icon" src="@/assets/icons/message.png" alt="" />
      <div class="user-info" @mouseenter="showDropdown" @mouseleave="hideDropdown">
        <img :src="userImg" alt="" />
        <ul v-if="isOpen" class="dropdown-menu">
          <li class="dropdown-item" @click="$router.push('/user')">个人主页</li>
          <li class="dropdown-item" @click="logout">退出登录</li>
        </ul>
      </div>
    </div>
    <transition name="fade" appear>
      <Login v-if="isShow" @close="closeLogin" />
    </transition>
  </div>
</template>

<style lang="less" scoped>
.header {
  display: flex;
  padding: 0 100px;
  align-items: center;
  width: 100%;
  height: 60px;
  box-shadow: 0 0 10px #ccc;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  box-shadow: 0 6px 20px -8px rgba(0, 0, 0, 0.2);
  z-index: 1000;
  .user {
    width: 200px;
    margin-left: 80px;
    .icon {
      width: 30px;
      height: 30px;
      margin-bottom: 5px;
    }
  }
  .user-info {
    position: relative;
    display: inline-block;
    margin-left: 50px;
    margin-top: 5px;
    img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      cursor: pointer;
    }
    .dropdown-menu {
      position: absolute;
      top: 90%;
      left: -20px;
      background-color: #444;
      border-radius: 5px;
      padding: 0;
      min-width: 90px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      list-style: none;
      margin: 5px 0 0;
      z-index: 100;
      /* 菜单项 */
      .dropdown-item {
        padding: 10px;
        color: #ddd;
        cursor: pointer;
        transition:
          background 0.3s,
          color 0.3s;
        &:hover {
          border-radius: 5px;
          background-color: #c0a0a0;
          color: #fff;
        }
      }
    }
  }
}

.name {
  margin-left: 10px;
  color: black;
  font-weight: bold;
  font-size: 20px;
}

.btn1,
.btn2,
.btn3,
.btn6 {
  width: 80px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  margin-left: 100px;
  color: #7b8290;
  cursor: pointer;
}

.btn4 {
  width: 400px;
  margin-left: 120px;
}

.active {
  border-bottom: 2px solid #800020;
}

.btn5 {
  width: 80px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  margin-left: 200px;
  color: #7b8290;
  cursor: pointer;
}

:deep(.btn4 .el-input__wrapper) {
  border-radius: 15px;
  caret-color: #ccc;
  background: #efefef;
  &.is-focus {
    border: 1px solid #ccc;
    box-shadow: none !important;
  }
  &:hover {
    background: #ffffff;
  }
}

.fade-enter-active,
.fade-leave-active {
  transition:
    opacity 0.5s ease,
    transform 0.5s ease;
}
/* 进入前 */
.fade-enter-from {
  opacity: 0;
  transform: translate(80%, -100%) scale(0.8);
}

/* 离开时 */
.fade-leave-to {
  opacity: 0;
  transform: translate(80%, -100%) scale(1.2);
}
</style>
