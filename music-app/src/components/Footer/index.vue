<script setup lang="ts">
import { ref, reactive, nextTick, watch, computed, onMounted, onUnmounted } from 'vue'
import Lyrics from '../Lyrics/index.vue'
import { formatMusicTime } from '@/utils/formatTime.ts'
import audio1 from '@/assets/audios/audio1.mp3'
import audio2 from '@/assets/audios/audio2.mp3'
import audio3 from '@/assets/audios/audio3.mp3'
import orderIcon from '@/assets/icons/order.png'
import orderWhiteIcon from '@/assets/icons/order-white.png'
import randomIcon from '@/assets/icons/random.png'
import randomWhiteIcon from '@/assets/icons/random-white.png'
import loopIcon from '@/assets/icons/loop.png'
import loopWhiteIcon from '@/assets/icons/loop-white.png'
import backwardIcon from '@/assets/icons/backward.png'
import backwardWhiteIcon from '@/assets/icons/backward-white.png'
import pauseIcon from '@/assets/icons/pause.png'
import pauseWhiteIcon from '@/assets/icons/pause-white.png'
import playIcon from '@/assets/icons/play.png'
import playWhiteIcon from '@/assets/icons/play-white.png'
import forwardIcon from '@/assets/icons/forward.png'
import forwardWhiteIcon from '@/assets/icons/forward-white.png'
import muteIcon from '@/assets/icons/mute.png'
import muteWhiteIcon from '@/assets/icons/mute-white.png'
import voiceIcon from '@/assets/icons/voice.png'
import voiceWhiteIcon from '@/assets/icons/voice-white.png'
import aiIcon from '@/assets/icons/ai.png'
import aiFillIcon from '@/assets/icons/ai-fill.png'
import likeWhiteIcon from '@/assets/icons/like-white.png'
import likeFillWhiteIcon from '@/assets/icons/like-fill-white.png'
import downloadIcon from '@/assets/icons/download.png'
import downloadWhiteIcon from '@/assets/icons/download-white.png'
import moreIcon from '@/assets/icons/more.png'
import moreWhiteIcon from '@/assets/icons/more-white.png'
import deleteIcon from '@/assets/icons/delete.png'
import deleteWhiteIcon from '@/assets/icons/delete-white.png'

// 音频元素引用
const audioPlayer = ref<HTMLAudioElement | null>(null)

// 播放进度
let progress = ref(0)
let currentTime = ref('00:00')
let duration = ref('00:00')

// 音量控制
let volume = ref(100)
let lastVolume = ref(100)
let isMuted = ref(false)

// 播放模式
let playPattern = ref('order')
const changePlayMode = () => {
  const modes = ['order', 'random', 'loop']
  let currentIndex = modes.indexOf(playPattern.value)
  playPattern.value = modes[(currentIndex + 1) % 3]
}

// 是否播放
let isPlaying = ref(false)
const togglePlay = async () => {
  if (!audioPlayer.value) return
  if (isPlaying.value) {
    audioPlayer.value.pause()
  } else {
    await audioPlayer.value.play()
  }
  isPlaying.value = !isPlaying.value
}

// 音乐列表
let musicList = reactive([
  {
    id: 1,
    name: '与我无关',
    singer: '阿冗',
    time: '04:00',
    url: audio1,
    isPlaying: false,
  },
  {
    id: 2,
    name: '其实，我就在你方圆几里',
    singer: '陈壹千',
    time: '04:01',
    url: audio2,
    isPlaying: false,
  },
  {
    id: 3,
    name: '我与她的故事',
    singer: '英',
    time: '04:18',
    url: audio3,
    isPlaying: false,
  },
])

// 当前播放音乐索引
let currentIndex = ref(0)

// 进度更新
const updateProgress = () => {
  if (!audioPlayer.value) return
  progress.value = (audioPlayer.value.currentTime / audioPlayer.value.duration) * 100
  currentTime.value = formatMusicTime(audioPlayer.value.currentTime)
}

// 加载元数据
const loadMetadata = () => {
  if (audioPlayer.value) {
    duration.value = formatMusicTime(audioPlayer.value.duration)
  }
}

// 跳转进度
const seek = (value: number) => {
  if (!audioPlayer.value) return
  audioPlayer.value.currentTime = (value / 100) * audioPlayer.value.duration
}

