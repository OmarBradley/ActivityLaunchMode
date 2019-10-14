# ActivityLaunchMode
 ActivityLaunchMode에 따른 Activity의 Task의 변화를 알기 위한 샘플 앱

# Activity 스택을 쉽게 확인 하는 법
1. Android Studio Terminal에 `adb shell` 을 쳐서 adb shell을 실행시킨다
2. adb shell 을 실행시키면, `dumpsys activity a | grep omarbradley.com.activitylaunchmode` 을 입력 후 엔터(밑에 있는 대로 결과가 나옴) 
```
    * TaskRecord{bfd3a10 #9586 A=omarbradley.com.activitylaunchmode U=0 StackId=60 sz=3}
      affinity=omarbradley.com.activitylaunchmode
      intent={act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10100000 cmp=omarbradley.com.activitylaunchmode/.MainActivity}
      realActivity=omarbradley.com.activitylaunchmode/.MainActivity
      Activities=[ActivityRecord{cd94859 u0 omarbradley.com.activitylaunchmode/.MainActivity t9586}, ActivityRecord{a7f789b u0 omarbradley.com.activitylaunchmode/.BActivity t9586}, ActivityRecord{8782c44 u0 omarbradley.com.activitylaunchmode/.CActivity t9586}]
      mRootProcess=ProcessRecord{5250a45d0 1245:omarbradley.com.activitylaunchmode/u0a457}
      * Hist #2: ActivityRecord{8782c44 u0 omarbradley.com.activitylaunchmode/.CActivity t9586}
          packageName=omarbradley.com.activitylaunchmode processName=omarbradley.com.activitylaunchmode
          launchedFromUid=10457 launchedFromPackage=omarbradley.com.activitylaunchmode userId=0
          app=ProcessRecord{5250a45d0 1245:omarbradley.com.activitylaunchmode/u0a457}
          Intent { cmp=omarbradley.com.activitylaunchmode/.CActivity }
          frontOfTask=false task=TaskRecord{bfd3a10 #9586 A=omarbradley.com.activitylaunchmode U=0 StackId=60 sz=3}
          taskAffinity=omarbradley.com.activitylaunchmode
          realActivity=omarbradley.com.activitylaunchmode/.CActivity
          baseDir=/data/app/omarbradley.com.activitylaunchmode-WcfmXQX1gHGqu1AdrWdf2w==/base.apk
          dataDir=/data/user/0/omarbradley.com.activitylaunchmode
      * Hist #1: ActivityRecord{a7f789b u0 omarbradley.com.activitylaunchmode/.BActivity t9586}
          packageName=omarbradley.com.activitylaunchmode processName=omarbradley.com.activitylaunchmode
          launchedFromUid=10457 launchedFromPackage=omarbradley.com.activitylaunchmode userId=0
          app=ProcessRecord{5250a45d0 1245:omarbradley.com.activitylaunchmode/u0a457}
          Intent { cmp=omarbradley.com.activitylaunchmode/.BActivity }
          frontOfTask=false task=TaskRecord{bfd3a10 #9586 A=omarbradley.com.activitylaunchmode U=0 StackId=60 sz=3}
          taskAffinity=omarbradley.com.activitylaunchmode
          realActivity=omarbradley.com.activitylaunchmode/.BActivity
          baseDir=/data/app/omarbradley.com.activitylaunchmode-WcfmXQX1gHGqu1AdrWdf2w==/base.apk
          dataDir=/data/user/0/omarbradley.com.activitylaunchmode
      * Hist #0: ActivityRecord{cd94859 u0 omarbradley.com.activitylaunchmode/.MainActivity t9586}
          packageName=omarbradley.com.activitylaunchmode processName=omarbradley.com.activitylaunchmode
          app=ProcessRecord{5250a45d0 1245:omarbradley.com.activitylaunchmode/u0a457}
          Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10100000 cmp=omarbradley.com.activitylaunchmode/.MainActivity }
          frontOfTask=true task=TaskRecord{bfd3a10 #9586 A=omarbradley.com.activitylaunchmode U=0 StackId=60 sz=3}
          taskAffinity=omarbradley.com.activitylaunchmode
          realActivity=omarbradley.com.activitylaunchmode/.MainActivity
          baseDir=/data/app/omarbradley.com.activitylaunchmode-WcfmXQX1gHGqu1AdrWdf2w==/base.apk
          dataDir=/data/user/0/omarbradley.com.activitylaunchmode
      TaskRecord{bfd3a10 #9586 A=omarbradley.com.activitylaunchmode U=0 StackId=60 sz=3}
        Run #2: ActivityRecord{8782c44 u0 omarbradley.com.activitylaunchmode/.CActivity t9586}
        Run #1: ActivityRecord{a7f789b u0 omarbradley.com.activitylaunchmode/.BActivity t9586}
        Run #0: ActivityRecord{cd94859 u0 omarbradley.com.activitylaunchmode/.MainActivity t9586}
    mResumedActivity: ActivityRecord{8782c44 u0 omarbradley.com.activitylaunchmode/.CActivity t9586}
    mLastPausedActivity: ActivityRecord{a7f789b u0 omarbradley.com.activitylaunchmode/.BActivity t9586}
  ResumedActivity: ActivityRecord{8782c44 u0 omarbradley.com.activitylaunchmode/.CActivity t9586}
```
  - `mResumedActivity` 은 가장 최근에 onResume() 을 호출한 Activity를 의미
  - `mLastPausedActivity` 은 가장 최근에 onPause() 를 호출한 Activity를 의미
  
3. 밑에 나온 예시 중에 TaskRecord 를 보면, Task에 있는 Activity를 순서대로 볼 수 있다
```
      TaskRecord{bfd3a10 #9586 A=omarbradley.com.activitylaunchmode U=0 StackId=60 sz=3}
        Run #2: ActivityRecord{8782c44 u0 omarbradley.com.activitylaunchmode/.CActivity t9586}
        Run #1: ActivityRecord{a7f789b u0 omarbradley.com.activitylaunchmode/.BActivity t9586}
        Run #0: ActivityRecord{cd94859 u0 omarbradley.com.activitylaunchmode/.MainActivity t9586}
```
  - `Run #0` 은 TaskRoot를 의미함

4. 앱 구조를 보면 단순히 3개의 Activity와 버튼으로만 구성되있음 
  - 해당 Activity에 android:launchMode를 지정하거나, 인텐트에 addFlag를 지정하면서 
  - `dumpsys activity a | grep omarbradley.com.activitylaunchmode` 를 adb shell에 typing하시면서 
  - 나오는 결과를 보시면 될 듯 하다!








