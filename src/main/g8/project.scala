//> using platform $if(targetJavaPlatform.truthy)$jvm $endif$$if(targetJavaScriptPlatform.truthy)$scala-js $endif$$if(targetNativePlatform.truthy)$ scala-native$endif$
$if(targetNativePlatform.truthy)$
//> using nativeMode release-full
$endif$
$if(githubActionsRunTests.truthy)$
//> using test.dep "org.scalameta::munit:0.7.29"
$endif$
