package com.efimcompany.mypsychologist.utilits

import com.efimcompany.mypsychologist.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var AUTH: FirebaseAuth
lateinit var UID: String
lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var USER: User

const val NODE_PSYCHOLOGIST = "psychologist_contacts"
const val CHILD_DESCRIPTION = "description"
const val TYPE_TEXT = "text"

const val NODE_USERS = "users"
const val CHILD_ID = "id"
const val CHILD_USER_NAME_START = "startName"
const val CHILD_USER_NAME = "name"
const val CHILD_PHONE = "phone"
const val CHILD_TEXT = "text"
const val CHILD_TYPE = "type"
const val CHILD_FROM = "from"
const val CHILD_TIME = "timestamp"