// 上/下一首歌曲
const changeTrack = (direction: 'prev' | 'next') => {
  switch (playPattern.value) {
    case 'order':
      currentIndex.value =
        (currentIndex.value + (direction === 'next' ? 1 : -1) + musicList.length) % musicList.length
      break
    case 'random':
      // 确保不重复随机数
      let newIndex
      do {
        newIndex = Math.floor(Math.random() * musicList.length)
      } while (musicList.length > 1 && newIndex === currentIndex.value)
      currentIndex.value = newIndex
      break
    case 'loop':
      if (audioPlayer.value) {
        audioPlayer.value.currentTime = 0
      }
      break
  }
  playCurrentTrack()
}

// 播放当前歌曲
const playCurrentTrack = async () => {
  if (audioPlayer.value) {
    await nextTick()
    audioPlayer.value.load()
    await audioPlayer.value.play()
    isPlaying.value = true
  }
}

// 音量控制
const adjustVolume = (value: number) => {
  if (!audioPlayer.value) return
  volume.value = value
  audioPlayer.value.volume = value / 100
  isMuted.value = value === 0
}

// 静音切换
const toggleMute = () => {
  if (!audioPlayer.value) return
  isMuted.value = !isMuted.value
  if (!isMuted.value) {
    lastVolume.value = volume.value
    volume.value = 0
    audioPlayer.value.volume = 0
  } else {
    volume.value = lastVolume.value
    audioPlayer.value.volume = lastVolume.value / 100
  }
}

// 是否收藏
let isCollect = ref(false)
const handleCollect = () => {
  isCollect.value = !isCollect.value
}

// 是否展示播放列表
let drawer = ref(false)
const handleClose = (done: () => void) => {
  done()
}

// 切换音乐
const handleSongClick = (currentItem: any) => {
  // 清除所有播放状态
  musicList.forEach((item) => {
    item.isPlaying = false
  })
  // 设置当前播放状态
  currentItem.isPlaying = true
  // 更新当前索引
  let index = musicList.findIndex((item) => item.id === currentItem.id)
  currentIndex.value = index
  // 立即播放
  nextTick(() => {
    if (audioPlayer.value) {
      audioPlayer.value.src = currentItem.url
      audioPlayer.value.play()
      isPlaying.value = true
    }
  })
}

// 是否展示歌词组件
let showLyric = ref(false)
const showLyrics = () => {
  showLyric.value = !showLyric.value
}

// 全屏控制
let isFullScreen = ref(false)
const toggleFullScreen = async () => {
  if (!document.fullscreenElement) {
    await document.documentElement.requestFullscreen()
    isFullScreen.value = true
  } else {
    await document.exitFullscreen()
    isFullScreen.value = false
  }
}
// 添加事件监听
const handleFullscreenChange = () => {
  isFullScreen.value = !!document.fullscreenElement
}
onMounted(() => {
  document.addEventListener('fullscreenchange', handleFullscreenChange)
})
onUnmounted(() => {
  document.removeEventListener('fullscreenchange', handleFullscreenChange)
})

// 监听当前索引变化
watch(currentIndex, (newIndex) => {
  musicList.forEach((item, index) => {
    item.isPlaying = index === newIndex
  })
})
</script>

