package jp.ac.std.it_college.s22019.camera_intent_sample

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import jp.ac.std.it_college.s22019.camera_intent_sample.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var imageuri: Uri? = null

    private val cameraLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result?.resultCode == RESULT_OK) {
            binding.ivCamera.setImageURI(imageuri)

            val bitmap = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
                result.data?.getParcelableExtra("data", Bitmap::class.java)
            } else {
                result.data?.getParcelableExtra("data")
            }
            binding.ivCamera.setImageBitmap(bitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivCamera.setOnClickListener{ onCameraImageClick() }
    }

    private fun onCameraImageClick() {
        val timestamp = SimpleDateFormat("yyyyMMddHHmmss", Locale.ROOT).format(Date())
        val fileName = "CameraIntentSamplePhoto_${timestamp}.jpg"

        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)  // ファイル名の指定
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg") // ファイル形式の指定
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraIntentSample") // 保存ディレクトリの指定
        }

        imageuri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            putExtra(MediaStore.EXTRA_OUTPUT, imageuri)
        }
        cameraLauncher.launch(intent)
    }
}