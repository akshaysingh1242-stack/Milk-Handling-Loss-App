Milk Handling Loss App — Android source v0.2.5

Features in source:
- Offline local SQLite records
- Separate sent-to-union and received-from-society entries
- Sent milk Fat KG / SNF KG calculated automatically
- Received milk Fat KG / SNF KG entered manually
- Monthly opening and closing balances
- View, edit, and delete saved entries
- Date-range summary, PDF and XLSX export source code
- Root number, report date, and center name settings
- Strict date validation (rejects impossible dates such as 2026-02-31)

जाँच की स्थिति (इस वातावरण में):
- Calc.java के गणना टेस्ट पास: Fat KG, SNF KG, भारित प्रतिशत, शून्य दूध guard और उपयोगकर्ता द्वारा तय हस्तगत क्षति सूत्र (6−3)।
- Source ZIP की integrity जाँच पास।
- पूरा Android APK build नहीं हो सका: Android SDK/Gradle मौजूद नहीं हैं और Gradle डाउनलोड के लिए DNS/इंटरनेट उपलब्ध नहीं है।
- Android फोन/एमुलेटर पर ऐप रनटाइम टेस्ट नहीं हुआ। XLSX को Excel/LibreOffice में खोलना और PDF में हिंदी अक्षर जाँचना अभी बाकी है।

Important:
This ZIP is source code, not an installable APK. Do not use it for official dairy reporting until the APK has been built and the PDF/XLSX and totals verified on an Android device.

Build using Android Studio:
1. Install Android Studio on a computer and install Android SDK Platform 35.
2. Extract this ZIP.
3. Android Studio > Open > choose the extracted MilkHandlingLossAndroid folder.
4. Allow Gradle sync to finish. If prompted, install the Android Gradle plugin / SDK components.
5. Select Build > Build Bundle(s) / APK(s) > Build APK(s).
6. Android Studio shows the generated APK path when the build succeeds.

Do not use this for official dairy reporting until you have verified sample totals and the PDF against your required report format.


Version 0.2.5 update: Monthly opening/closing balances are included only when the report covers the complete matching calendar month. Partial date-range reports (such as 7 or 15 days) explicitly exclude monthly balances to avoid misleading totals.

फोन से क्लाउड APK बनाने का विकल्प
-----------------------------------
इस प्रोजेक्ट में .github/workflows/build-apk.yml जोड़ा गया है। यदि इस प्रोजेक्ट की फाइलें GitHub repository में अपलोड हों, तो GitHub Actions Android SDK और Gradle के साथ debug APK बनाने की कोशिश करेगा।

ध्यान दें: यह workflow खुद से APK तैयार होने की गारंटी नहीं देता। Build सफल होने पर GitHub repository में Actions > सफल run > Artifacts से APK डाउनलोड करें। यदि build fail हो, तो उसी run का log देखकर कोड/निर्भरता की त्रुटि ठीक करनी होगी।
किसी अनजान वेबसाइट पर GitHub password या personal access token साझा न करें।
