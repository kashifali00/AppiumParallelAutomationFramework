# AppiumParallelAutomationFramework
This repo contain appium framework using parallel technique for both android and ios in a single framework
## Appium Setup on MAC for Android
1. install homebrew ( package manager for macOS and is used to install software packages
2. Install appium ( either through npm or appium desktop)
NPM:
`npm install - g appium`
3. install maven 
`brew install maven`
4. install java jkd8
5. install appium-doctor to verify the setup for android
`npm install appium-doctor`
6. install android studio
7. set the following environment variable in `.bash_profile`
```export JAVA_HOME=$(/usr/libexec/java_home)
   export ANDROID_HOME=${HOME}/Library/Android/sdk
   export PATH="${JAVA_HOME}/bin:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${PATH}"
```
8. verify that all setup is working fine
`appium-doctor --android`

if you see the following output then all good to go!

```
appium-doctor --android
info AppiumDoctor Appium Doctor v.1.15.3
info AppiumDoctor ### Diagnostic for necessary dependencies starting ###
info AppiumDoctor  ✔ The Node.js binary was found at: /usr/local/bin/node
info AppiumDoctor  ✔ Node version is 10.16.3
info AppiumDoctor  ✔ ANDROID_HOME is set to: /Users/iosteam/Library/Android/sdk
info AppiumDoctor  ✔ JAVA_HOME is set to: /Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home
info AppiumDoctor    Checking adb, android, emulator
info AppiumDoctor      'adb' is in /Users/iosteam/Library/Android/sdk/platform-tools/adb
info AppiumDoctor      'android' is in /Users/iosteam/Library/Android/sdk/tools/android
info AppiumDoctor      'emulator' is in /Users/iosteam/Library/Android/sdk/emulator/emulator
info AppiumDoctor  ✔ adb, android, emulator exist: /Users/iosteam/Library/Android/sdk
info AppiumDoctor  ✔ Bin directory of $JAVA_HOME is set
info AppiumDoctor ### Diagnostic for necessary dependencies completed, no fix needed. ###
info AppiumDoctor 
info AppiumDoctor ### Diagnostic for optional dependencies starting ###
WARN AppiumDoctor  ✖ opencv4nodejs cannot be found.
WARN AppiumDoctor  ✖ ffmpeg cannot be found
WARN AppiumDoctor  ✖ mjpeg-consumer cannot be found.
WARN AppiumDoctor  ✖ bundletool.jar cannot be found
WARN AppiumDoctor  ✖ gst-launch-1.0 and/or gst-inspect-1.0 cannot be found
info AppiumDoctor ### Diagnostic for optional dependencies completed, 5 fixes possible. ###
info AppiumDoctor 
info AppiumDoctor ### Optional Manual Fixes ###
info AppiumDoctor The configuration can install optionally. Please do the following manually:
WARN AppiumDoctor  ➜ Why opencv4nodejs is needed and how to install it: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/image-comparison.md
WARN AppiumDoctor  ➜ ffmpeg is needed to record screen features. Please read https://www.ffmpeg.org/ to install it
WARN AppiumDoctor  ➜ mjpeg-consumer module is required to use MJPEG-over-HTTP features. Please install it with 'npm i -g mjpeg-consumer'.
WARN AppiumDoctor  ➜ bundletool.jar is used to handle Android App Bundle. Please read http://appium.io/docs/en/writing-running-appium/android/android-appbundle/ to install it
WARN AppiumDoctor  ➜ gst-launch-1.0 and gst-inspect-1.0 are used to stream the screen of the device under test. Please read https://appium.io/docs/en/writing-running-appium/android/android-screen-streaming/ to install them and for more details
info AppiumDoctor 
info AppiumDoctor ###
info AppiumDoctor 
info AppiumDoctor Bye! Run appium-doctor again when all manual fixes have been applied!
```

## Appium Setup on MAC for IOS
1. install homebrew ( package manager for macOS and is used to install software packages
2. Install appium ( either through npm or appium desktop)
NPM:
npm install - g appium
To install node (brew install node) it will install both node & npm
3. install xcode (IDE)
Launch the appstore and search for xcode
AppleID is needed to complete this operations

4. Install xcode command line tools
xcode-select --install

5. Install the carthage (dependecy manager for webdriver agent)

brew install carthage

6. Appium doctor (appium utility to validate the appium setup)
npm install -g appium-doctor

7. Open xcode
8. create new project
9. create macOS emulator

type in terminal

xcodebuild - showsdks

10. now build the ios emulator 
    Go to project directory such as autoscoute
	cd Desktop/autoscoute
	in terminal hit enter
	xcodebuild -sdk iphonesimulator
	cope the complete app path from terminal and save it
11. From xcode lauch the emulator 

## Running Appium Test on Real IOS device

1. Open the webdriveragent project in xcode
2. Compile & build the webdriveragent project using unique team id, bundle id and provisioning profile
following files should be build
- Webdriveragentlib
- Webdriveragentrunner
- integrationApp

just make sure you have developer paid account and perform code signing and provisioning using automatic configuration process
Ask development team to invite your in IOS paid development program

Also, need to make sure your ios device udid is registered on ios development portal

After, setting up team, bundle identifier, build the webdriveragent project.
if the build is successful, IntegrationApp will be installed on your ios device

3. Open the appium desktop version on your mac and set the desired capibilities

for example 
```  
{
  "deviceName": "iPhone",
  "platformVersion": "13.7",
  "platformName": "iOS",
  "udid": "00008020-0002586A1E12002E",
  "app": "/Users/iosteam/Downloads/EasyPaisa_PRD.ipa",
  "bundleId": "com.telenor.easypaisa"
  }

```
if all go well then you should be seeing ios app in appium inspector.
and here you now can start coding...