package com.jiangyy.android.dev.anko

import android.accounts.AccountManager
import android.app.*
import android.app.admin.DevicePolicyManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.hardware.ConsumerIrManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.location.LocationManager
import android.media.AudioManager
import android.net.ConnectivityManager
import android.nfc.NfcManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager

/** Returns the AccessibilityManager instance. **/
val Context.accessibilityManager: AccessibilityManager
    get() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager


/** Returns the AccountManager instance. **/
val Context.accountManager: AccountManager
    get() = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager


/** Returns the ActivityManager instance. **/
val Context.activityManager: ActivityManager
    get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager


/** Returns the AlarmManager instance. **/
val Context.alarmManager: AlarmManager
    get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager


/** Returns the AppOpsManager instance. **/
val Context.appOpsManager: AppOpsManager
    get() = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager


/** Returns the AudioManager instance. **/
val Context.audioManager: AudioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager


/** Returns the BluetoothManager instance. **/
val Context.bluetoothManager: BluetoothManager
    get() = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager


/** Returns the CaptioningManager instance. **/
val Context.captioningManager: CaptioningManager
    get() = getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager


/** Returns the ClipboardManager instance. **/
val Context.clipboardManager: ClipboardManager
    get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


/** Returns the ConnectivityManager instance. **/
val Context.connectivityManager: ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


/** Returns the ConsumerIrManager instance. **/
val Context.consumerIrManager: ConsumerIrManager
    get() = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager


/** Returns the DevicePolicyManager instance. **/
val Context.devicePolicyManager: DevicePolicyManager
    get() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager


/** Returns the DisplayManager instance. **/
val Context.displayManager: DisplayManager
    get() = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager


/** Returns the DownloadManager instance. **/
val Context.downloadManager: DownloadManager
    get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager


/** Returns the InputManager instance. **/
val Context.inputManager: InputManager
    get() = getSystemService(Context.INPUT_SERVICE) as InputManager


/** Returns the InputMethodManager instance. **/
val Context.inputMethodManager: InputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


/** Returns the KeyguardManager instance. **/
val Context.keyguardManager: KeyguardManager
    get() = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager


/** Returns the LocationManager instance. **/
val Context.locationManager: LocationManager
    get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager


/** Returns the NfcManager instance. **/
val Context.nfcManager: NfcManager
    get() = getSystemService(Context.NFC_SERVICE) as NfcManager


/** Returns the NotificationManager instance. **/
val Context.notificationManager: NotificationManager
    get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

