package com.example.thread0120

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_flat_file.*

class FlatFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_file)

        btnSave.setOnClickListener{
            //파일에 기록할 수 있는 스트림 생성
            val fos = openFileOutput("test.txt", Context.MODE_APPEND)
            fos.write(edit.text.toString().toByteArray())
            fos.close()

            edit.setText("")
            Toast.makeText(this,"저장 성공",Toast.LENGTH_LONG).show()

        }

        btnRead.setOnClickListener{
            val fis = openFileInput("test.txt")
            val data = ByteArray(fis.available())
            fis.read(data)
            fis.close()
            //파일의 내용을 문자열로 변환해서 출력
            edit.setText(String(data))
        }
    }
}