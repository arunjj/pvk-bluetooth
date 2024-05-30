import { NativeModules } from 'react-native';

// const LINKING_ERROR =
//   `The package 'react-native-pvk-testbluetooth-library' doesn't seem to be linked. Make sure: \n\n` +
//   Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
//   '- You rebuilt the app after installing the package\n' +
//   '- You are not using Expo Go\n';

const PvkTestbluetoothLibrary = NativeModules.PvkTestbluetoothLibrary
  ? NativeModules.PvkTestbluetoothLibrary
  : new Proxy(
      {},
      {
        get() {
          throw new Error();
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return PvkTestbluetoothLibrary.multiply(a, b);
}
