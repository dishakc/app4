package example.com.app4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivCapturedImage;
    Button btnOpenCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivCapturedImage=(ImageView)findViewById(R.id.ivCapturedImage);
        btnOpenCamera=(Button)findViewById(R.id.btnOpenCamera);
        btnOpenCamera.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent cameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,1001);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(requestCode==1001)
        {
            Bitmap mBitmap = (Bitmap) data.getExtras().get("data");
            ivCapturedImage.setImageBitmap(mBitmap);
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
