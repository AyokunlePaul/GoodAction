package com.goodaction.presentation.authentication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.transition.TransitionManager
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.goodaction.R
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentGettingStartedBinding
import com.goodaction.presentation.authentication.AuthenticationActivityViewModel
import com.goodaction.utils.authentication.GoogleSignInContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import kotlin.properties.Delegates

@AndroidEntryPoint
class GettingStartedFragment : BaseFragment<FragmentGettingStartedBinding>() {

    private val viewModel by hiltNavGraphViewModels<AuthenticationActivityViewModel>(
        R.navigation.nav_authentication
    )
    private val signInClient by lazy {
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestProfile()
            .requestEmail()
            .requestId()
            .build()
        GoogleSignIn.getClient(requireContext(), signInOptions)
    }
    private val callbackManager = CallbackManager.Factory.create()

    private lateinit var googleSignInResult: ActivityResultLauncher<Unit>

    private var signInType: Int by Delegates.observable(TYPE_NORMAL) { _, _, newValue ->
        with(binding) {
            TransitionManager.beginDelayedTransition(binding.root)
            if (newValue == TYPE_SOCIAL) {
                gpSocialLogin.visibility = View.GONE
                tvGettingStarted.text = getString(R.string.confirm_details)
            } else {
                gpSocialLogin.visibility = View.VISIBLE
                tvGettingStarted.text = getString(R.string.getting_started)
            }
        }
    }

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentGettingStartedBinding {
        return FragmentGettingStartedBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        registerGoogleActivityResult()
        registerFacebookCallback()
        onBackPressed {
            if (signInType == TYPE_SOCIAL) clearSocialInput()
            else navigateUp()
        }
        with(binding) {
            btnCreateAccount.setOnClickListener {
                val direction = GettingStartedFragmentDirections
                    .actionFragmentGettingStartedToFragmentVerificationMethod()
                navigate(direction)
            }
            cvFacebook.setOnClickListener {
                signInType = TYPE_SOCIAL
            }
            cvGoogle.setOnClickListener { authenticateUserWithGoogle() }
            btnLogin.setOnClickListener {
                val direction =
                    GettingStartedFragmentDirections.actionFragmentGettingStartedToFragmentSignIn()
                navigate(direction)
            }
        }
    }

    private fun authenticateUserWithGoogle() {
        googleSignInResult.launch(Unit)
    }

    private fun registerGoogleActivityResult() {
        googleSignInResult = registerForActivityResult(GoogleSignInContract(signInClient)) {
            it?.let { account ->
                with(binding) {
                    etFirstName.setText(account.givenName)
                    etLastName.setText(account.familyName)
                    etEmail.setText(account.email)
                }
                signInType = TYPE_SOCIAL
            }
        }
    }

    private fun registerFacebookCallback() {
        LoginManager.getInstance().registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult) {

                }

                override fun onCancel() {

                }

                override fun onError(error: FacebookException?) {
                    Timber.e(error)
                }
            })
    }

    private fun clearSocialInput() {
        with(binding) {
            etFirstName.setText("")
            etLastName.setText("")
            etEmail.setText("")
            signInType = TYPE_NORMAL
        }
    }

    companion object {
        const val TYPE_NORMAL = 0
        const val TYPE_SOCIAL = 1
    }
}