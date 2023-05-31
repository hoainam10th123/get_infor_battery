/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useState } from 'react';

import {
  Button,
  SafeAreaView,
  Text,
  View,
} from 'react-native';

import BatteryModule from './batterModule';


function App(): JSX.Element {
  const [pin, setPin] = useState(0)

  const showInforPin = (error: any, value: number) => {
    if (error) return console.error(error)
    console.log(value)
    setPin(value)
  }

  return (
    <SafeAreaView >
      <View style={{marginTop:100}}>
        <Button onPress={()=>BatteryModule.getBatteryEvent(showInforPin)} title='Get battery'/>
        <Text style={{fontSize:30, color:'#257098', textAlign:'center'}}>{pin}</Text>
      </View>
    </SafeAreaView>
  );
}

export default App;