<template>
  <div class="footer" :class="{ showing: showLyric }">
    <div class="progress-bar">
      <el-slider
        v-model="progress"
        :format-tooltip="
          (val: number) => formatMusicTime((val / 100) * (audioPlayer?.duration || 0))
        "
        @change="seek"
      />
      <div class="time-display">
        <span>{{ currentTime }}</span>
        <span>{{ duration }}</span>
      </div>
    </div>
    <div class="container">
      <div class="left" @click="showLyrics">
        <img src="@/assets/images/user.jpg" alt="" />
        <div class="song-info">
          <div class="name-singer">
            <span class="name">{{ musicList[currentIndex].name }}</span>
            <span class="singer">{{ musicList[currentIndex].singer }}</span>
          </div>
          <div class="time">{{ currentTime }} / {{ duration }}</div>
        </div>
      </div>
      <div class="mid">
        <span @click="changePlayMode">
          <!-- <img :src="`@/assets/icons/${playPattern}.png`" alt="" /> -->
          <img
            v-if="playPattern === 'order'"
            :src="showLyric ? orderWhiteIcon : orderIcon"
            alt=""
          />
          <img
            v-else-if="playPattern === 'random'"
            :src="showLyric ? randomWhiteIcon : randomIcon"
            alt=""
          />
          <img v-else :src="showLyric ? loopWhiteIcon : loopIcon" alt="" />
        </span>
        <span @click="changeTrack('prev')">
          <img :src="showLyric ? backwardWhiteIcon : backwardIcon" alt="" />
        </span>
        <span @click="togglePlay">
          <img v-if="isPlaying" :src="showLyric ? pauseWhiteIcon : pauseIcon" alt="" />
          <img v-else :src="showLyric ? playWhiteIcon : playIcon" alt="" />
        </span>
        <span @click="changeTrack('next')">
          <img :src="showLyric ? forwardWhiteIcon : forwardIcon" alt="" />
        </span>
        <!-- 音量控制 -->
        <div class="volume-control">
          <el-popover
            placement="top"
            popper-style="min-width: 50px; max-width: 50px; display: flex; flex-direction: column; justify-content: center; align-items: center;"
            :z-index="999999"
          >
            <template #reference>
              <img
                v-if="isMuted"
                @click="toggleMute"
                :src="showLyric ? muteWhiteIcon : muteIcon"
                alt=""
              />
              <img
                v-else
                @click="toggleMute"
                :src="showLyric ? voiceWhiteIcon : voiceIcon"
                alt=""
              />
            </template>
            <el-slider
              v-model="volume"
              vertical
              height="120px"
              @change="adjustVolume"
              :style="{ '--el-color-primary': '#800020' }"
            />
            <div class="volume-text" style="margin-top: 3px">{{ volume }}%</div>
          </el-popover>
        </div>
      </div>
      <div class="right">
        <span @click="handleCollect">
          <img v-if="!isCollect" :src="showLyric ? likeWhiteIcon : aiIcon" alt="" />
          <img v-else :src="showLyric ? likeFillWhiteIcon : aiFillIcon" alt="" />
        </span>
        <span>
          <img :src="showLyric ? downloadWhiteIcon : downloadIcon" alt="" />
        </span>
        <span @click="drawer = true">
          <img :src="showLyric ? moreWhiteIcon : moreIcon" alt="" />
        </span>
      </div>
      <!-- 音频元素 -->
      <audio
        ref="audioPlayer"
        :src="musicList[currentIndex]?.url"
        @timeupdate="updateProgress"
        @loadedmetadata="loadMetadata"
        @ended="changeTrack('next')"
      ></audio>
      <!-- 弹出层 -->
      <el-drawer
        v-model="drawer"
        direction="rtl"
        size="20%"
        :with-header="false"
        :show-close="true"
        :before-close="handleClose"
        :z-index="99999"
      >
        <div class="drawer-container" :class="{ showing: showLyric }">
          <div class="top">
            <div class="left">
              播放列表<span class="num">{{ musicList.length }}</span>
            </div>
            <div class="right">
              <img :src="showLyric ? deleteWhiteIcon : deleteIcon" alt="" />
              <div>清空</div>
            </div>
          </div>
          <div class="scroll-list" :class="{ showing: showLyric }">
            <div class="list" v-for="(item, index) in musicList" :key="item.id">
              <div class="item" @click="handleSongClick(item)">
                <div class="left">
                  <img src="@/assets/images/user.jpg" alt="" />
                  <div class="info" :class="{ active: index === currentIndex, showing: showLyric }">
                    <div class="name">{{ item.name }}</div>
                    <div class="singer">{{ item.singer }}</div>
                  </div>
                </div>
                <div class="right">{{ item.time }}</div>
              </div>
            </div>
          </div>
        </div>
      </el-drawer>
    </div>
    <transition name="slide-fade">
      <Lyrics
        v-show="showLyric"
        :isPlaying="isPlaying"
        :musicInfo="musicList[currentIndex]"
        @close="showLyric = false"
        class="lyrics-popup"
        @toggleFullScreen="toggleFullScreen"
        :isFullScreen="isFullScreen"
        :currentTime="currentTime"
      />
    </transition>
  </div>
</template>

