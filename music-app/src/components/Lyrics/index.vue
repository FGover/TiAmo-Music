<script setup lang="ts">
import { reactive, onMounted, watch } from 'vue'
import LyricsDisplay from './LyricsDisplay.vue'
import lyricsData from '@/utils/lyricsData.ts'
const props = defineProps<{
  isPlaying: Boolean
  isFullScreen: Boolean
  musicInfo: any
  currentTime: string
}>()

const emit = defineEmits(['close', 'toggleFullScreen'])

const close = () => {
  emit('close')
}

const toggleFullScreen = () => {
  emit('toggleFullScreen')
}
// 手写歌词（可以拿着id去请求数据库的歌词）
let lyrics = reactive<{ time: string; text: string }[]>([])
onMounted(() => {
  let id = props.musicInfo.id
  console.log(id)
  console.log(lyricsData)
  lyricsData.forEach((item) => {
    if (item.id === id) {
      lyrics = item.lyric
    }
  })
})

watch(
  () => props.musicInfo.id,
  (newVal) => {
    lyricsData.forEach((item) => {
      if (item.id === props.musicInfo.id) {
        lyrics = item.lyric
      }
    })
  },
)
</script>

<template>
  <div class="lyrics-container">
    <div class="top">
      <img src="@/assets/icons/arrow.png" alt="" @click="close" />
      <img src="@/assets/icons/all.png" alt="" @click="toggleFullScreen" />
    </div>
    <div class="content">
      <div class="left">
        <div class="vinyl-player" :class="{ playing: props.isPlaying }">
          <div class="vinyl-disc">
            <div class="disc-surface">
              <div class="disc-texture"></div>
              <img class="album-cover" src="@/assets/images/user.jpg" />
            </div>
          </div>
        </div>
      </div>
      <div class="right">
        <div class="title">{{ props.musicInfo.name }}</div>
        <div class="info">
          <span class="album">专辑：故事</span>
          <span class="singer">歌手：{{ props.musicInfo.singer }}</span>
        </div>
        <div class="icon">歌词</div>
        <div class="lyrics">
          <LyricsDisplay :lyricsData="lyrics" :currentTime="props.currentTime" />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.lyrics-container {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100vw;
  height: calc(100vh - 100px);
  z-index: 9999;
  background: linear-gradient(180deg, #4a4453 0%, #231e28 100%);

  .top {
    display: flex;
    align-items: center;
    padding: 20px;
    gap: 20px;

    img {
      width: 32px;
      height: 32px;
      cursor: pointer;
      &:hover {
        transform: scale(1.05);
        transition: all 0.2s ease;
        filter: drop-shadow(0 0 5px #fff);
      }
    }
  }

  .content {
    padding: 0 30px;
    display: flex;
    justify-content: space-between;

    .left {
      width: 45%;
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;

      .vinyl-player {
        position: relative;
        width: 400px;
        height: 400px;
        /* 光碟容器 */
        .vinyl-disc {
          position: absolute;
          width: 350px;
          height: 350px;
          left: 50%;
          top: 70%;
          transform: translate(-50%, -50%);
          /* 光碟表面 */
          .disc-surface {
            position: relative;
            width: 100%;
            height: 100%;
            border-radius: 50%;
            overflow: hidden;
            background: radial-gradient(circle at 50% 50%, #1a1a1a 0%, #111 30%, #000 100%);
            box-shadow:
              0 12px 40px rgba(0, 0, 0, 0.4),
              inset 0 0 30px rgba(255, 255, 255, 0.1);
            /* 光碟纹理 */
            .disc-texture {
              position: absolute;
              width: 100%;
              height: 100%;
              background: repeating-radial-gradient(
                circle at 50% 50%,
                rgba(255, 255, 255, 0.02) 0,
                rgba(255, 255, 255, 0.02) 1px,
                transparent 1px,
                transparent 3px
              );
            }
            /* 专辑封面 */
            .album-cover {
              position: absolute;
              width: 220px;
              height: 220px;
              left: 50%;
              top: 50%;
              transform: translate(-50%, -50%);
              border-radius: 50%;
              object-fit: cover;
              filter: brightness(0.95);
              box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            }
          }
        }
      }
      /* 播放状态 */
      .vinyl-player .disc-surface {
        animation: disc-rotate 20s linear infinite;
        animation-play-state: paused; /* 默认暂停 */
      }
      .vinyl-player.playing .disc-surface {
        animation-play-state: running;
      }

      @keyframes disc-rotate {
        from {
          transform: rotate(0deg);
        }
        to {
          transform: rotate(360deg);
        }
      }
    }

    .right {
      width: 53%;
      height: 100%;
      color: #fff;
      .title {
        font-size: 26px;
        font-weight: bold;
        margin-bottom: 10px;
      }
      .info {
        margin-bottom: 20px;
        color: #ccc;
        .album {
          margin-right: 20px;
        }
      }
      .icon {
        width: 60px;
        height: 30px;
        border-radius: 10px;
        background: #584f59;
        text-align: center;
        line-height: 30px;
      }
      .lyrics {
        width: 500px;
        // height: 400px;
        margin-top: 30px;
      }
    }
  }
}
</style>
