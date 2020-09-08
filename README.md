# AppiumParallelAutomationFramework
This repo contain appium framework using parallel technique for both android and ios in a single framework

## Appium Setup on MAC
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

