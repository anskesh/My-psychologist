package com.efimcompany.mypsychologist.models

data class CommonModel(
    val id: String = "",
    var startName: String = "",
    var name: String = "",
    var phone: String = "",
    var photoUrl: String = "empty",
    val description: String = "",

    var text: String = "",
    var type: String = "",
    var from: String = "",
    var timestamp: String = "",
    var statusSMS: Boolean = true
)