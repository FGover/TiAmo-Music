<script setup lang="ts">
import { ref, watch, nextTick, onMounted } from 'vue'
const props = defineProps<{
  lyricsData: Array<{ time: string; text: string }>
  currentTime: string
}>()

// 歌词列表
let lyricLines = ref<HTMLElement | null>(null)
let lyricsWrapper = ref<HTMLElement | null>(null)
let lyricLineRefs = ref<Array<HTMLElement | null>>([])

// 高亮索引
let activeIndex = ref(0)
// 记录用户是否手动滚动
let isUserScrolling = ref(false)
// 记录用户手动滚动的定时器
let userScrollTimeout: number | null = null

// 将'mm:ss'格式的时间转换为秒
const timeToSeconds = (time: string) => {
  let [min, sec] = time.split(':').map(Number)
  return min * 60 + sec
}

// 监听用户滚动行为
const handleScroll = () => {
  if (!isUserScrolling.value) isUserScrolling.value = true
  if (userScrollTimeout) clearTimeout(userScrollTimeout)

  // 3 秒后恢复自动滚动
  userScrollTimeout = window.setTimeout(() => {
    isUserScrolling.value = false
    scrollToActiveLyric()
  }, 3000)
}

// 滚动到高亮歌词
const scrollToActiveLyric = () => {
  if (!lyricLines.value || !lyricLineRefs.value[activeIndex.value]) return
  let container = lyricLines.value
  let activeLyric = lyricLineRefs.value[activeIndex.value]
  let wrapper = lyricsWrapper.value
  if (!activeLyric || !wrapper) return
  let containerHeight = container.clientHeight
  let lineTop = activeLyric.offsetTop - wrapper.offsetTop
  let lineHeight = activeLyric.offsetHeight // 每行歌词的高度
  container.scrollTo({
    top: lineTop - containerHeight / 2 + lineHeight / 2,
    behavior: 'smooth',
  })
}

// 监听currentTime，更新当前高亮
watch(
  () => props.currentTime,
  (newTimeStr) => {
    if (isUserScrolling.value) return // 用户手动滚动时，不自动滚动
    let currentTime = timeToSeconds(newTimeStr)
    let newIndex = props.lyricsData.findLastIndex((lyric, index) => {
      let current = timeToSeconds(lyric.time)
      let next =
        index < props.lyricsData.length - 1
          ? timeToSeconds(props.lyricsData[index + 1].time)
          : Infinity
      return currentTime >= current && currentTime < next
    })
    if (newIndex !== -1 && newIndex !== activeIndex.value) {
      activeIndex.value = newIndex
      nextTick(scrollToActiveLyric)
    }
  },
)

// 初始化垂直居中
onMounted(() => {
  if (lyricsWrapper.value) {
    const containerHeight = lyricLines.value?.clientHeight || 0
    lyricsWrapper.value.style.padding = `${containerHeight / 2}px 0`
  }
})
</script>

<template>
  <div class="lyrics-list" ref="lyricLines" @scroll="handleScroll">
    <div class="lyrics-wrapper" ref="lyricsWrapper">
      <div
        class="lyric-line"
        v-for="(lyric, index) in props.lyricsData"
        :key="index"
        :class="{ active: index === activeIndex, passed: index < activeIndex }"
        ref="lyricLineRefs"
      >
        {{ lyric.text }}
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.lyrics-list {
  height: 50vh;
  overflow-y: auto;
  scroll-behavior: smooth;
  position: relative;
  &::-webkit-scrollbar {
    width: 0;
    height: 0;
    background: transparent;
  }
  .lyrics-wrapper {
    transition: transform 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94);
    will-change: transform;
    .lyric-line {
      padding: 14px 20px;
      font-size: 18px;
      color: #666;
      text-align: center;
      transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
      opacity: 0.4;
      transform: translateZ(0) scale(0.95);
      backface-visibility: hidden;
      &.passed {
        opacity: 0.6;
        color: #999;
        transform: translateZ(0) scale(1);
      }
      &.active {
        color: #fff;
        font-size: 22px;
        opacity: 1;
        transform: translateZ(10px) scale(1.05);
        font-weight: 500;
        text-shadow:
          0 2px 8px rgba(255, 255, 255, 0.2),
          0 4px 16px rgba(255, 255, 255, 0.15);
      }
    }
  }
}
</style>
