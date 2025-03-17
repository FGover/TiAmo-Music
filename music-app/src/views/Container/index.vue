<script setup lang="ts">
import Header from '@/components/Header/index.vue'
import Footer from '@/components/Footer/index.vue'
import { RouterView } from 'vue-router'
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-main>
        <RouterView />
      </el-main>
      <el-footer>
        <Footer></Footer>
      </el-footer>
    </el-container>
  </div>
</template>

<style scoped>
.el-container {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100vw;
  height: 100vh;
}

.el-header,
.el-footer {
  background-color: #fff;
  color: #333;
  display: flex;
  align-items: center;
}

.el-footer {
  height: 100px;
  padding: 0;
}

.el-main {
  background-color: #fff;
  color: #333;
  padding: 20px;
  /* 隐藏滚动条*/
  scrollbar-width: none;
}
</style>
