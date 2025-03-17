<script setup lang="ts">
import { ref, reactive, nextTick } from 'vue'
import { Star, StarFilled } from '@element-plus/icons-vue'
import { formatTime } from '@/utils/formatTime.ts'

interface User {
  id: string
  name: string
  avatar: string
}

interface Comment {
  id: string
  user: User
  content: string
  time: Date
  likes: number
  liked: boolean
  replies: Comment[]
  showReply: boolean
  replyText: string
}

const currentUser = reactive<User>({
  id: '123',
  name: '当前用户',
  avatar: 'https://example.com/avatar.jpg',
})

const comments = reactive<Comment[]>([
  {
    id: '1',
    user: {
      id: '456',
      name: '用户1',
      avatar: 'https://example.com/user1.jpg',
    },
    content: '这个视频内容真不错！',
    time: new Date(Date.now() - 3600000),
    likes: 42,
    liked: false,
    replies: [],
    showReply: false,
    replyText: '',
  },
])

const newComment = ref('')
// 发布主评论
const postComment = () => {
  if (!newComment.value.trim()) return
  const comment: Comment = {
    id: Date.now().toString(),
    user: { ...currentUser },
    content: newComment.value.trim(),
    time: new Date(),
    likes: 0,
    liked: false,
    replies: [],
    showReply: false,
    replyText: '',
  }

  comments.unshift(comment)
  newComment.value = ''
}

// 点赞/取消点赞
const toggleLike = (target: Comment) => {
  target.liked = !target.liked
  target.likes += target.liked ? 1 : -1
}

// 切换回复输入框显示
const toggleReply = (comment: Comment) => {
  comment.showReply = !comment.showReply
  if (comment.showReply) {
    nextTick(() => {
      const input = document.querySelector('.reply-input .el-input__inner') as HTMLInputElement
      input?.focus()
    })
  }
}

// 发布回复
const postReply = (parent: Comment) => {
  if (!parent.replyText.trim()) return

  const reply: Comment = {
    id: `${parent.id}-${Date.now()}`,
    user: { ...currentUser },
    content: parent.replyText.trim(),
    time: new Date(),
    likes: 0,
    liked: false,
    replies: [],
    showReply: false,
    replyText: '',
  }

  parent.replies.push(reply)
  parent.showReply = false
  parent.replyText = ''
}
</script>

