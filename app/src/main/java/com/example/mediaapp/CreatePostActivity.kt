package com.example.mediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediaapp.dao.PostDao
import com.example.mediaapp.databinding.ActivityCreatePostBinding
import com.example.mediaapp.databinding.ActivityMainBinding

class CreatePostActivity : AppCompatActivity() {
    private val binding: ActivityCreatePostBinding by lazy {
        ActivityCreatePostBinding.inflate(layoutInflater)
    }
    private lateinit var postDao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        postDao = PostDao()
        binding.postButton.setOnClickListener{
            val input = binding.postInput.text.toString().trim()
            if(input.isNotEmpty()) {
                postDao.addPost(input)
                finish()
            }
        }
    }
}