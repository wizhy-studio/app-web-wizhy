# Wizhy Web Studio - Android App Project

A modern, native Android application for **Wizhy Web Studio (WWS)** (`https://web.wizhy.in/`), built with **Kotlin** and **Jetpack Compose**.

---

## 📱 App Highlights & Features

1. **Brand Identity**: Wizhy's iconic colors (`#C8481E` Terracotta Orange, Warm Off-White, Dark Charcoal).
2. **Hero Section**:
   - 🎁 Studio Launch Banner: *First 10 businesses get a 100% Free Website*
   - Headline: *"Websites crafted to look stunning—built to rank & grow"*
   - Interactive Google Lighthouse 100/100 Benchmark Matrix (Performance, Accessibility, Best Practices, SEO)
3. **Core Services (All 12)**:
   - Website Development, WordPress & CMS, E-Commerce, SEO & Google Ranking, UI/UX, Web Apps, Hosting, Branding, CRO, Motion Video, Logo Generation, and Meta/Google Ads.
4. **Interactive Pricing with Live Currency Switcher**:
   - Switch between **INR (₹)** and **USD ($)** in real-time.
   - Plans: Free Slot, Starter Website (₹999 / $29), Full Business Website (₹4,999 / $129), and Online Store (₹9,999 / $249).
   - Quick Add-ons: Logo Generation (₹99), Motion Video (₹499), Ads Setup (₹1,499).
5. **Instant SEO & Speed Audit Tool**:
   - Enter any business website domain to run a simulated on-page and technical performance check.
6. **Direct 1-Tap Connect**:
   - Instant WhatsApp integration with pre-filled quote requests to `+91-98707-06956`.
   - Direct phone dialer and email compose buttons.
7. **FAQ Accordion**:
   - Expandable answers to client questions regarding timelines, costs, SEO, and maintenance.

---

## 🛠️ How to Open & Run the App

You **do not need any manual configuration** — everything is pre-configured with Gradle Version Catalogs and Kotlin 2.0 Compose.

### Step 1: Open in Android Studio
1. Open **Android Studio**.
2. Click **File** $\rightarrow$ **Open...**
3. Select this folder:  
   `c:\My Files\Websites\1. AG\Wizhy\4. Web Wizhy App`
4. Wait for Gradle sync to complete (it will automatically download dependencies).

### Step 2: Run the App
- **On an Android Phone**:
  1. Enable **Developer Options** and **USB Debugging** on your phone.
  2. Connect your phone to your computer via USB.
  3. Select your phone from the device dropdown at the top toolbar in Android Studio.
  4. Click the green **Run (▶)** button.
- **On an Emulator**:
  1. Open **Device Manager** in Android Studio.
  2. Create an Android Virtual Device (e.g., Pixel 8 with API 34/35).
  3. Click **Run (▶)**.

---

## 📦 How to Build the APK & Publish to Google Play

### 1. Build a Debug APK (Instant testing on your phone)
In Android Studio:
- Go to the top menu: **Build** $\rightarrow$ **Build Bundle(s) / APK(s)** $\rightarrow$ **Build APK(s)**.
- Once finished, click **locate** in the notification balloon to get `app-debug.apk`. Transfer this APK file to your phone and install it directly!

### 2. Generate a Release APK / AAB for Google Play Store
Google Play requires an `.aab` (Android App Bundle) signed with your private key:
1. In Android Studio, go to **Build** $\rightarrow$ **Generate Signed Bundle / APK...**
2. Choose **Android App Bundle** and click **Next**.
3. Under **Key store path**, click **Create new...** to create your digital release key (save your password and keystore file safely).
4. Select build variant: **release**.
5. Click **Finish**. Android Studio generates your production bundle (`.aab`).
6. Upload the `.aab` to your **Google Play Console** account (`play.google.com/console`) under your new app listing!
