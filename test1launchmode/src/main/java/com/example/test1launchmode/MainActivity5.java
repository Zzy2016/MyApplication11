package com.example.test1launchmode;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * FileProvider
 *
 * AndroidManifest
 *
 * xml/path
 *
 *
 * */
public class MainActivity5 extends AppCompatActivity {


    File photoFile;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
//        }

        img = findViewById(R.id.img);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                photoFile = null;
                try {
                    photoFile = createFile();
                } catch (Exception e) {

                }
                if (photoFile != null) {
                    Uri photoUri = FileProvider.getUriForFile(MainActivity5.this, "com.example.test1launchmode.fileprovider", photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(intent, 1);
                }

            }
        });
    }

    String currentPhotoPath;

    private File createFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        Log.e("------", currentPhotoPath + "   " + image.length());
        return image;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1 && resultCode == -1) {

            try {
                Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(photoFile));
                Matrix matrix=new Matrix();
                matrix.postRotate(90);
                bitmap=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
                img.setImageBitmap(bitmap);


                MediaStore.Images.Media.insertImage(getContentResolver(), photoFile.getAbsolutePath(), photoFile.getName(), null);
                // 最后通知图库更新
//                Uri photoUri = FileProvider.getUriForFile(MainActivity5.this, "com.example.test1launchmode.fileprovider", photoFile);

//                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(photoFile)));
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,FileProvider.getUriForFile(MainActivity5.this, "com.example.test1launchmode.fileprovider", photoFile)));
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(photoFile));


//                try {
//                    ExifInterface exifInterface=new ExifInterface(photoFile.getAbsolutePath());
////                    ExifInterface exifInterface = new ExifInterface(photoFile.getAbsolutePath());
//                    Log.e("旋转",currentPhotoPath+"   "+photoFile.getAbsolutePath()+"  "+photoFile.getAbsoluteFile());
//                    int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
//                    switch (orientation) {
//                        case ExifInterface.ORIENTATION_ROTATE_90:
////                            try {
//////                                Bitmap bitmap1=BitmapFactory.decodeFile(photoFile.getName());
////                                bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(photoFile));
////                            }catch (Exception e){
////
////                            }
//                            break;
//                    }
//                    Toast.makeText(MainActivity5.this, "旋转--" + orientation, Toast.LENGTH_LONG).show();
//                } catch (Exception e) {
//
//                }

//                Intent intent = new Intent(
//                        Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//                intent.setData(Uri.fromFile(photoFile));
//                sendBroadcast(intent);
//                MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "", "");


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


}