<script setup lang="ts">
import avatarImg from '@/assets/images/nv.jpg'
const props = defineProps<{
  recentTracks: Array<any>
}>()
</script>

<template>
  <div class="item" v-for="item in props.recentTracks" :key="item.id">
    <div class="left">
      <img :src="avatarImg" alt="" />
      <div class="name">{{ item.title }}</div>
    </div>
    <div class="artist">{{ item.artist }}</div>
  </div>
</template>

<style scoped lang="less">
.item {
  user-select: none;
  flex-shrink: 0;
  width: 100%;
  height: 60px;
  font-size: 16px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 100px;
  &:hover {
    background-color: #dbcfcf;
    transform: scale(1.05);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
  }
  img {
    width: 50px;
    height: 50px;
    border-radius: 5px;
  }
  .left {
    display: flex;
    align-items: center;
    .name {
      margin-left: 15px;
    }
  }
}
</style>
