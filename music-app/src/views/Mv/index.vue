<script setup lang="ts">
import video1 from '@/assets/videos/1.mp4'
import video2 from '@/assets/videos/2.mp4'
import video3 from '@/assets/videos/3.mp4'
import video4 from '@/assets/videos/4.mp4'
import video5 from '@/assets/videos/5.mp4'
import video6 from '@/assets/videos/6.mp4'
import video7 from '@/assets/videos/7.mp4'
import video8 from '@/assets/videos/8.mp4'
import video9 from '@/assets/videos/9.mp4'
import video10 from '@/assets/videos/10.mp4'
import video11 from '@/assets/videos/11.mp4'
import video12 from '@/assets/videos/12.mp4'
import video13 from '@/assets/videos/13.mp4'
import video14 from '@/assets/videos/14.mp4'
import video15 from '@/assets/videos/15.mp4'
import video16 from '@/assets/videos/16.mp4'
import video17 from '@/assets/videos/17.mp4'
import video18 from '@/assets/videos/18.mp4'
import video19 from '@/assets/videos/19.mp4'
import video20 from '@/assets/videos/20.mp4'
import video21 from '@/assets/videos/21.mp4'
import video22 from '@/assets/videos/22.mp4'
import video23 from '@/assets/videos/23.mp4'
import type { VideoItem } from '@/types/video'
import { reactive } from 'vue'
import Item from './components/Item/index.vue'

let videoList = reactive<VideoItem[]>([
  {
    id: 1,
    url: video1,
    title: '你看那个风，吹的一动一动的，好凉快啊',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 2,
    url: video2,
    title: '给你看看地铁站的出口',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 3,
    url: video3,
    title: '给你看看这个房间',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 4,
    url: video4,
    title: '给你看看我们学校的大门',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 5,
    url: video5,
    title: '转转，这是我点的吃的',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 6,
    url: video6,
    title: '给你看看这个树，哎呀我放大一下',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 7,
    url: video7,
    title: '给你看看我们学校的饭堂',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 8,
    url: video8,
    title: '我的无力成为了我的败笔，我想你了',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 9,
    url: video9,
    title: '我天，我们这有彩虹，你看到没',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 10,
    url: video10,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 11,
    url: video11,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 12,
    url: video12,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 13,
    url: video13,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 14,
    url: video14,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 15,
    url: video15,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 16,
    url: video16,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 17,
    url: video17,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 18,
    url: video18,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 19,
    url: video19,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 20,
    url: video20,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 21,
    url: video21,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 22,
    url: video22,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
  {
    id: 23,
    url: video23,
    title: '我的无力成为了我的败笔，我想你了哈哈哈',
    views: 888,
    isPlaying: false,
    isExpanded: false,
  },
])
</script>

<template>
  <div class="mv">
    <div class="title">
      <span class="active">全部</span>
      <span>热门</span>
      <span>最新</span>
      <span>动画</span>
      <span>TiAmo</span>
    </div>
    <div class="content">
      <div class="mvItem" v-for="video in videoList" :key="video.id">
        <!-- item组件 -->
        <Item :item="video" />
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.mv {
  padding: 20px 30px;
  width: 100%;
  .title {
    width: 100%;
    height: 60px;
    line-height: 60px;
    font-size: 16px;
    display: flex;
    span {
      display: block;
      width: 80px;
      height: 60px;
      margin-left: 60px;
      cursor: pointer;
      &:hover {
        transition: all 0.3s;
        transform: scale(1.1);
      }
      &.active {
        color: #800020;
        font-weight: bold;
      }
    }
  }
  .content {
    display: flex;
    flex-wrap: wrap;
    padding-top: 10px;
    .mvItem {
      width: 20%;
      height: 280px;
      margin-bottom: 30px;
      padding: 5px 20px;
      /** 盒子阴影 */
      box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.1);
      border-radius: 10px;
      &:hover {
        transition: all 0.3s;
        transform: scale(1.1);
      }
    }
  }
}
</style>
