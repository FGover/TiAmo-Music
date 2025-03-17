<script setup lang="ts">
import { reactive, ref } from 'vue'
import { VideoPlay, VideoPause, View, Close } from '@element-plus/icons-vue'
import type { VideoItem } from '@/types/video'

const props = defineProps<{ videoList: VideoItem[] }>()
let videoList = reactive<VideoItem[]>(props.videoList)

// 获取视频DOM
let videoPlayer = ref<HTMLVideoElement[]>([])

// 切换播放状态
const togglePlay = (item: VideoItem) => {
  const video = videoPlayer.value.find((_, index) => {
    return index === videoList.indexOf(item)
  })
  if (!video) return
  if (item.isPlaying) {
    video.pause()
    item.isPlaying = false
  } else {
    // 先暂停其他视频
    videoList.forEach((video) => {
      if (video.id !== item.id) {
        const otherVideo = videoPlayer.value.find((_, index) => index === videoList.indexOf(video))
        otherVideo?.pause()
        video.isPlaying = false
        video.isExpanded = false
      }
    })
    // 播放并放大
    video.play().then(() => {
      item.isPlaying = true
      item.isExpanded = true
    })
  }
}

// 关闭放大
const closeZoom = (item: VideoItem) => {
  item.isExpanded = false
  const video = videoPlayer.value.find((_, index) => {
    return index === videoList.indexOf(item)
  })
  video?.pause()
  item.isPlaying = false
}

// 样式计算
const getVideoStyle = (item: VideoItem) => ({
  opacity: item.isExpanded ? 0 : 1,
  transform: item.isExpanded ? 'scale(0.95)' : 'none',
})
const expandedStyle = (item: VideoItem) => {
  const rect = videoPlayer.value[item.id]?.getBoundingClientRect()
  return {
    '--origin-x': `${rect?.left + rect?.width / 2}px`,
    '--origin-y': `${rect?.top + rect?.height / 2}px`,
  }
}
</script>

<template>
  <div class="video">
    <div class="content">
      <div class="mvItem" v-for="item in videoList" :key="item.id">
        <video
          class="video"
          @click="togglePlay(item)"
          :style="getVideoStyle(item)"
          ref="videoPlayer"
          :src="item.url"
        ></video>
        <!-- 放大后的容器 -->
        <transition name="scale-up">
          <div
            v-if="item.isExpanded"
            class="expanded-wrapper"
            :style="expandedStyle(item)"
            @click.self="closeZoom(item)"
          >
            <video class="expanded-video" :src="item.url" autoplay controls></video>
            <el-icon class="close-icon" @click="closeZoom(item)">
              <Close />
            </el-icon>
          </div>
        </transition>
        <div class="btn" @click="togglePlay(item)">
          <el-icon v-if="!item.isPlaying" :size="50"><VideoPlay /></el-icon>
          <el-icon v-else :size="50"><VideoPause /></el-icon>
        </div>
        <div class="num">
          <el-icon><View /></el-icon>
          <span style="margin-left: 3px">{{ item.views }}</span>
        </div>
        <div class="text">{{ item.title }}</div>
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.video {
  .content {
    width: 100%;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    margin-bottom: 10px;
    .mvItem {
      position: relative;
      width: 20%;
      height: 250px;
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-bottom: 20px;
      margin-top: 20px;
      /** 新增动画 */
      .scale-up-enter-active,
      .scale-up-leave-active {
        transition-delay: 0.1s;
        transition:
          opacity 0.5s ease,
          transform 0.4s cubic-bezier(0.23, 1, 0.32, 1);
        transform-origin: var(--origin-x) var(--origin-y);
      }

      .scale-up-enter-from {
        opacity: 0;
        transform: scale(0.3);
      }

      .scale-up-leave-to {
        opacity: 0;
        transform: scale(0.9);
      }

      /**新增放大样式 */
      .expanded-wrapper {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        z-index: 2000;
        width: 80vw;
        max-width: 1200px;
        aspect-ratio: 16/9;
        background: #fff;
        border-radius: 12px;
        box-shadow:
          0 20px 40px rgba(0, 0, 0, 0.15),
          0 0 0 1px rgba(0, 0, 0, 0.05);
        overflow: hidden;
      }

      .expanded-video {
        width: 100%;
        height: 100%;
        object-fit: cover;
      }

      .close-icon {
        position: absolute;
        top: 16px;
        right: 16px;
        color: #666;
        background: rgba(255, 255, 255, 0.9);
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        font-size: 24px;
        cursor: pointer;
        border-radius: 50%;
        padding: 8px;
        transition: 0.3s;
        &:hover {
          color: #333;
          transform: rotate(90deg);
        }
      }

      .video {
        position: relative;
        width: 250px;
        height: 200px;
        object-fit: cover;
        border-radius: 2px;
        transition: transform 0.4s cubic-bezier(0.25, 0.46, 0.45, 0.94);
        &:hover {
          transform: scale(1.1) !important;
          cursor: pointer;
        }
      }
      .btn {
        position: absolute;
        top: 44%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: #ccc;
        width: 50px;
        height: 50px;
        cursor: pointer;
      }
      .num {
        display: flex;
        align-items: center;
        color: #fff;
        position: absolute;
        top: 70%;
        left: 10%;
      }
      .text {
        width: 240px;
        height: 30px;
        margin-top: 10px;
        word-wrap: break-word;
      }
    }
  }
}
</style>
