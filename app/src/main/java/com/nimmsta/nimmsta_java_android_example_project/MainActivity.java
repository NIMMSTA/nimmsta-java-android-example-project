package com.nimmsta.nimmsta_java_android_example_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.nimmsta.barcode.Barcode;
import com.nimmsta.core.android.framework.NIMMSTAServiceConnection;
import com.nimmsta.core.shared.device.NIMMSTADevice;
import com.nimmsta.core.shared.device.NIMMSTAEventHandler;
import com.nimmsta.core.shared.exception.bluetooth.BluetoothDisconnectedException;
import com.nimmsta.core.shared.layout.element.Button;
import com.nimmsta.core.shared.layout.event.ButtonClickEvent;
import com.nimmsta.core.shared.promise.NIMMSTADoneCallback;
import com.nimmsta.core.shared.promise.Task;
import com.nimmsta.core.shared.textprotocol.event.Event;
import com.nimmsta.core.shared.textprotocol.event.RequestShutdown;
import com.nimmsta.core.shared.textprotocol.event.ScanEvent;
import com.nimmsta.core.shared.textprotocol.event.TouchEvent;
import com.nimmsta.core.shared.textprotocolapi.softwareupdate.model.SoftwareUpdateProgress;

public class MainActivity extends AppCompatActivity implements NIMMSTAEventHandler {

    /* ... */
    NIMMSTAServiceConnection serviceConnection;
    /* ... */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceConnection = NIMMSTAServiceConnection.bindServiceToActivity(this)
                .onComplete(new NIMMSTADoneCallback<Task<NIMMSTAServiceConnection>>() {
                    @Override
                    public void onDone(Task<NIMMSTAServiceConnection> result) {
                        try {
                            // this is the point in time when the (background) task completes and the result throws if an error occurred.

                            result.getResult();

                            result.getResult().enableBackgroundAndNotifications();

                            if (!serviceConnection.getHasActiveConnections()) {
                                serviceConnection.displayConnectionActivity();
                            }

                        } catch (Throwable throwable) {
                            throwable.printStackTrace();

                            Toast.makeText(
                                    MainActivity.this,
                                    throwable.getMessage(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        serviceConnection.close();
    }

    @Override
    public boolean allowShutdownByUser(@NonNull NIMMSTADevice nimmstaDevice, @NonNull RequestShutdown requestShutdown) {
        return false;
    }

    @Override
    public void batteryLevelChanged(@NonNull NIMMSTADevice nimmstaDevice, int i) {

    }

    @Override
    public boolean deviceShouldHandover(@NonNull NIMMSTADevice nimmstaDevice) {
        return false;
    }

    @Override
    public boolean deviceWillShutdown(@NonNull NIMMSTADevice nimmstaDevice, boolean b) {
        return false;
    }

    @Override
    public void didClickButton(@NonNull NIMMSTADevice nimmstaDevice, @Nullable Button button, @NonNull ButtonClickEvent buttonClickEvent) {

    }

    @Override
    public void didConnectAndInit(@NonNull NIMMSTADevice nimmstaDevice) {
        // this is the point in time when you can start interacting with your device.
    }

    @Override
    public void didDisconnect(@NonNull NIMMSTADevice nimmstaDevice, @NonNull BluetoothDisconnectedException.Reason reason) {

    }

    @Override
    public void didReceiveEvent(@NonNull NIMMSTADevice nimmstaDevice, @NonNull Event event) {

    }

    @Override
    public void didScanBarcode(@NonNull NIMMSTADevice nimmstaDevice, @NonNull Barcode barcode, @NonNull ScanEvent scanEvent) {

    }

    @Override
    public void didStartCharging(@NonNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStartConnecting(@NonNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStartReconnectSearch(@NonNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStopCharging(@NonNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didStopReconnectSearch(@NonNull NIMMSTADevice nimmstaDevice) {

    }

    @Override
    public void didTouch(@NonNull NIMMSTADevice nimmstaDevice, double v, double v1, int i, @NonNull TouchEvent touchEvent) {

    }

    @Override
    public boolean onError(@Nullable NIMMSTADevice nimmstaDevice, @NonNull Throwable throwable) {
        return false;
    }

    @Override
    public void softwareUpdateProgress(@NonNull NIMMSTADevice nimmstaDevice, @NonNull SoftwareUpdateProgress softwareUpdateProgress) {

    }

    @Override
    public void softwareUpgradeProgress(@NonNull NIMMSTADevice nimmstaDevice, @NonNull SoftwareUpdateProgress softwareUpdateProgress) {

    }
}
