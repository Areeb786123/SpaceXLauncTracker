package com.areeb.spacexlaunchtracker.domain.models.response

data class Payload(
    val customers: List<String>,
    val manufacturer: String,
    val nationality: String,
    val norad_id: List<Any>,
    val orbit: String,
    val orbit_params: OrbitParams,
    val payload_id: String,
    val payload_mass_kg: Int,
    val payload_mass_lbs: Int,
    val payload_type: String,
    val reused: Boolean
)