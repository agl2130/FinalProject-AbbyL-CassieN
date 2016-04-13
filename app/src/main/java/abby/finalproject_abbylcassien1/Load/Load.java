package abby.finalproject_abbylcassien1.Load;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.io.File;
import java.net.URI;

import abby.finalproject_abbylcassien1.MainActivity;
import abby.finalproject_abbylcassien1.R;

public class Load extends AppCompatActivity {
    private static final int Request_TakePhoto = 1;
    private static final int Request_ImportPhoto = 2;
    public final static String EXTRA_IMAGE = "image";


    private ImageView imageView;
    private File photoFile;
    private String imageFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);

    }

    public void takePhoto(View view) {
        //goes to camera but for now its going to add an item
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoFile = createImageFile();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
        startActivityForResult(intent, Request_TakePhoto);

    }

    private File createImageFile() {
        imageFileName = "JPEG_" + System.currentTimeMillis() + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(storageDir.getAbsolutePath(), imageFileName);
    }

    public void importPhoto(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, Request_ImportPhoto);
    }

    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;
        if (requestCode == Request_TakePhoto) {

            Intent intent2 = new Intent(this, AddClothes.class);
            intent2.putExtra(EXTRA_IMAGE, new URI(photoFile.getAbsolutePath()));
            startActivity(intent2);
            Toast.makeText(Load.this, "Adding item!", Toast.LENGTH_SHORT).show();
            //           setPic();
        } else if (requestCode == Request_ImportPhoto) {
//            try{
//
            Intent intent2 = new Intent(this, AddClothes.class);
            intent2.putExtra(EXTRA_IMAGE, photoFile.getAbsolutePath());
            startActivity(intent2);
            Toast.makeText(Load.this, "Adding item!", Toast.LENGTH_SHORT).show();
//                   decodeUri(data.getData());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
        }
    }

    //    private void setPic() {
//        int targetW = imageView.getWidth();
//        int targetH = imageView.getHeight();
//
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        bmOptions.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(photoFile.getAbsolutePath(), bmOptions);
//        int photoW = bmOptions.outWidth;
//        int photoH = bmOptions.outHeight;
//
//        int scalefactor = Math.min(photoW / targetW, photoH / targetH);
//
//        bmOptions.inJustDecodeBounds = false;
//        bmOptions.inSampleSize = scalefactor;
//
//        Bitmap bitmap = BitmapFactory.decodeFile(photoFile.getAbsolutePath(), bmOptions);
//        imageView.setImageBitmap(bitmap);
//    }
//
//    public void decodeUri(Uri uri) throws FileNotFoundException{
//        int targetW = imageView.getWidth();
//        int targetH = imageView.getHeight();
//
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//
//        bmOptions.inJustDecodeBounds=true;
//        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null,bmOptions);
//        int photoW =bmOptions.outWidth;
//        int photoH =bmOptions.outHeight;
//
//        int scaleFactor = Math.min(photoW/targetW, photoH/targetH );
//
//        bmOptions.inJustDecodeBounds=false;
//        bmOptions.inSampleSize=scaleFactor;
//
//        Bitmap image = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, bmOptions);
//        imageView.setImageBitmap(image);
//
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //copy this to all the pages...
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //this takes you back to home, but it makes you log back in!!!!!
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            case R.id.log_out:
                rootRef.unauth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
