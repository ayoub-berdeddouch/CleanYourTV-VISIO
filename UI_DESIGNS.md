# VISIO TV - Complete Project Log & UI Design Catalog

**Device**: VISIO Smart TV (Board: Skyworth shinagawa / MediaTek MT7668 dual-band, Android 11)  
**Location**: Benguerir, Morocco (بن جرير)  
**Date**: October 22, 2026  
**Status**: Successfully debloated, custom CleanTV launcher deployed, tested, and running live.

---

## 1. Executive Summary of Work Done

Today we completed a full overhaul of the VISIO TV interface, prioritizing speed, clean aesthetics, local relevance, and family usability:

1. **TV Safety & Full Debloating**:
   - Backed up all stock TV packages, settings, and props to `backup/`.
   - Disabled vendor bloatware, pre-installed telemetry, and unwanted services via non-destructive user disable commands (`pm disable-user --user 0`).
   - Retained core TV services, HDMI input switches, remote pairing, and Play Services.

2. **Custom CleanTV Launcher Architecture**:
   - Installed and set `com.gathin.tvhome` as the default TV Home activity.
   - Preserved Top Bar actions: **`🔌 Sources`** (HDMI/TV Inputs), **`📶 Wi-Fi`**, and **`⚙️ Paramètres`**.
   - Stacked the header date (`JEUDI 22 OCTOBRE`) directly **below the digital time** (`22:37`).
   - Built a balanced 3-panel middle shelf:
     - **Football Actualités & Highlights**: Live news, match results, and upcoming fixtures for **FC Barcelona** and the **Morocco National Team (Lions de l'Atlas)** with custom vector crests.
     - **TV System Hardware Monitor**: Live background hardware reader displaying CPU activity, RAM consumption (`Mémoire 664 / 907 Mo`), flash storage (`Stockage 1,6 GB libre`), and status (`● 60 FPS`).
     - **Right Widget Stack**: Real-time Weather (`☀️ 24°C Benguerir (بن جرير)`) positioned on top, with the official **Spotify Music Player Pill** directly below it with media playback controls.
   - Built custom squircle, vivid app banners for key apps (**Stremio**, **YouTube**, **Spotify**, **Forja**, **Prayer Times**, etc.) with dynamic ambient backlighting that glows in the focused app's accent color.
   - Kept the release build strictly compliant with the hard APK size gate (**490,999 B** vs limit of **491,520 B**).

3. **Dual-Mode Experience (Ambient Lock Screen)**:
   - Configured an ambient idle display that activates when the TV is idle.
   - Includes a real-time golden 5-prayer timeline for Benguerir (Fajr, Dhuhr, Asr, Maghrib, Isha) and daily Arabic Adkar (*"سُبْحَانَ اللَّهِ وَبِحَمْدِهِ ، سُبْحَانَ اللَّهِ الْعَظِيمِ"*).

4. **Wi-Fi 5 GHz Technical Diagnosis & Solution**:
   - Diagnosed why the TV was not detecting 5 GHz Wi-Fi from the home Huawei router (`192.168.100.1`).
   - Identified Moroccan regulatory domain restrictions (`mDriverCountryCode: MA`) requiring 5 GHz channels to be on Band 1 (36–48) rather than auto-assigned DFS channels.
   - Provided the exact 1-minute router configuration fix.

5. **Tooling & Local Previews**:
   - Created an interactive browser mockup in [launcher_preview.html](file:///c:/Users/Dell/Desktop/CleanTV/launcher_preview.html).
   - Created the dedicated **Minimalist 3D Zen Room (Option 2)** interactive preview in [preview_3d_room.html](file:///c:/Users/Dell/Desktop/CleanTV/preview_3d_room.html).
   - Documented all visual revisions and screenshot captures.

---

## 2. Interactive Previews Catalog

- **[launcher_preview.html](file:///c:/Users/Dell/Desktop/CleanTV/launcher_preview.html)**: Classic CleanTV Home & Ambient Lockscreen with Moroccan Adkar.
- **[preview_3d_room.html](file:///c:/Users/Dell/Desktop/CleanTV/preview_3d_room.html)**: Minimalist 3D Zen Room (Option 2) with real-time lighting (Day/Sunset/Night), interactive furniture hotspots, plant sway, and seamless D-pad switching.
  - **Preserved Authentic App Logos & Colors**: Deep purple gradient for **Stremio**, bright crimson for **YouTube**, distinctive pink wordmark for **Forja**, rich sapphire blue for **Fichiers**, and emerald/gold for **Prières**.
  - **Long-Press to Move (Maintenir OK)**: Hold `OK` (or click & hold) to enter reorder mode with arrows and smooth position swapping.
  - **Customizable First Row (Dock)**: Modal to add/remove apps (Spotify, Netflix, etc.) and save layout.

---

## 2. Screenshot History & Evolution

| Iteration | Description | File Path |
| :--- | :--- | :--- |
| **v0: Stock TV** | Original bloated interface before CleanTV | `shots/00-before.png` |
| **v1: Minimal Dock** | Initial debloated layout with stock icons | `shots/09-final-tv.png` |
| **v2: Vivid Logos** | Custom app squircle banners & ambient glow | `shots/11-visual-tv.png` |
| **v3: Layout Evolution** | Vertical stacked date, Barcelona & Morocco cards | `shots/12-final-layout.png` |
| **v4: Final Layout** | Highlights + System Panel + Weather/Spotify Right Stack | `shots/13-perfect-layout.png` |
| **v5: Clean Zen & 3D Room** | Clutter eliminated, minimalist home + dedicated 3D room addon (`com.cleantv.salon3d`) | `shots/14-clean-home.png` |

---

## 3. Latest Live TV Capture

![Live TV Final Layout](shots/13-perfect-layout.png)

---

## 4. Technical Reference: Wi-Fi 5 GHz Fix

If 5 GHz Wi-Fi disconnects or disappears in the future:
1. Go to router admin: `http://192.168.100.1`
2. Under **WLAN / Wi-Fi 5 GHz Settings**:
   - Channel: Set to fixed **36**, **40**, **44**, or **48** (Never leave on Auto).
   - Bandwidth: **20/40/80 MHz**.
3. Save settings. The TV will pick up the 5 GHz signal immediately.

---

*All changes are archived, tested, and running live on the TV.*
