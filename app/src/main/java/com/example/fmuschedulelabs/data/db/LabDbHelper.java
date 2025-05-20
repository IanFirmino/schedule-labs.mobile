package com.example.fmuschedulelabs.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fmuschedulelabs.data.model.Lab;

import java.util.ArrayList;
import java.util.List;

public class LabDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "labs.db";
    private static final int DATABASE_VERSION = 1;

    public LabDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE labs (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "endereco TEXT," +
                "andar TEXT," +
                "sala TEXT," +
                "data_disponivel TEXT," +
                "horario_disponivel TEXT)";
        db.execSQL(SQL_CREATE_TABLE);

        db.execSQL("INSERT INTO labs (endereco, andar, sala, data_disponivel, horario_disponivel) VALUES " +
                "('Liberdade, 1000', '2º', '203', '2025-05-22', '10:00')," +
                "('Rua Alba, 45', '6º', '301', '2025-05-23', '14:00')," +
                "('Rua Tagua, 312', '3º', '105', '2025-05-23', '16:00')");;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS labs");
        onCreate(db);
    }

    public List<Lab> getAllLabs() {
        List<Lab> labs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM labs", null);
        if (cursor.moveToFirst()) {
            do {
                labs.add(new Lab(
                        cursor.getString(cursor.getColumnIndexOrThrow("endereco")),
                        cursor.getString(cursor.getColumnIndexOrThrow("andar")),
                        cursor.getString(cursor.getColumnIndexOrThrow("sala")),
                        cursor.getString(cursor.getColumnIndexOrThrow("data_disponivel")),
                        cursor.getString(cursor.getColumnIndexOrThrow("horario_disponivel"))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return labs;
    }

    public void createLab(Lab lab){
        SQLiteDatabase db = getReadableDatabase();

        String sql = "INSERT INTO labs (endereco, andar, sala, data_disponivel, horario_disponivel) VALUES (?, ?, ?, ?, ?)";
        Object[] bindArgs = {
                lab.getEndereco(),
                lab.getAndar(),
                lab.getSala(),
                lab.getDataDisponivel(),
                lab.getHorarioDisponivel()
        };

        db.execSQL(sql, bindArgs);
    }

}
