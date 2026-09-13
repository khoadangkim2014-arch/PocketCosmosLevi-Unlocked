<div align="center">

![LeviLauncher Logo](https://avatars.githubusercontent.com/u/78095377?s=200&v=4)

# PocketCosmosLevi Unlocked

**Next-Gen Custom Launcher & Asset Engine for Minecraft: Bedrock Edition**

[![GitHub Release](https://img.shields.io/github/v/release/khoadangkim2014-arch/PocketCosmosLevi-Unlocked?style=flat-square&color=blue)](https://github.com/khoadangkim2014-arch/PocketCosmosLevi-Unlocked/releases)
[![License: Apache 2.0](https://img.shields.io/github/license/khoadangkim2014-arch/PocketCosmosLevi-Unlocked?style=flat-square)](LICENSE)
[![Issues](https://img.shields.io/github/issues/khoadangkim2014-arch/PocketCosmosLevi-Unlocked?style=flat-square&color=red)](https://github.com/khoadangkim2014-arch/PocketCosmosLevi-Unlocked/issues)
[![Stars](https://img.shields.io/github/stars/khoadangkim2014-arch/PocketCosmosLevi-Unlocked?style=flat-square&color=yellow)](https://github.com/khoadangkim2014-arch/PocketCosmosLevi-Unlocked)
[![Android](https://img.shields.io/badge/Android-9.0%2B-green?style=flat-square&logo=android)](https://www.android.com/)

---

</div>

## 📌 Overview

**PocketCosmosLevi Unlocked** is a lightweight, optimized modification of LeviLauncher for Minecraft: Bedrock Edition (MCBE) on Android. Built for performance and customizability, this edition removes store validation barriers while unlocking custom capes, skins, and advanced runtime modules.

---

## ✨ Features

* 🔓 **Capes & Persona Unlocked**: Built-in access to custom capes (Minecon, BionicBen, DL0ZE, NAC, Sability, Stars, Wizardry, and more).
* ⚡ **Bypass Store Verification**: Direct startup execution without requiring Google Play Store checks.
* 📦 **Direct APK Import**: Run Minecraft directly from standalone APKs without system installation.
* 🧩 **Native Module Support**: Dynamic loading of native `.so` modules for custom enhancements and tweaks.
* 📁 **Isolated Version Management**: Separate data environments for different game versions, resource packs, and worlds.

---

## 📲 Installation

1. Grab the latest APK from the **[Releases](https://github.com/khoadangkim2014-arch/PocketCosmosLevi-Unlocked/releases)** page.
2. Enable **"Install from Unknown Sources"** in your device settings.
3. Install the APK and launch **PocketCosmosLevi**.

---

## 🛠️ Build from Source

### Prerequisites
* **JDK**: 21+
* **Android SDK**: API 28+ (Build-Tools 35.0.0)
* **NDK**: r28c
* **Xmake**: 2.9.9

### Compilation Steps

```bash
# Clone the repo with submodules
git clone --recursive [https://github.com/khoadangkim2014-arch/PocketCosmosLevi-Unlocked.git](https://github.com/khoadangkim2014-arch/PocketCosmosLevi-Unlocked.git)
cd PocketCosmosLevi-Unlocked

# Grant execution rights
chmod +x ./gradlew

# Build release APK
./gradlew assembleRelease
