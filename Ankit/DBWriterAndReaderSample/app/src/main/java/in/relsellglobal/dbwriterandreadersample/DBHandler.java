package in.relsellglobal.dbwriterandreadersample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anilkukreti on 13/05/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "students.db";
    public static final int DATABASE_VERSION = 1;
    public static final String STUDENT_TABLE = "student";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ROLL_NO = "roll_no";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + STUDENT_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_ROLL_NO + " TEXT" + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void addStudentData(Student obj) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,obj.getStudentName());
        values.put(KEY_ROLL_NO,obj.getStudentRollNo());

        // Inserting Row
        db.insert(STUDENT_TABLE, null, values);
        db.close(); // Closing database connection

    }

    public void removeStudentData(Student obj) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(STUDENT_TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getStudentId()) });
        db.close();

    }

    public int updateStudentData(Student obj) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, obj.getStudentName());
        values.put(KEY_ROLL_NO, obj.getStudentRollNo());

        // updating row
        return db.update(STUDENT_TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getStudentId()) });

    }

    public Student fetchStudentData(int rollNo) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(STUDENT_TABLE, new String[] { KEY_ID,
                        KEY_NAME, KEY_ROLL_NO }, KEY_ROLL_NO + "=?",
                new String[] { String.valueOf(rollNo) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student();
        student.setStudentId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
        student.setStudentName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
        student.setStudentRollNo(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ROLL_NO)));

        return student;
    }


}
