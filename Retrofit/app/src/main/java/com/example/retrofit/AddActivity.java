package com.example.retrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit.Model.PostPutDelMobil;
import com.example.retrofit.Rest.ApiClient;
import com.example.retrofit.Rest.ApiInterface;

public class AddActivity extends AppCompatActivity {

    EditText m_input, t_input;
    Button btn_add, btn_back, btn_upload;
    Context mContext;


    ApiInterface mApiInterface;

    private Bitmap imagePath;
    private Uri filePath;

    private static final int PICK_IMAGE_REQUEST = 234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        m_input = findViewById(R.id.merk_input);
        t_input = findViewById(R.id.type_input);
        btn_add = findViewById(R.id.btn_add);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<PostPutDelMobil> postKontakCall = mApiInterface.postKontak(m_input.getText().toString(), t_input.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelMobil>() {
                    @Override
                    public void onResponse(Call<PostPutDelMobil> call, Response<PostPutDelMobil> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMobil> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btn_back = findViewById(R.id.btn_bac);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });

        btn_upload = findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,  MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            Uri selectedImage = data.getData();

            String[] proj = {MediaStore.Images.Media.DATA};
            CursorLoader loader = new CursorLoader(getApplicationContext(), selectedImage, proj, null, null, null);
            Cursor cursor = loader.loadInBackground();
            if (cursor != null) {
                //blok ini untuk mendapatkan image file path
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                String imagePath = cursor.getString(columnIndex);
                cursor.close();
            }

        }
    }


}
