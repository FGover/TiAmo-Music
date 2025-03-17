<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps<{
  userInfo: any
}>()

const save = () => {
  // 保存修改的用户信息
}

const cancel = () => {
  // 取消修改
  console.log('取消修改')
}
</script>

<template>
  <div class="edit-profile">
    <div class="modal-content">
      <h2>修改个人信息</h2>
      <div class="form-group">
        <label for="name">用户名:</label>
        <input id="name" v-model="props.userInfo.name" type="text" placeholder="请输入姓名" />
      </div>
      username
      <div class="form-group">
        <label for="bio">个性签名:</label>
        <input id="bio" v-model="props.userInfo.bio" type="text" placeholder="请输入个性签名" />
      </div>
      <div class="form-group">
        <label for="avatar">头像 URL:</label>
        <input
          id="avatar"
          v-model="props.userInfo.avatar"
          type="text"
          placeholder="请输入头像链接"
        />
      </div>
      <div class="button-group">
        <button @click="save">保存</button>
        <button @click="cancel">取消</button>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.edit-profile {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;

  .modal-content {
    background: white;
    padding: 20px;
    border-radius: 10px;
    width: 400px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }

  .form-group {
    margin-bottom: 15px;
  }

  label {
    display: block;
    font-weight: 600;
  }

  input {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  .button-group {
    display: flex;
    justify-content: flex-end;
    gap: 10px;

    button {
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:first-child {
      background-color: #4caf50;
      color: white;
    }

    button:last-child {
      background-color: #f44336;
      color: white;
    }
  }
}
</style>
