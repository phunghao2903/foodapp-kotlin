package com.vku.doancoso3.ui.Login.repository

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository {
    val currentUser:FirebaseUser?= Firebase.auth.currentUser

    fun hasUser():Boolean = Firebase.auth.currentUser != null

    fun getUserId():String = Firebase.auth.currentUser?.uid.orEmpty()


    suspend fun createUser(
        email:String,
        password:String,
        onComple:(Boolean)->Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onComple.invoke(true)
                }else {
                    onComple.invoke(false)
                }
            }.await()

    }

    suspend fun login(
        email:String,
        password:String,
        onComple:(Boolean)->Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onComple.invoke(true)
                }else {
                    onComple.invoke(false)
                }
            }.await()

    }



}