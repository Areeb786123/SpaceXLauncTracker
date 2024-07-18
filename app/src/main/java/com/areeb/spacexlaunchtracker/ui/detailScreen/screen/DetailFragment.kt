package com.areeb.spacexlaunchtracker.ui.detailScreen.screen

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.areeb.spacexlaunchtracker.MainActivity
import com.areeb.spacexlaunchtracker.R
import com.areeb.spacexlaunchtracker.data.ApiConstant
import com.areeb.spacexlaunchtracker.databinding.FragmentDetailBinding
import com.areeb.spacexlaunchtracker.ui.common.fragment.BaseFragment
import com.areeb.spacexlaunchtracker.ui.main.viewModel.HomeViewModel
import com.areeb.spacexlaunchtracker.utils.extensionFunction.toCustomDateFormat
import dagger.hilt.android.AndroidEntryPoint
import java.util.function.LongFunction

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<HomeViewModel>()
    private val mainActivity by lazy { (activity as MainActivity) }
    private val currentMission by lazy {
        viewModel.currentMission.value
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Handle back press
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        onBackKeyPress(
            if (viewModel.getIsFav() == false) DetailFragmentDirections.actionDetailFragmentToHomeFragment() else DetailFragmentDirections.actionDetailFragmentToFavFragment(),
            if (viewModel.getIsFav() == false) R.id.homeFragment else R.id.favFragment
        )
        return _binding!!.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, currentMission.toString())
        youTubeIframePlayer()
        setViews()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setViews() {
        with(binding) {
            tvMissionDate.text = currentMission?.launch_date_local?.toCustomDateFormat()
            tvMissionName.text = currentMission?.mission_name
            currentMission?.let {
                tvPayloadMass.text =
                    "Payload Mass in kg - ${it.rocket.second_stage.payloads[0].payload_mass_kg}"
                tvRocketId.text = "Rocket Id - ${it.rocket.rocket_id}"
                tvRocketName.text = "Rocket Name -${it.rocket.rocket_name}"
                tvRocketType.text = "Rocket Type - ${it.rocket.rocket_type}"
                tvPayloadId.text = "Payload Id - ${it.rocket.second_stage.payloads[0].payload_id}"
                tvReused.text = "ReUsed - ${it.rocket.second_stage.payloads[0].reused.toString()}"
                tvOrbit.text = "Orbit - ${it.rocket.second_stage.payloads[0].orbit}"
                tvSiteAddress.text = it.launch_site.site_name_long
            }

            tvReadMore.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                if (currentMission?.links?.article_link?.isNotEmpty() == true) {
                    intent.data = Uri.parse(currentMission?.links?.article_link)
                }

                startActivity(intent)
            }

        }
    }

    private fun youTubeIframePlayer() {
        binding.youtubePlayerWebview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return false
            }
        }

        val webSettings: WebSettings = binding.youtubePlayerWebview.settings
        webSettings.javaScriptEnabled = true
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        if (currentMission?.links?.youtube_id?.isNotEmpty() == true) {
            val html = """
            <html>
            <body style="margin:0;padding:0;">
            <iframe width="100%" height="100%" src="https://www.youtube.com/embed/${currentMission!!.links.youtube_id}" frameborder="0" ></iframe>
            </body>
            </html>
        """.trimIndent()
            binding.youtubePlayerWebview.loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
        }
    }

    companion object {
        private const val TAG = "detailScreen"
    }


}