# DragPhotoView [中文说明](https://github.com/githubwing/DragPhotoView/blob/master/README.md)


[![](https://jitpack.io/v/githubwing/DragPhotoView.svg)](https://jitpack.io/#githubwing/DragPhotoView)

A Draggable PhotoView Like Wechat，高仿微信可拖拽返回PhotoView


### Based on [PhotoView](https://github.com/chrisbanes/PhotoView)

##[DownLoad APK](https://github.com/githubwing/DragPhotoView/raw/master/app-debug.apk)

## Features
- Drag to scale image and finish activity


>- Out of the box zooming, using multi-touch and double-tap.
>- Scrolling, with smooth scrolling fling.
>- Works perfectly when used in a scrolling parent (such as ViewPager).
>- Allows the application to be notified when the displayed Matrix has changed. Useful for when you need to update your UI based on the >current zoom/scroll position.
>- Allows the application to be notified when the user taps on the Photo.

![image](https://github.com/githubwing/DragPhotoView/raw/master/img/img.gif)



# Usage

add this on you  `build.gradle`

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
then use DragPhotoView as a ImageView
```java


	// Any implementation of ImageView can be used!
	DragPhotoView photoView = (DragPhotoView)findViewById(R.id.photoView);
	photoView.setImageResource(R.drawable.ram);
	//must set a onExitListener, it will work when exit
	photoView.setOnExitListener()
	
	photoView.setOnTapListener()
```

## Tips
Let your Activity theme `translucent`

In `style.xml`
```xml
  <style name="translucent" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="android:windowBackground" >@android:color/transparent</item>
        <item name="android:windowIsTranslucent">true</item>
    </style>
```

Share transitions in all android version implementation in demo.

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
I