# Dots Loadings

## Description
This is an Android library made 100% in Kotlin, in which you will find many loadings (all made with DOTS), to let the user know that something is going on in the background!

## Download

To add this library in your project, add the following line in the `build.gradle` file of your project:

```
  repositories {
      maven { url 'https://jitpack.io' }
  }
```

And then add this line in the `build.gradle` file of your module:

`implementation 'com.github.geermank:dots-loading:0.2.0'`

## Loading types

| Circular | Orbits | Linear |
|----------|--------|--------|
|<img src="https://user-images.githubusercontent.com/58485943/130527543-425e689e-5849-4cb8-b110-68cb88785f1f.gif" width="260" height="480">|<img src="https://user-images.githubusercontent.com/58485943/130527598-414e3a28-e786-4286-893f-648e280c8b63.gif" width="260" height="480">|<img src="https://user-images.githubusercontent.com/58485943/130527767-4eea1af1-9fe6-4b32-894e-106f1a693515.gif" width="260" height="480">|
| Bounce | TikTok |
|<img src="https://user-images.githubusercontent.com/58485943/130527862-b408ffb0-354e-4f25-9140-fff2d3330674.gif" width="260" height="480">|<img src="https://user-images.githubusercontent.com/58485943/130527937-1cd35d8d-9c06-4ac4-932e-881f05f1322d.gif" width="260" height="480">|


## How to use it

You can add this loading in your xml file or programmatically.

### Adding this loading in your xml

You don't need to specify any attribute to use it, this view will just take default values if you don't:

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.geermank.dots.loading.view.DotLoading
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

The default values will create a circular loading view (go the next section to see how this looks) with 3 dots, painted with your primary color. 

You can customize your loading using the following attributes:

`numberOfDots`: the number of dots that the loading will have. Some loading types may override this value to set the number of dots that they need.

`loadingSize`: you have two options here, `small` or `large`. This attribute affects both the dots and the view containing them.

`dotsColor`: this is the primary color of your loading. The dots will be painted with it unless you specify a color array.

`dotsColorsArray`: this attribute lets you paint each dot with a different color. The order of the array is important since it is considered when we do the painting; this means that the first color will be used to paint the first dot, the second color will be used the paint the second dot, and so on. If you have more dots than colors, the rest of the dots will be painted with the color specified in the attribute `dotsColor`. If you don't set this color, the rest of the dots will be painted with your primary color

`loadingType`: the type of animation the dots will suffer. You can choose one of the following options:
1. circular
2. orbit
3. linear
4. bouncing
5. tik_tok

Go to the previous section to see how they look.

Here you have an example of all the attributes combined:

```
<com.geermank.dots.loading.view.DotLoading
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:loadingType="bouncing"
    app:loadingSize="small"
    app:numberOfDots="5"
    app:dotsColor="@android:color/holo_blue_dark"
    app:dotsColorsArray="@array/dot_multiple_colors"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"/>
```
