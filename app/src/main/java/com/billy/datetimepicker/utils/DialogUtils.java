package com.billy.datetimepicker.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.billy.datetimepicker.R;


/**
 * Created by Billy_Cui on 2018/5/31
 * Describe:  弹窗工具类
 */

public class DialogUtils {

    public interface DialogClick {
        void update(String time);
    }

    /**
     * 时间选择器 弹窗
     * @param inflater
     * @param dialogClick  确定后,获取时间回调
     */
    public static void showDateTimePicker(LayoutInflater inflater, final DialogClick dialogClick){

        View view = inflater.inflate(R.layout.widget_date_time_picker, null);
        final DatePicker datePicker = view.findViewById(R.id.datePicker1);
        final TimePicker timePicker = view.findViewById(R.id.timePicker1);
        AlertDialog dialog = new AlertDialog.Builder(inflater.getContext())
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        sb.append(String.format("%02d:%02d",
                                timePicker.getCurrentHour(),
                                timePicker.getCurrentMinute())
                                );
                        dialogClick.update(sb.toString());
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
        //适配选择器大小
        DatePickerUtils.resizePikcer(datePicker);
        DatePickerUtils.resizePikcer(timePicker);
        //24小时制
        timePicker.setIs24HourView(true);
    }
}
