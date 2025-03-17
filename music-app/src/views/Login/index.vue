<script setup lang="ts">
import { ref } from 'vue'
import { Close } from '@element-plus/icons-vue'

const emit = defineEmits(['close'])

const isShow = ref(true)

const toRegister = () => {
  isShow.value = false
}

const register = () => {
  isShow.value = true
}

const login = () => {
  // 生成随机token
  let token = Math.random().toString(36).substring(2, 15)
  localStorage.setItem('token', token)
  emit('close')
}
</script>

<template>
  <div class="login-container">
    <div class="close-btn" @click="emit('close')">
      <el-icon :size="25" style="cursor: pointer"><Close /></el-icon>
    </div>
    <h1 class="logo">TiAmo-Music</h1>
    <el-form class="login-form" label-position="top">
      <el-form-item>
        <el-input placeholder="请输入用户名" class="input-field" />
      </el-form-item>
      <el-form-item>
        <el-input placeholder="请输入密码" type="password" class="input-field" />
      </el-form-item>
      <div v-if="isShow">
        <div class="options-row">忘记密码</div>
        <div class="btn-row">
          <el-button class="login-btn" size="large" @click="login">登录</el-button>
          <el-button
            class="register-btn"
            size="large"
            @click="toRegister"
            :style="{ background: !isShow ? '#800020' : '', color: !isShow ? '#fff' : '' }"
            >注册</el-button
          >
        </div>
      </div>
      <el-button class="login-btn" size="large" v-else @click="register">注册</el-button>
    </el-form>
  </div>
</template>

<style scoped>
.login-container {
  position: fixed;
  top: 45%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 350px;
  height: 450px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  border-radius: 10px;
  padding: 30px;
  font-family:
    -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
}

.close-btn {
  text-align: right;
  margin-right: -15px;
  margin-top: -15px;
  margin-bottom: 15px;
}

.logo {
  text-align: center;
  font-size: 32px;
  margin-bottom: 40px;
}

/* 表单 */
.login-form {
  display: flex;
  flex-direction: column;
}

/* 深度器加样式 */
.input-field {
  width: 290px;
  height: 40px;
}

:deep(.input-field .el-input__wrapper) {
  border-radius: 20px;
  &.is-focus {
    border: 1px solid #ccc;
    box-shadow: none !important;
  }
}

.options-row {
  margin-bottom: 10px;
  text-align: right;
  cursor: pointer;
}

/* 按钮 */
.login-btn {
  margin-top: 5px;
  width: 290px;
  border-radius: 20px;
  background: #800020;
  color: #fff;
}
.register-btn {
  margin-top: 10px;
  width: 290px;
  border-radius: 20px;
  margin-left: 0;
  background: #fff;
}
/* 按钮悬浮颜色 */
:deep(.register-btn.el-button:hover) {
  border-color: #b33a58;
  color: #000;
}
/* 按钮点击松开后的颜色，如果松开按钮后不需要改变颜色，点击后按钮颜色不变，可以删除此段代码， */
/* :deep(.el-button:focus) {
  background: #00ff0d;
  border-color: #00ff0d;
} */
</style>
