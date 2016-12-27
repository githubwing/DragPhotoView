# DragPhotoView([English](https://github.com/githubwing/DragPhotoView/blob/master/README_EN.md))

[![](https://jitpack.io/v/githubwing/DragPhotoView.svg)](https://jitpack.io/#githubwing/DragPhotoView)

高仿微信可拖拽返回PhotoView


### 基于 [PhotoView](https://github.com/chrisbanes/PhotoView)

##[下载APK体验](https://github.com/githubwing/DragPhotoView/raw/master/app-debug.apk)

## 特性
- 拖拽缩放图片,并且结束Activity
- 其他PhotoView所有特性如下:

>- Out of the box zooming, using multi-touch and double-tap.
>- Scrolling, with smooth scrolling fling.
>- Works perfectly when used in a scrolling parent (such as ViewPager).
>- Allows the application to be notified when the displayed Matrix has changed. Useful for when you need to update your UI based on the >current zoom/scroll position.
>- Allows the application to be notified when the user taps on the Photo.

![image](https://github.com/githubwing/DragPhotoView/raw/master/img/img.gif)



# 使用

修改你的  `build.gradle`文件

```gradle

//root project
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
    
//module project
    	dependencies {
	        compile 'com.github.githubwing:DragPhotoView:1.0.1'
	}
    
```

使用法放和普通的ImageView一毛一样

```java


	// 所有ImageView用法都可以	
	DragPhotoView photoView = (DragPhotoView)findViewById(R.id.photoView);
	photoView.setImageResource(R.drawable.ram);
	//必须添加一个onExitListener,在拖拽到底部时触发.	
	photoView.setOnExitListener()
	
	photoView.setOnTapListener()
```

## 小贴士

想要达到demo效果,需要把你的Activity背景改为透明

修改`style.xml`
```xml
  <style name="translucent" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="android:windowBackground" >@android:color/transparent</item>
        <item name="android:windowIsTranslucent">true</item>
    </style>
```
全版本共享元素实现(包括Activity转跳和拖拽共享元素)在Demo里,如有需要,参照demo思路实现即可.

## 欢迎Star ,欢迎加入我的Android酒馆 :425983695
# License

    Copyright 2016 androidwing1992

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
