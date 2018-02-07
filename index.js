import React from 'react-native';

const CheckBatterySaveMode = React.NativeModules.CheckBatterySaveMode;

export default {
  isPowerSaveModeEnabled: (onSuccess, onFailure) => {
    return CheckBatterySaveMode.isPowerSaveModeEnabled(onSuccess, onFailure);
  }
};
