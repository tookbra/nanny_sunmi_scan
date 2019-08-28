import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:nanny_sunmi_scan/nanny_sunmi_scan.dart';

void main() {
  const MethodChannel channel = MethodChannel('nanny_sunmi_scan');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

}
