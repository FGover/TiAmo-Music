<script setup lang="ts">
import { reactive } from 'vue'
import Video from '@/views/Mv/components/Video/index.vue'
import type { VideoItem } from '@/types/video'

import img1 from '@/assets/images/1.jpg'
import img2 from '@/assets/images/2.jpg'
import img3 from '@/assets/images/3.jpg'
import img4 from '@/assets/images/4.jpg'
import img5 from '@/assets/images/5.jpg'
import img6 from '@/assets/images/6.jpg'

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

let carouselList = reactive([
  { id: 1, url: img1 },
  { id: 2, url: img2 },
  { id: 3, url: img3 },
  { id: 4, url: img4 },
  { id: 5, url: img5 },
  { id: 6, url: img6 },
])

let hotSongList = reactive([
  {
    id: 1,
    url: 'http://p1.music.126.net/0qvXaN0Yf3xDKafF2gdDqA==/109951168993484961.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 2,
    url: 'http://p1.music.126.net/AIe4GxZANX60qT9bfP6BJA==/109951170104280571.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzU3ODAwNDMzOTQyL2MzMTcvMjAyNTAyMjE1NDA0L3g2MjkxNzM3NTMxNjA0NTU0LnBuZw==&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 3,
    url: 'http://p1.music.126.net/2KNSxVUjGJdqU_XES9-1dw==/109951169282788572.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzMzMDQyODkzNzk3Lzc0YTMvMjAyNDAyNDE2NDYxNi94OTM0MTcwNjA4NTk3Njc1Ny5wbmc=&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 4,
    url: 'http://p1.music.126.net/bMw2yDY_B_UAgKOsYN3h0g==/109951169158781253.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzMyMDkwMzI2NDU0LzY1MzIvMjAyMzExMTMxMTgzMi94Nzk1MTcwMjQzNjkxMjI0OC5wbmc=&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 5,
    url: 'http://p1.music.126.net/eyXd9bRtoa2NcMOYMOmyAg==/109951170480475023.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzU4Mjc0NDI0MDAzLzA0NmMvMjAyNTExOTEwNTIzNS94NjUwMTczOTkzMzU1NTQzMi5wbmc=&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 6,
    url: 'http://p1.music.126.net/e7vk_ptsHi82tBzY0WUTYg==/109951169253757717.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzU2NTA4ODQ1MDYxLzk1YzkvMjAyNDEwMTUxOTEzOC94Mzg1MTczMTY2OTE4ODAyMi5wbmc=&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 7,
    url: 'http://p1.music.126.net/tYf0DD2XH1S_OaMyW1JeRA==/109951168603050536.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzI4NzMxODIxODMwLzIxNWEvMjAyMzUxNDExNDExL3gyODUxNjg2NzExODUxMTg1LnBuZw==&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 8,
    url: 'http://p1.music.126.net/rWIs_94QrTmQTxoQzZzUaw==/109951168605373697.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzU4MTkwMzI5NTU1LzU2ZDcvMjAyNTExNDEwMTUzOC94MjA4MTczOTQ5OTMzODgxMC5wbmc=&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 9,
    url: 'http://p1.music.126.net/ZmI66m0FOrAUtF6C97-Gtg==/109951170416380843.jpg?imageView=1&thumbnail=800y800&enlarge=1%7CimageView=1&watermark&type=1&image=b2JqL3c1bkRrTUtRd3JMRGpEekNtOE9tLzU3ODIwODY4NTExLzM4ZTUvMjAyNTAyMzE3MzcyMi94NTU3MTczNzYyNTA0Mjg3My5wbmc=&dx=0&dy=0%7Cwatermark&type=1&image=b2JqL3dvbkRsc0tVd3JMQ2xHakNtOEt4LzI3NjEwNDk3MDYyL2VlOTMvOTIxYS82NjE4LzdhMDc5ZDg0NTYyMDAwZmVkZWJmMjVjYjE4NjhkOWEzLnBuZw==&dx=0&dy=0%7CimageView=1&thumbnail=140y140&?param=140y140',
  },
  {
    id: 10,
    url: 'http://p1.music.126.net/kS1KeMfKvDeOOb2XB_AmrQ==/109951170341049987.jpg?param=140y140',
  },
])

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
])
</script>

<template>
  <div class="home">
    <div class="carousel">
      <el-carousel :interval="4000" type="card" height="300px">
        <el-carousel-item v-for="item in carouselList" :key="item.id">
          <img :src="item.url" class="carousel-img" />
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="hotSong">
      <h1>热门歌曲</h1>
      <div class="content">
        <div class="songItem" v-for="item in hotSongList" :key="item.id">
          <img :src="item.url" />
          <p>哈哈哈</p>
        </div>
      </div>
    </div>
    <div class="hotMv">
      <h1>热门MV</h1>
      <!-- 视频组件 -->
      <Video :videoList="videoList"></Video>
    </div>
  </div>
</template>

<style scoped lang="less">
.home {
  padding: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  .carousel {
    width: 90%;
    .carousel-img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
  }
  .hotSong {
    width: 80%;
    h1 {
      width: 100%;
      height: 60px;
      line-height: 60px;
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 20px;
      margin-top: 30px;
      text-align: center;
      background: #efefef;
      /* 下边框阴影*/
      box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
      border-radius: 5px;
    }
    .content {
      width: 100%;
      display: flex;
      align-items: center;
      flex-wrap: wrap;
      margin-bottom: 10px;
      .songItem {
        width: 20%;
        height: 250px;
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 20px;
        margin-top: 20px;
        img {
          width: 200px;
          height: 200px;
          object-fit: cover;
          border-radius: 10px;
          cursor: pointer;
          &:hover {
            transform: scale(1.05);
            transition: all 0.5s ease-in-out;
          }
        }
        .text {
          width: 200px;
          height: 30px;
          margin-top: 10px;
          padding: 0 5px;
          word-wrap: break-word;
        }
      }
    }
  }
  .hotMv {
    width: 80%;
    h1 {
      width: 100%;
      height: 60px;
      line-height: 60px;
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 20px;
      margin-top: 30px;
      text-align: center;
      background: #efefef;
      /* 下边框阴影*/
      box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
      border-radius: 5px;
    }
  }
}
</style>
