import 'dart:async';

import 'package:flutter/services.dart';

class NannySunmiScan {
  static const NAMESPACE = 'plugins.iot.wash.com/nanny_scan';
  final MethodChannel _channel = const MethodChannel('$NAMESPACE/methods');
  final StreamController<MethodCall> _methodStreamController = new StreamController.broadcast();

  NannySunmiScan._() {
    _channel.setMethodCallHandler((MethodCall call) {
      _methodStreamController.add(call);
    });
  }
  static NannySunmiScan _instance = new NannySunmiScan._();
  static NannySunmiScan get instance => _instance;

  Future<void> openScanner() async {
    await _channel.invokeMethod("openScanner");
  }

  Future<void> openScannerWithOptions() async {
    await _channel.invokeMethod("openScannerWithOptions");
  }
}
