<script setup lang="ts"></script>

<template>
  <div class="singer">
    <div class="title">
      <span class="active">全部</span>
      <span>男歌手</span>
      <span>女歌手</span>
      <span>组合歌手</span>
    </div>
    <div class="content">
      <div
        class="singer-item"
        v-for="item in 10"
        :key="item"
        @click="$router.push(`/singerdetail?${1}`)"
      >
        <img src="@/assets/images/user.jpg" alt="" />
        <div class="info">
          <span class="name">周杰伦</span>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.singer {
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
    .singer-item {
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
