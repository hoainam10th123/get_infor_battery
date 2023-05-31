import {NativeModules} from 'react-native';

const {BatteryModule} = NativeModules;

interface BatteryInterface {
    getBatteryEvent(callBack: Function): void
}

export default BatteryModule as BatteryInterface;