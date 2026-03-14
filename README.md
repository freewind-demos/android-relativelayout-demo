# android-relativelayout-demo

## 简介

本 demo 展示了如何在 Android 应用中使用 RelativeLayout 进行相对布局。RelativeLayout 允许子视图相对于父容器或其他子视图进行定位，是实现复杂布局的常用方式。

## 基本原理

RelativeLayout 通过相对定位关系来确定子视图的位置：

- **相对于父容器**：如 `alignParentTop`、`centerHorizontal`
- **相对于其他视图**：如 `below`、`above`、`toLeftOf`、`toRightOf`
- **对齐方式**：如 `alignTop`、`alignBottom`

这种布局方式灵活性高，可以减少布局嵌套层次。

## 启动和使用

### 环境要求
- Android Studio Arctic Fox 或更高版本
- JDK 11 或更高版本
- Android SDK 34

### 安装和运行
1. 使用 Android Studio 打开本项目
2. 连接 Android 设备或启动模拟器
3. 点击 Run 按钮运行应用

## 教程

### 什么是 RelativeLayout？

RelativeLayout 是 Android 中另一种常用的布局方式，它通过相对位置关系来确定子视图的位置。这使得它比 LinearLayout 更加灵活，可以实现更复杂的界面布局。

### 核心属性

#### 相对于父容器

| 属性 | 说明 |
|------|------|
| `alignParentTop` | 与父容器顶部对齐 |
| `alignParentBottom` | 与父容器底部对齐 |
| `alignParentLeft` | 与父容器左侧对齐 |
| `alignParentRight` | 与父容器右侧对齐 |
| `centerHorizontal` | 水平居中 |
| `centerVertical` | 垂直居中 |
| `centerInParent` | 完全居中 |

#### 相对于其他视图

| 属性 | 说明 |
|------|------|
| `above` | 在指定视图上方 |
| `below` | 在指定视图下方 |
| `toLeftOf` | 在指定视图左侧 |
| `toRightOf` | 在指定视图右侧 |
| `alignTop` | 与指定视图顶部对齐 |
| `alignBottom` | 与指定视图底部对齐 |
| `alignLeft` | 与指定视图左侧对齐 |
| `alignRight` | 与指定视图右侧对齐 |

### 使用示例

```xml
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- 标题：顶部居中 -->
    <TextView
        android:id="@+id/title"
        android:text="标题"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true" />

    <!-- 描述：在标题下方 -->
    <TextView
        android:id="@+id/description"
        android:text="描述文字"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/title"
        android:layout_centerHorizontal="true" />

    <!-- 按钮 A：在描述下方 -->
    <Button
        android:id="@+id/buttonA"
        android:text="按钮 A"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/description" />

    <!-- 按钮 B：在按钮 A 右侧 -->
    <Button
        android:id="@+id/buttonB"
        android:text="按钮 B"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/buttonA"
        android:layout_alignTop="@id/buttonA" />

</RelativeLayout>
```

### 注意事项

1. **避免循环依赖**：不要让两个视图相互依赖
2. **ID 唯一性**：需要引用的视图必须设置 id
3. **性能**：复杂布局可能影响性能，建议使用 ConstraintLayout
4. **调试**：使用 Hierarchy Viewer 工具分析布局层级
