# qa_guru_11_21_mobileTestsHW3
Мобильное тестирование Википедии

Инсталятор Википедии взят в открытом источнике: https://github.com/wikimedia/apps-android-wikipedia/releases/tag/latest

Установлен в BS: https://app-automate.browserstack.com/dashboard/v2/get-started#upload-app

/*  You have successfully uploaded your app. Note the "app_url" value below. It uniquely identifies your uploaded app on BrowserStack. */
{"app_url":"bs://dd10797b0964a39992c27c3229437d22307bd6c5"}
/* In your test script, use this "app_url" value to specify the application under test using the "app" capability. During test execution, your app will automatically be installed and launched on the device being tested. */
caps.setCapability("app", "bs://dd10797b0964a39992c27c3229437d22307bd6c5")


