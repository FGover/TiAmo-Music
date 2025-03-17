<script setup lang="ts">
import { ref, reactive } from 'vue'
import RecentTrack from './RecentTrack.vue'
import LoveMusic from './LoveMusic.vue'
import UserInfo from './UserInfo.vue'
import avatar from '@/assets/images/user.jpg'

// 用户信息
let user = reactive({
  name: 'FG',
  avatar: avatar,
  bio: '音乐让生活更美好 🎵',
})

// 用户的歌单
let playlists = ref([
  { id: 1, name: '我的最爱', cover: '@/assets/images/playlist1.jpg', count: 15 },
  { id: 2, name: '轻音乐', cover: '@/assets/images/playlist2.jpg', count: 20 },
  { id: 3, name: '摇滚精选', cover: '@/assets/images/playlist3.jpg', count: 12 },
])

// 最近播放
let recentTracks = ref([
  { id: 101, title: '夜的第七章', artist: '周杰伦' },
  { id: 102, title: '晴天', artist: '周杰伦' },
  { id: 103, title: '稻香', artist: '周杰伦' },
  { id: 104, title: '告白气球', artist: '周杰伦' },
  { id: 105, title: '青花瓷', artist: '周杰伦' },
  { id: 106, title: '七里香', artist: '周杰伦' },
  { id: 107, title: '夜曲', artist: '周杰伦' },
  { id: 108, title: '不能说的秘密', artist: '周杰伦' },
  { id: 109, title: '晴天', artist: '周杰伦' },
  { id: 110, title: '稻香', artist: '周杰伦' },
  { id: 111, title: '告白气球', artist: '周杰伦' },
  { id: 112, title: '青花瓷', artist: '周杰伦' },
  { id: 113, title: '七里香', artist: '周杰伦' },
  { id: 114, title: '夜曲', artist: '周杰伦' },
  { id: 115, title: '不能说的秘密', artist: '周杰伦' },
])
let isRecent = ref(false)
let isLove = ref(false)

let isShow = ref(false)
const updateUserInfo = () => {
  isShow.value = !isShow.value
}
</script>

<template>
  <div class="user">
    <div class="content">
      <div class="profile-container" :class="{ showing: isRecent || isLove }">
        <!-- 个人信息 -->
        <div class="profile-header">
          <img :src="user.avatar" alt="头像" class="avatar" />
          <div class="user-info">
            <h2>{{ user.name }}</h2>
            <p>{{ user.bio }}</p>
          </div>
          <div class="btn" @click="updateUserInfo">修改个人信息</div>
        </div>
        <div class="profile-content">
          <!-- 用户收藏 -->
          <div class="section">
            <h3>🎵 我喜欢歌单</h3>
          </div>
          <div
            class="section"
            @click="((isLove = !isLove), (isRecent = false))"
            :class="{ active: isLove }"
          >
            <h3>🎵 我喜欢歌曲</h3>
          </div>

          <!-- 最近播放 -->
          <div
            class="section"
            @click="((isRecent = !isRecent), (isLove = false))"
            :class="{ active: isRecent }"
          >
            <h3>🎧 最近播放</h3>
          </div>
        </div>
      </div>
      <transition name="fade">
        <RecentTrack v-if="isRecent" class="right-box" :recentTracks="recentTracks" />
      </transition>
      <transition name="fade">
        <LoveMusic v-if="isLove" class="right-box" :recentTracks="recentTracks" />
      </transition>
      <UserInfo :userInfo="user" v-if="isShow" />
    </div>
    <div class="footer">
      <p>© 2025 TiAmo-Music. All rights reserved</p>
      <p>Author：FG</p>
      <p>Designed with ❤ for ChenChuanYing</p>
    </div>
  </div>
</template>

<style scoped lang="less">
.user {
  padding: 40px 100px;
  height: calc(100vh - 260px);
  /* 渐入渐出动画 */
  .fade-enter-active,
  .fade-leave-active {
    transition:
      opacity 0s ease-in-out,
      transform 0s ease-in-out;
  }
  .fade-enter-from,
  .fade-leave-to {
    opacity: 0;
    transform: translateX(20px);
  }
  .content {
    display: flex;
    width: calc(100vw - 240px);
    height: 60vh;
  }
  .profile-container {
    flex: 1;
    transition: flex 0.7s ease-in-out;
    overflow: hidden;
    border-radius: 10px;
    &.showing {
      flex: 0.3;
    }
    /* 个人信息 */
    .profile-header {
      display: flex;
      align-items: center;
      padding: 20px;
      background: #c0a0a0;
      color: white;
      border-radius: 10px;
      .avatar {
        width: 120px;
        height: 120px;
        border-radius: 50%;
        border: 3px solid white;
      }
      .user-info {
        margin-left: 20px;
      }
      h2 {
        margin: 0;
      }
      .btn {
        margin-left: auto;
        padding: 5px 10px;
        background: #fff;
        color: #c0a0a0;
        border-radius: 5px;
        cursor: pointer;
        user-select: none;
      }
    }
    .profile-content {
      margin-top: 30px;
      height: calc(60vh - 190px);
      overflow-y: auto;
      scrollbar-width: none;
      -ms-overflow-style: none;
      &::-webkit-scrollbar {
        width: 0;
        height: 0;
        background: transparent;
      }
      /* 歌单 */
      .section {
        user-select: none;
        margin-top: 30px;
        padding: 15px;
        background: white;
        border-radius: 10px;
        &:hover {
          background: #dbcfcf;
        }
        &.active {
          color: #d8b3b3;
        }
      }
    }
  }
  .right-box {
    flex: 0.7;
    border-radius: 10px;
    margin-left: 30px;
  }
  .footer {
    margin-top: 30px;
    text-align: center;
    padding: 10px;
    font-size: 16px;
    user-select: none;
    /** 换字体 */
    font-family: 'Courier New', Courier, monospace;
  }
}
</style>
