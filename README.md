## Animation
- res > anim 폴더에 정의하여 사용



> Translate
```xml
<translate
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXDelta="0"
    android:fromYDelta="0"
    android:toXDelta="100"
    android:toYDelta="100"
    android:duration="2000">
</translate>
```
- fromXDelta : 처음 애니메이션이 시작될때 View의 X 위치 (0은 원래 위치)
- fromYDelta : 처음 애니메이션이 시작될때 View의 Y 위치
- toXDelta : 끝날때 X위치
- toYDelta : 끝날때 Y위치
- duration : 지속 시간

> Scale
```xml
<scale
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXScale="1.0"
    android:fromYScale="1.0"
    android:toXScale="5.0"
    android:toYScale="5.0"
    android:pivotX="50%"
    android:pivotY="50%"
    android:fillAfter="true"
    android:duration="2000">
</scale>
```
- fromXScale : 처음의 가로 크기 (1.0은 원래 크기)
- fromYScale : 처음의 세로 크기
- toXScale : 끝의 가로 크기
- toYScale : 끝의 세로 크기
- pivotX : 크기를 변경할때의 중심점 (회전축의 X 좌표)
- pivotY: 크기를 변경할때의 중심점 (회전축의 Y 좌표)


> Rotate
```xml
<rotate
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromDegrees="0"
    android:toDegrees="1080"
    android:pivotX="50%"
    android:pivotY="50%"
    android:duration="2000">
</rotate>
```
- fromDegrees : 시작하는 회전 각도
- toDegrees : 끝나는 회전 각도
> 이때 단위는 정수, %, %p 사용가능
: 정수 - 절대좌표
: % - 애니메이션을 적용할 View를 기준으로 한 비율
: %p -  View를 감싸는 부모 View를 기준으로 한 비율

> Alpha
```xml
<alpha
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromAlpha="1.0"
    android:toAlpha="0.0"
    android:fillAfter="true"
    android:duration="2000">
</alpha>
```
- fromAlpha : 처음 투명도 값 (0.0/약 ~ 1.0/강)
- toAlpha : 끝날때 투명도 값
- fillAfter : 애니메이션이 끝난 뒤 상태를 유지할지
- repeatCount : 반복 횟수 (-1은 무한반복)
- startOffset : 애니메이션을 시작하기 전 대기시간
- :interpolator : 애니메이션 효과가 지속되는 동안 빠르게, 또는 느리게 효과가 진행되도록 (가속도)


> 적용
```java
@Override
    public void onClick(View view) {
        Animation animation = null;
        switch (view.getId()){
            case R.id.btnTrans :
            // 애니메이션 객체에 애니메이션을 적용
                animation = AnimationUtils.loadAnimation(this,R.anim.trans);
                break;
            case  R.id.btnRotate :
                animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
                break;
            case  R.id.btnScale :
                animation = AnimationUtils.loadAnimation(this,R.anim.scale);
                break;
            case R.id.btnAlpha :
                animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
                break;
            case R.id.imageView :
                Intent intent = new Intent(this, WindmillActivity.class);
                startActivity(intent);
        }
        if(animation != null)
        imageView.startAnimation(animation);
    }
```

#### ObjectAnimator
- 코드에서 애니메이션을 정의
```java
ObjectAnimator transY = ObjectAnimator.ofFloat(
                       button6,        // 움직일 대상
                       "translationY", // 애니메이션 속성
                       -500             // 속성 값
               );
// 애니메이터 셋을 구성해서 실행
AnimatorSet animatorSet = new AnimatorSet();
animatorSet.playTogether(transX,transY,rotate);   // 개수 제한 없음
animatorSet.setDuration(3000);             // 실행시간
animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());   // 가속도
animatorSet.start();
```
