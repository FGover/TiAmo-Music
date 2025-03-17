<script setup lang="ts">
import { reactive } from 'vue'
import CommentCard from '@/components/Comment/index.vue'
import type { VideoItem } from '@/types/video'
import video1 from '@/assets/videos/1.mp4'

let video = reactive<VideoItem>({
  id: 1,
  url: video1,
  title: '你看那个风，吹的一动一动的，好凉快啊',
  views: 888,
  isPlaying: false,
  isExpanded: false,
})
</script>

<template>
  <div class="mvdetail">
    <div class="left">
      <div class="top">
        <video :src="video.url" controls autoplay muted></video>
      </div>
      <div class="bottom">
        <span>
          <img src="@/assets/icons/views.png" alt="" />
          <p>888</p>
        </span>
        <span>
          <img src="@/assets/icons/love.png" alt="" />
          <img v-if="false" src="@/assets/icons/love-active.png" alt="" />
          <p>888</p>
        </span>
        <span>
          <img src="@/assets/icons/like-active.png" alt="" />
          <img v-if="false" src="@/assets/icons/like.png" alt="" />
          <p>888</p>
        </span>
      </div>
    </div>
    <div class="right">
      <div class="top">
        <h1 class="title">地铁B口</h1>
        <p>
          从地铁口出来，迎面而来的是一阵轻微的热风，夹杂着城市的喧嚣。自动扶梯缓缓向上，头顶的灯光逐渐被自然光取代，视野变得开阔。人流川流不息，有人步履匆匆地朝着目的地奔去，也有人在出口处驻足整理背包或看向手机确认方向。街道上，车辆疾驰而过，行人穿梭在斑马线上，远处的高楼大厦在阳光下闪烁着玻璃的光芒。空气中混杂着早餐铺飘来的香味，偶尔还能听到小贩的吆喝声，城市的一天正式拉开帷幕。
        </p>
      </div>
      <div class="comment">
        <div class="comment-top">
          <h1>评论</h1>
          <span>102</span>
        </div>
        <div class="content">
          <CommentCard />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.mvdetail {
  padding: 20px 50px;
  width: 100%;
  height: 100%;
  display: flex;
  .left {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 30%;
    margin-right: 3%;
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.1);
    .top {
      width: 100%;
      height: 50%;
      video {
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    }
    .bottom {
      display: flex;
      align-items: center;
      margin-top: 50px;
      span {
        display: block;
        width: 100px;
        height: 50px;
        display: flex;
        align-items: center;
        cursor: pointer;
        img {
          width: 30px;
          height: 30px;
        }
        p {
          font-size: 17px;
          margin-left: 10px;
        }
      }
    }
  }
  .right {
    padding: 20px 50px;
    width: 67%;
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.1);
    .top {
      .title {
        font-size: 24px;
        background: #800020;
        width: 120px;
        text-align: center;
        border-radius: 5px;
        color: #fff;
      }
      p {
        font-size: 16px;
        margin-top: 10px;
        line-height: 30px;
        color: #666666;
      }
    }
    .comment {
      .comment-top {
        margin-top: 20px;
        display: flex;
        align-items: end;
        justify-content: center;
        background: #800020;
        width: 120px;
        border-radius: 5px;
        color: #fff;
        h1 {
          font-size: 24px;
        }
        span {
          font-size: 16px;
          margin-left: 10px;
        }
      }
      .content {
        margin-top: 20px;
      }
    }
  }
}
</style>
