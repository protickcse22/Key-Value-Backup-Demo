package com.example.keyvaluebackupdemo;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BackupController extends BackupAgentHelper {
    private static final String PREFS_BACKUP_KEY = "prefs";
    public static final String PREF_USER_EMAIL_BACKUP = "com.example.keyvaluebackupdemo.PREF_USER_NAME";

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this,PREF_USER_EMAIL_BACKUP);
        addHelper(PREFS_BACKUP_KEY,helper);
    }

    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) throws IOException {
        super.onBackup(oldState, data, newState);
        Log.d("PROTICK","on backup called");
    }

    /*@Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        PrefUtils.setBackUpEmail(this,"Hello world");
        super.onRestore(data, appVersionCode, newState);
        Log.d("PROTICK","on restore called");
    }*/

    /*@Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) throws IOException {
        Log.d("PROTICK","onBackup() called");
        // Create buffer stream and data output stream for our data
        String email = PrefUtils.getEmail(this);
        ByteArrayOutputStream bufStream = new ByteArrayOutputStream();
        DataOutputStream outWriter = new DataOutputStream(bufStream);
// Write structured data
        outWriter.writeUTF(email);
// Send the data to the Backup Manager via the BackupDataOutput
        byte[] buffer = bufStream.toByteArray();
        int len = buffer.length;
        data.writeEntityHeader(PREFS_BACKUP_KEY, len);
        data.writeEntityData(buffer, len);
        super.onBackup(oldState, data, newState);
    } */

    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        Log.d("PROTICK","onRestore() called");
        super.onRestore(data, appVersionCode, newState);


    }
}
