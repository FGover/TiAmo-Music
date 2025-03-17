<script setup lang="ts">
import type { VideoItem } from '@/types/video'
import { VideoPlay, View } from '@element-plus/icons-vue'
const props = defineProps<{
  item: VideoItem
}>()

let video = props.item
</script>

<template>
  <div class="item" @click="$router.push(`/mvdetail?${video.id}`)">
    <video :src="video.url"></video>
    <el-icon :size="50" class="icon"><VideoPlay /></el-icon>
    <div class="icon2">
      <el-icon :size="18"><View /></el-icon>
      <span style="margin-left: 5px">{{ item.views }}</span>
    </div>
    <span class="title">{{ item.title }}</span>
  </div>
</template>

<style scoped lang="less">
.item {
  width: 300px;
  height: 200px;
  margin: 15px 10px;
  cursor: pointer;
  position: relative;
  video {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  .icon {
    position: absolute;
    top: 52%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #ccc;
  }
  .icon2 {
    position: absolute;
    bottom: 5px;
    left: 10px;
    display: flex;
    align-items: center;
    color: #fff;
  }
  .title {
    display: block;
    width: 100%;
    height: 30px;
    line-height: 30px;
    margin-top: 5px;
  }
}
</style>
