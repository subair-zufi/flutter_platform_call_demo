import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Method Call"),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: ()=>callNativeMethod(),
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }

  callNativeMethod()async {
    const platform = MethodChannel('com.example.method_call/app_channel');
    try {
      await platform.invokeMethod('openAndroid');
    } on PlatformException catch (e) {
      print("Failed to call native method: ${e.message}");
    }
  }
}
