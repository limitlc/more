package com.paxw.demolist.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.util.Log;

public class 通话记录 {

	public 通话记录(Context context) {
		Cursor cursor = context.getContentResolver().query(
				CallLog.Calls.CONTENT_URI, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				// CallsLog calls =new CallsLog();
				// 号码
				String number = cursor.getString(cursor
						.getColumnIndex(Calls.NUMBER));
				// 呼叫类型
				String type;
				switch (Integer.parseInt(cursor.getString(cursor
						.getColumnIndex(Calls.TYPE)))) {
				case Calls.INCOMING_TYPE:
					type = "呼入";
					break;
				case Calls.OUTGOING_TYPE:
					type = "呼出";
					break;
				case Calls.MISSED_TYPE:
					type = "未接";
					break;
				default:
					type = "挂断";// 应该是挂断.根据我手机类型判断出的
					break;
				}
				SimpleDateFormat sfd = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date = new Date(Long.parseLong(cursor.getString(cursor
						.getColumnIndexOrThrow(Calls.DATE))));
				// 呼叫时间
				String time = sfd.format(date);
				// 联系人
				String name = cursor.getString(cursor
						.getColumnIndexOrThrow(Calls.CACHED_NAME));
				// 通话时间,单位:s
				String duration = cursor.getString(cursor
						.getColumnIndexOrThrow(Calls.DURATION));
				Log.i("cursor", "number=" + number + "---type=" + type
						+ "----time=" + time + "----name=" + name);
			} while (cursor.moveToNext());

		}
	}
}
