<script setup lang="ts">
import { reactive } from 'vue'

let songList = reactive([
  {
    name: '哪里都是你',
    time: '03:30',
    album: '哪里都是你',
  },
  {
    name: '夜行',
    time: '03:30',
    album: '夜行',
  },
  {
    name: '予你',
    time: '03:30',
    album: '予你',
  },
  {
    name: '寻我',
    time: '03:30',
    album: '寻我',
  },
])
</script>

<template>
  <div class="singer-detail">
    <div class="left">
      <div class="top">
        <img src="@/assets/images/user.jpg" alt="" />
      </div>
      <div class="bottom">
        <h1>基本资料</h1>
        <span>性别：女</span>
        <span>地区：中国</span>
        <span>出生日期：1990-10-15</span>
      </div>
    </div>
    <div class="right">
      <div class="name">队长</div>
      <div class="desc">
        队长（YoungCaptain）是一位备受瞩目的中国内地说唱歌手，以其独特的音乐风格和深情的歌词赢得了大量粉丝的喜爱。
        他在抖音等短视频平台上迅速走红，作品多次登上热门榜单，展现了强大的音乐创作能力和舞台表现力。
        队长的音乐作品以真挚的情感和贴近生活的主题著称，深受年轻一代的共鸣。他在舞台上的魅力和对音乐的热忱，使他成为华语乐坛备受关注的新生代歌手。
      </div>
      <div class="song">
        <el-table :data="songList" style="width: 100%">
          <el-table-column prop="name" label="歌曲名" width="180" />
          <el-table-column prop="time" label="时长" width="180" />
          <el-table-column prop="album" label="专辑" />
        </el-table>
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.singer-detail {
  padding: 30px 50px;
  display: flex;
  justify-content: space-between;
  .left {
    width: 30%;
    .top {
      img {
        width: 280px;
        height: 300px;
        border-radius: 5px;
      }
    }
    .bottom {
      display: flex;
      flex-direction: column;
      margin-top: 30px;
    }
  }
  .right {
    width: 70%;
    .name {
      font-size: 23px;
      font-weight: bold;
    }
    .desc {
      margin-top: 5px;
    }
    .song {
      margin-top: 50px;
    }
  }
}
</style>
