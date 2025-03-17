<script setup lang="ts">
import Item from './Item/index.vue'
const props = defineProps<{
  recentTracks: Array<any>
}>()
</script>

<template>
  <div class="recent-container">
    <div class="list">
      <Item :recentTracks="props.recentTracks" />
    </div>
  </div>
</template>

<style lang="less" scoped>
.recent-container {
  width: 100%;
  padding: 0 20px;
  .list {
    display: flex;
    flex-direction: column;
    gap: 10px;
    height: calc(60vh - 80px);
    overflow: hidden;
    overflow-y: auto;
    scrollbar-width: none;
    -ms-overflow-style: none;
    &::-webkit-scrollbar {
      width: 0;
      height: 0;
      background: transparent;
    }
    color: #4a4a4a;
  }
}
</style>
