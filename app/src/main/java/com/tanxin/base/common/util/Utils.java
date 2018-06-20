package com.tanxin.base.common.util;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */
 
 
public class Utils   {
    /**
     * 获取进程号对应的进程名
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/proc/" + pid + "/cmdline");
            reader = new BufferedReader(fileReader);
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
