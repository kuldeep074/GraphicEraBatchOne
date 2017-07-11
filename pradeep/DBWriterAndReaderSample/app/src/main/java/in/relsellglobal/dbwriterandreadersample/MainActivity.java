package in.relsellglobal.dbwriterandreadersample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         db = new DBHandler(this);

         new DBWriter().execute();//call doinbackground dbwriter

         new DBReader().execute();//call doinbackground dbreader


    }

    public class DBWriter extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Student student1 = new Student();
            student1.setStudentName("anil");
            student1.setStudentRollNo(1);
            db.addStudentData(student1);

            Student student2 = new Student();
            student2.setStudentName("sunil");
            student2.setStudentRollNo(2);
            db.addStudentData(student2);

            return null;
        }
    }


    public class DBReader extends AsyncTask<Void,Void,Student> {

        @Override
        protected Student doInBackground(Void... params) {
            Student student = db.fetchStudentData(1);
            return student;
        }

        @Override
        protected void onPostExecute(Student student) {
            super.onPostExecute(student);
            Toast.makeText(MainActivity.this,"Student for Roll No 1 is = "+student.getStudentName(),Toast.LENGTH_LONG).show();

        }
    }


}
