package com.example.fmuschedulelabs.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fmuschedulelabs.data.model.Scheduled;

import java.util.ArrayList;
import java.util.List;

public class ScheduledDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "labs.db";
    private static final int DATABASE_VERSION = 1;

    public ScheduledDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE scheduled (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "endereco TEXT," +
                "andar TEXT," +
                "sala TEXT," +
                "data_disponivel TEXT," +
                "horario_disponivel TEXT," +
                "agendado_por TEXT," +
                "agendado_em DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS scheduled");
        onCreate(db);
    }

    public List<Scheduled> getAllScheduled() {
        List<Scheduled> Scheduleds = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM scheduled", null);
        if (cursor.moveToFirst()) {
            do {
                Scheduleds.add(new Scheduled(
                        cursor.getString(cursor.getColumnIndexOrThrow("endereco")),
                        cursor.getString(cursor.getColumnIndexOrThrow("andar")),
                        cursor.getString(cursor.getColumnIndexOrThrow("sala")),
                        cursor.getString(cursor.getColumnIndexOrThrow("data_disponivel")),
                        cursor.getString(cursor.getColumnIndexOrThrow("horario_disponivel")),
                        cursor.getString(cursor.getColumnIndexOrThrow("agendado_por")),
                        cursor.getString(cursor.getColumnIndexOrThrow("agendado_em"))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return Scheduleds;
    }

    public void createScheduled(Scheduled scheduled){
        SQLiteDatabase db = getReadableDatabase();

        String sql = "INSERT INTO scheduled (endereco, andar, sala, data_disponivel, horario_disponivel, criado_por) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] bindArgs = {
                scheduled.getEndereco(),
                scheduled.getAndar(),
                scheduled.getSala(),
                scheduled.getDataDisponivel(),
                scheduled.getHorarioDisponivel(),
                scheduled.getAgendadoPor()
        };

        db.execSQL(sql, bindArgs);
        db.close();
    }
}
