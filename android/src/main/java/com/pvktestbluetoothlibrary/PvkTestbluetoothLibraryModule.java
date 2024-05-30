package com.pvktestbluetoothlibrary;

import android.os.Environment;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.example.tscdll.TSCActivity;

import java.io.File;

@ReactModule(name = PvkTestbluetoothLibraryModule.NAME)
public class PvkTestbluetoothLibraryModule extends ReactContextBaseJavaModule {
  public static final String NAME = "PvkTestbluetoothLibrary";
  private final ReactApplicationContext reactContext;

  private TSCActivity bt_api;

  private final int paper_width = 100;
  private final int paper_height = 150;
  private final int speed = 4;
  private final int density = 15;
  private final int sensor = 0;
  private final int sensor_distance = 0;
  private final int sensor_offset = 0;
  public PvkTestbluetoothLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    // this.file = new File(Environment.getExternalStorageDirectory().getPath() + "/Download/" + PDFName);
  }

  @Override
  public void initialize() {
    super.initialize();
     bt_api = new TSCActivity();
    // wifi_api = new TscWifiActivity();
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void sayHello(Promise promise) {
    promise.resolve("Bluetooth Printer Library");
  }

  @ReactMethod
  public void TSCPrintLabel(String pathname,Promise promise) {
    File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Download/" + "dummy.pdf");

     bt_api.openport("00:80:A3:6D:10:EC");
     String printer_status = bt_api.status();
    promise.resolve("Hello Printer");
     bt_api.setup(paper_width, paper_height, speed, density, sensor, sensor_distance, sensor_offset);
    // bt_api.sendcommand("SIZE 99 mm, 149 mm\r\n");
    // bt_api.sendcommand("GAP 99 mm, 149 mm\r\n"); // Gap media
     bt_api.clearbuffer();
    // bt_api.sendcommand("SPEED 4\r\n");
    // bt_api.sendcommand("DENSITY 12\r\n");
    // bt_api.sendcommand("CODEPAGE UTF-8\r\n");
    // bt_api.sendcommand("SET TEAR ON\r\n");
    // bt_api.sendcommand("SET COUNTER @1 1\r\n");
    // bt_api.sendcommand("@1 = \"0001\"\r\n");
    // bt_api.sendcommand("TEXT 100,300,\"ROMAN.TTF\",0,12,12,@1\r\n");
    // bt_api.sendcommand("TEXT 100,100,\"ROMAN.TTF\",0,12,12,\"KRISHNA \"\r\n\n\n");
//     bt_api.barcode(100, 100, "128", 100, 1, 0, 3, 3, "123456789");
     bt_api.printPDFbyFile(file, 0, 0, 140);

//     bt_api.printlabel(1, 1);
     bt_api.closeport(5000);

    // Toast.makeText(getReactApplicationContext(), "Test", 2000).show();
    // Toast.makeText(reactContext, printer_status, Toast.LENGTH_SHORT).show();
  }
}
