<script setup lang="ts">
import { reactive, ref } from 'vue'
import Comment from '@/components/Comment/index.vue'

let songList = reactive([
  {
    name: '哪里都是你',
    singer: '队长',
    time: '03:30',
    album: '哪里都是你',
  },
  {
    name: '夜行',
    singer: '队长',
    time: '03:30',
    album: '夜行',
  },
  {
    name: '修炼爱情',
    singer: '林俊杰',
    time: '04:30',
    album: '修炼爱情',
  },
  {
    name: '于是',
    singer: '郑润泽',
    time: '03:50',
    album: '于是',
  },
])

let score1 = ref(4.5)
let score2 = ref(5)
</script>

<template>
  <div class="song-detail">
    <div class="left">
      <div class="top">
        <img src="@/assets/images/user.jpg" alt="" />
      </div>
      <div class="bottom">
        <div class="title">治愈人心</div>
        <div class="name">简介</div>
        <div class="desc">
          队长（YoungCaptain）是一位备受瞩目的中国内地说唱歌手，以其独特的音乐风格和深情的歌词赢得了大量粉丝的喜爱。
          他在抖音等短视频平台上迅速走红，作品多次登上热门榜单，展现了强大的音乐创作能力和舞台表现力。
          队长的音乐作品以真挚的情感和贴近生活的主题著称，深受年轻一代的共鸣。他在舞台上的魅力和对音乐的热忱，使他成为华语乐坛备受关注的新生代歌手。
        </div>
        <div class="score">
          <div class="score1">
            <div class="text">歌曲评分：4.5</div>
            <el-rate v-model="score1" allow-half />
          </div>
          <div class="score2">
            <div v-if="false" class="text">评分</div>
            <div class="text">已评分</div>
            <el-rate v-model="score2" allow-half />
          </div>
        </div>
      </div>
    </div>
    <div class="right">
      <div class="top">
        <el-table :data="songList" style="width: 100%">
          <el-table-column prop="name" label="歌曲名" width="180" />
          <el-table-column prop="singer" label="歌手名" width="180" />
          <el-table-column prop="time" label="时长" width="180" />
          <el-table-column prop="album" label="专辑" width="180" />
        </el-table>
        <div class="bottom">
          <Comment />
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.song-detail {
  padding: 20px 50px;
  display: flex;
  justify-content: space-between;
  width: 100%;
  .left {
    width: 30%;
    display: flex;
    flex-direction: column;
    align-items: center;
    img {
      width: 200px;
      height: 200px;
      border-radius: 10px;
    }
    .bottom {
      margin-top: 20px;
      font-size: 18px;
      /** 换字体 */
      font-family: 'KaiTi';
      .title {
        text-align: center;
      }
      .name {
        margin-top: 20px;
        font-weight: bold;
        font-size: 20px;
      }
      .score {
        margin-top: 30px;
        display: flex;
        align-items: center;
        justify-content: space-around;
      }
    }
  }
  .right {
    width: 70%;
    display: flex;
    flex-direction: column;
    align-items: center;
    .bottom {
      margin-top: 20px;
    }
  }
}
</style>
