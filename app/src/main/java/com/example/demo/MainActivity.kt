package com.example.demo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * RelativeLayout 示例程序
 *
 * 展示如何在 Android 中使用 RelativeLayout 进行相对布局
 * RelativeLayout 允许子视图相对于父容器或其他子视图进行定位
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建根布局 - 使用 ConstraintLayout
        val rootLayout = ConstraintLayout(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
        }

        val titleId = View.generateViewId()
        val descriptionId = View.generateViewId()
        val buttonAId = View.generateViewId()
        val buttonBId = View.generateViewId()
        val buttonCId = View.generateViewId()

        // 创建 RelativeLayout 作为主要布局容器
        val relativeLayout = RelativeLayout(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
                topMargin = 16
                bottomMargin = 16
                leftMargin = 16
                rightMargin = 16
            }
            // 设置内边距
            setPadding(16, 16, 16, 16)
        }

        // 创建标题 TextView - 位于顶部居中
        val titleText = TextView(this).apply {
            id = titleId
            text = "RelativeLayout 示例"
            textSize = 24f
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.CENTER_HORIZONTAL)  // 水平居中
                addRule(RelativeLayout.ALIGN_PARENT_TOP)   // 顶部对齐
            }
        }

        // 创建中间的文本说明 - 位于标题下方
        val descriptionText = TextView(this).apply {
            id = descriptionId
            text = "RelativeLayout 允许子视图相对于父容器或其他子视图进行定位"
            textSize = 14f
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.BELOW, titleId)  // 在标题下方
                addRule(RelativeLayout.CENTER_HORIZONTAL)          // 水平居中
                topMargin = 24
            }
        }

        // 创建按钮 A - 位于中间描述文字下方
        val buttonA = Button(this).apply {
            text = "按钮 A"
            id = buttonAId
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.BELOW, descriptionId)  // 在描述下方
                addRule(RelativeLayout.CENTER_HORIZONTAL)                // 水平居中
                topMargin = 24
            }
        }

        // 创建按钮 B - 位于按钮 A 左侧
        val buttonB = Button(this).apply {
            text = "按钮 B"
            id = buttonBId
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.ABOVE, buttonCId)  // 在按钮 C 上方
                addRule(RelativeLayout.LEFT_OF, buttonAId) // 在按钮 A 左侧
                topMargin = 100
            }
        }

        // 创建按钮 C - 位于底部居中
        val buttonC = Button(this).apply {
            text = "按钮 C"
            id = buttonCId
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.ABOVE, buttonAId)  // 在按钮 A 上方
                addRule(RelativeLayout.CENTER_HORIZONTAL)           // 水平居中
            }
        }

        // 将所有子视图添加到 RelativeLayout
        relativeLayout.addView(titleText)
        relativeLayout.addView(descriptionText)
        relativeLayout.addView(buttonA)
        relativeLayout.addView(buttonB)
        relativeLayout.addView(buttonC)

        // 将 RelativeLayout 添加到根布局
        rootLayout.addView(relativeLayout)

        // 设置内容视图
        setContentView(rootLayout)
    }
}
