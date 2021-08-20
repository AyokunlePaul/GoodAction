package com.goodaction.utils.authentication

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import timber.log.Timber

class GoogleSignInContract(
    private val client: GoogleSignInClient
) : ActivityResultContract<Unit, GoogleSignInAccount?>() {

    override fun createIntent(context: Context, input: Unit): Intent = client.signInIntent

    override fun parseResult(resultCode: Int, intent: Intent?): GoogleSignInAccount? = try {
        val signInTask = GoogleSignIn.getSignedInAccountFromIntent(intent)
        signInTask.getResult(ApiException::class.java)
    } catch (exception: ApiException) {
        Timber.e(exception)
        null
    }
}