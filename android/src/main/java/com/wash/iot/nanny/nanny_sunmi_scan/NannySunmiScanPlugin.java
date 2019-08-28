package com.wash.iot.nanny.nanny_sunmi_scan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** NannySunmiScanPlugin */
public class NannySunmiScanPlugin implements MethodCallHandler {

  private static final String TAG = "FlutterPrintPlugin";
  private static final String NAMESPACE = "plugins.iot.wash.com/nanny_scan";
  private final Registrar registrar;
  private final MethodChannel channel;
  private Context context;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final NannySunmiScanPlugin instance = new NannySunmiScanPlugin(registrar);
  }

  NannySunmiScanPlugin(Registrar r) {
    this.registrar = r;
    this.channel = new MethodChannel(registrar.messenger(), NAMESPACE+"/methods");
    channel.setMethodCallHandler(this);
    this.context = r.context();
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method) {
      case "openScanner":
        openScanner();
        break;
      case "openScannerWithOptions":
        openScanner();
        break;
      default:
        result.notImplemented();
        break;
    }
  }

  private void openScanner() {
    openScannerWithOptions();
  }

  private void openScannerWithOptions() {
    Activity currentActivity = this.registrar.activity();
    final Intent intent = new Intent("com.summi.scan");
    intent.setPackage("com.sunmi.sunmiqrcodescanner");
    intent.putExtra("IS_SHOW_SETTING", false);
    intent.putExtra("IS_SHOW_ALBUM", false);

/**
 //扫码模块有一些功能选项，开发者可以通过传递参数控制这些参数，
 //所有参数都有一个默认值，开发者只要在需要的时候添加这些配置就可以。
 intent.putExtra("CURRENT_PPI", 0X0003);//当前分辨率
 //M1和V1的最佳是800*480,PPI_1920_1080 = 0X0001;PPI_1280_720 =
 //0X0002;PPI_BEST = 0X0003;
 intent.putExtra("PLAY_SOUND", true);// 扫描完成声音提示  默认true
 intent.putExtra("PLAY_VIBRATE", false);
 //扫描完成震动,默认false，目前M1硬件支持震动可用该配置，V1不支持
 intent.putExtra("IDENTIFY_INVERSE_QR_CODE", true);// 识别反色二维码，默认true
 intent.putExtra("IDENTIFY_MORE_CODE", false);// 识别画面中多个二维码，默认false
 intent.putExtra("IS_SHOW_SETTING", true);// 是否显示右上角设置按钮，默认true
 intent.putExtra("IS_SHOW_ALBUM", true);// 是否显示从相册选择图片按钮，默认true
 **/

    currentActivity.startActivityForResult(intent, 2345);
  }
}
