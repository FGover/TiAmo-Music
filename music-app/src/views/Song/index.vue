<script setup lang="ts"></script>

<template>
  <div class="song">
    <div class="title">
      <span class="active">全部</span>
      <span>华语</span>
      <span>粤语</span>
      <span>欧美</span>
      <span>日韩</span>
      <span>轻音乐</span>
      <span>BGM</span>
      <span>乐器</span>
    </div>
    <div class="content">
      <div
        class="song-item"
        v-for="item in 10"
        :key="item"
        @click="$router.push(`/songdetail?${1}`)"
      >
        <img src="@/assets/images/user.jpg" alt="" />
        <div class="info">
          <span class="name">治愈人心</span>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.song {
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
    padding: 10px 200px;
    display: flex;
    flex-wrap: wrap;
    gap: 30px;
    margin-top: 5px;
    .song-item {
      width: calc(20% - 30px);
      height: calc(20% - 30px);
      text-align: center;
      cursor: pointer;
      img {
        width: 100%;
        height: 100%;
        border-radius: 10px;
        &:hover {
          transition: all 0.3s;
          transform: scale(1.1);
        }
      }
      .info {
        margin-top: 10px;
      }
    }
  }
}
</style>