<style lang="less" scoped>
.footer {
  width: 100%;
  height: 100px;
  padding: 0 20px;

  &.showing {
    background: linear-gradient(180deg, #4a4453 0%, #231e28 100%);
    color: #fff;
  }
  /* 进入动画 */
  .slide-fade-enter-active {
    transition:
      transform 0.8s ease-out,
      opacity 0.8s;
  }
  .slide-fade-enter-from {
    transform: translateY(100vh);
    opacity: 0;
  }
  /* 离开动画 */
  .slide-fade-leave-active {
    transition:
      transform 0.8s ease-in,
      opacity 0.8s;
  }
  .slide-fade-leave-to {
    transform: translateY(100vh);
    opacity: 0;
  }
  .progress-bar {
    position: absolute;
    bottom: 63px;
    left: 0;
    right: 0;
    width: 100%;
    box-sizing: border-box;
    padding: 0 20px;
    :deep(.el-slider) {
      --el-slider-button-size: 12px;
      --el-slider-height: 4px;
      .el-slider__runway {
        background: #e0e0e0;
      }
      .el-slider__bar {
        background: #800020;
      }
      .el-slider__button {
        border-color: #800020;
      }
    }
    .time-display {
      display: flex;
      justify-content: space-between;
      padding: 0 10px;
      font-size: 12px;
      color: #666;
    }
  }
  .container {
    width: 100%;
    height: 100%;
    display: flex;
    padding: 50px 60px;
    .left {
      display: flex;
      align-items: center;
      flex: 2;
      img {
        width: 50px;
        height: 50px;
        border-radius: 5px;
        cursor: pointer;
      }
      .song-info {
        cursor: pointer;
        margin-left: 10px;
        .name-singer {
          .name {
            font-size: 16px;
            font-weight: 600;
          }
          .singer {
            margin-left: 5px;
            font-size: 12px;
            color: #999;
          }
        }
        .time {
          font-size: 12px;
          color: #999;
        }
      }
    }
    .mid {
      position: relative;
      margin-top: 20px;
      flex: 7;
      display: flex;
      align-items: center;
      justify-content: center;
      gap: 20px;
      span {
        display: block;
        width: 50px;
        height: 50px;
        cursor: pointer;
        img {
          width: 25px;
          height: 25px;
          transition: transform 0.2s;
          &:hover {
            transform: scale(1.1);
          }
        }
      }
      .volume-control {
        width: 50px;
        height: 50px;
        position: relative;
        :deep(.el-slider) {
          padding: 10px 0;
        }
        img {
          width: 25px;
          height: 25px;
          cursor: pointer;
          transition: transform 0.2s;
          &:hover {
            transform: scale(1.1);
          }
        }
      }
    }
    .right {
      margin-top: 20px;
      flex: 2;
      display: flex;
      align-items: center;
      justify-content: center;
      gap: 30px;
      span {
        display: block;
        width: 50px;
        height: 50px;
        cursor: pointer;
        img {
          width: 25px;
          height: 25px;
          transition: transform 0.2s;
          &:hover {
            transform: scale(1.1);
          }
        }
      }
    }
    :deep(.el-drawer__body) {
      padding: 0 !important;
    }

    .drawer-container {
      padding: 10px 20px;
      display: flex;
      flex-direction: column;
      height: 100%;
      position: fixed;
      &.showing {
        background: linear-gradient(180deg, #4a4453 0%, #231e28 100%);
        color: #fff;
      }

      .top {
        position: sticky;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        display: flex;
        align-items: center;
        height: 50px;
        .left {
          flex: 2;
          font-size: 20px;
          font-weight: 600;
          .num {
            margin-left: 5px;
            font-size: 12px;
            color: #999;
          }
        }
        .right {
          flex: 1;
          font-size: 14px;
          color: #999;
          cursor: pointer;
          margin-bottom: 15px;
          gap: 5px;
          img {
            width: 16px;
            height: 16px;
          }
        }
      }
      .scroll-list {
        width: calc(100vw - 80vw);
        height: calc(100% - 50px); /* 减去顶部高度 */
        overflow-y: auto; /* 启用滚动 */
        /* 全浏览器隐藏滚动条 */
        scrollbar-width: none;
        -ms-overflow-style: none;
        &::-webkit-scrollbar {
          width: 0;
          height: 0;
          background: transparent;
        }

        .list {
          margin-top: 20px;
          transition: transform 0.4s;
          .item {
            height: 60px;
            display: flex;
            align-items: center;
            cursor: pointer;
            transition: transform 0.4s cubic-bezier(0.4, 0, 0.2, 1);
            &:hover {
              background: #f5f5f5;
              transform: scale(1.05);
              transition: all 0.3s;
            }
            .left {
              flex: 2;
              .info {
                margin-left: 10px;
                font-size: 14px;
                &.active {
                  font-weight: bold;
                  color: #800020;
                  &.showing {
                    color: #ff77ff;
                  }
                }
              }
            }
            .right {
              flex: 1;
              color: #ccc;
              margin-bottom: 15px;
            }
          }
        }
      }
    }
  }
}
</style>