<template>
  <div class="comment-section">
    <!-- 评论输入框 -->
    <div class="comment-input">
      <el-avatar :size="40" :src="currentUser.avatar" class="avatar" />
      <div class="input-container">
        <el-input
          v-model="newComment"
          type="textarea"
          :rows="2"
          placeholder="写下你的评论..."
          resize="none"
          maxlength="300"
          show-word-limit
        />
        <div class="action-bar">
          <el-button size="small" @click="postComment" :disabled="!newComment.trim()">
            发布
          </el-button>
        </div>
      </div>
    </div>

    <!-- 评论列表 -->
    <div class="comment-list">
      <div v-for="comment in comments" :key="comment.id" class="comment-item">
        <!-- 主评论 -->
        <div class="main-comment">
          <el-avatar :size="36" :src="comment.user.avatar" />
          <div class="content">
            <div class="header">
              <span class="username">{{ comment.user.name }}</span>
              <span class="time">{{ formatTime(comment.time) }}</span>
            </div>
            <div class="text">{{ comment.content }}</div>
            <div class="actions">
              <el-button
                link
                :icon="comment.liked ? StarFilled : Star"
                @click="toggleLike(comment)"
              >
                {{ comment.likes }}
              </el-button>
              <el-button link @click="toggleReply(comment)"> 回复 </el-button>
            </div>
          </div>
        </div>

        <!-- 回复输入框 -->
        <div v-if="comment.showReply" class="reply-input">
          <el-avatar :size="32" :src="currentUser.avatar" />
          <div class="input-container">
            <el-input
              v-model="comment.replyText"
              placeholder="写下你的回复..."
              ref="replyInput"
              @keyup.enter="postReply(comment)"
            />
            <el-button
              size="small"
              @click="postReply(comment)"
              :disabled="!comment.replyText.trim()"
            >
              发送
            </el-button>
          </div>
        </div>

        <!-- 子评论列表 -->
        <div v-if="comment.replies?.length" class="sub-comments">
          <div v-for="reply in comment.replies" :key="reply.id" class="sub-comment-item">
            <el-avatar :size="32" :src="reply.user.avatar" />
            <div class="content">
              <div class="header">
                <span class="username">{{ reply.user.name }}</span>
                <span class="time">{{ formatTime(reply.time) }}</span>
              </div>
              <div class="text">{{ reply.content }}</div>
              <div class="actions">
                <el-button link :icon="reply.liked ? StarFilled : Star" @click="toggleLike(reply)">
                  {{ reply.likes }}
                </el-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.comment-section {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;

  /* 修改所有输入框的聚焦颜色 */
  :deep(.el-input__wrapper.is-focus) {
    box-shadow: 0 0 0 1px #800020 inset !important;
  }

  /* 修改文本域的聚焦颜色 */
  :deep(.el-textarea__inner:focus) {
    box-shadow: 0 0 0 1px #800020 inset !important;
    border-color: #800020 !important;
  }

  :deep(.el-button) {
    --el-button-bg-color: #800020 !important;
    --el-button-border-color: #800020 !important;
    --el-button-hover-bg-color: #a00028 !important;
    --el-button-hover-border-color: #a00028 !important;
    --el-button-active-bg-color: #600018 !important;
    --el-button-active-border-color: #600018 !important;
  }

  /* 修改按钮的禁用颜色 */
  :deep(.el-button.is-disabled) {
    --el-button-disabled-bg-color: #c0a0a0 !important;
    --el-button-disabled-border-color: #c0a0a0 !important;
    --el-button-disabled-text-color: #666 !important;
  }

  /** 不禁用的字体颜色 */
  :deep(.el-button:not(.is-disabled)) {
    color: #fff;
  }

  .comment-input {
    display: flex;
    gap: 12px;
    margin-bottom: 24px;

    .input-container {
      flex: 1;

      .action-bar {
        margin-top: 8px;
        text-align: right;
      }
    }
  }

  .comment-list {
    height: 280px;
    overflow: auto;
    /** 隐藏滚动条 */
    scrollbar-width: none;
    &::-webkit-scrollbar {
      display: none;
    }
    .comment-item {
      padding: 16px 0;
      border-bottom: 1px solid #eee;

      .main-comment {
        display: flex;
        gap: 12px;

        .content {
          flex: 1;

          .header {
            margin-bottom: 4px;
            font-size: 0.9em;

            .username {
              font-weight: 500;
              margin-right: 8px;
            }

            .time {
              color: #666;
            }
          }

          .text {
            line-height: 1.5;
            margin-bottom: 8px;
          }

          .actions {
            :deep(.el-button) {
              padding: 0 8px;
              color: #666;
            }
          }
        }
      }

      .reply-input {
        margin: 12px 0 12px 48px;
        display: flex;
        gap: 8px;
        align-items: center;

        .input-container {
          flex: 1;
          display: flex;
          gap: 8px;
        }
      }

      .sub-comments {
        margin-left: 48px;
        border-left: 2px solid #eee;
        padding-left: 16px;

        .sub-comment-item {
          display: flex;
          gap: 8px;
          padding: 12px 0;

          .content {
            flex: 1;

            .header {
              font-size: 0.85em;

              .username {
                font-weight: 500;
              }

              .time {
                color: #666;
              }
            }

            .text {
              color: #444;
              font-size: 0.95em;
            }
          }
        }
      }
    }
  }
}
</style>
